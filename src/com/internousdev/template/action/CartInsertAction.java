package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartInsertDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カートに商品を追加するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartInsertAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 2673132052167697437L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * カートID
	 */
	private int cart_id;

	/**
	 * 商品ID
	 */
	private int item_id;

	/**
	 * 商品名
	 */
	private String item_name;

	/**
	 * 価格
	 */
	private BigDecimal item_price;

	/**
	 * 注文数
	 */
	private int order_count;

	/**
	 * 小計
	 */
	private BigDecimal sub_total = BigDecimal.ZERO;

	/**
	 * 商品説明
	 */
	private String item_comment;

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList;

	/**
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> itemList;



	/**
	 * カートに商品を追加するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @verion 1.0
	 * @return SUCCESS:商品追加, ERROR:失敗, LOGIN:ログイン画面
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("user_id")){
			user_id = (int)session.get("user_id");

			CartInsertDAO dao = new CartInsertDAO();
			itemList = dao.itemStatus(item_id);
			cartList = dao.selected(user_id);

			for(int i = 0; i < cartList.size(); i++) {
				if(cartList.get(i).getItem_id() == item_id) {
					if(itemList.get(0).getItem_stock() - cartList.get(i).getOrder_count() - order_count < 0) {
						order_count = itemList.get(i).getItem_stock();
					} else {
						order_count += cartList.get(i).getOrder_count();
						if(order_count > 20) {
							order_count = 20;
						}
					}
					sub_total = itemList.get(0).getItem_price().multiply(BigDecimal.valueOf(order_count));
					dao.update(order_count, user_id, item_id, sub_total);
					result = SUCCESS;
					return result;
				}
			}

			if(itemList.get(0).getItem_stock() > 0) {
				sub_total = itemList.get(0).getItem_price().multiply(BigDecimal.valueOf(order_count));
				if(dao.addToCart(user_id, item_id, order_count, sub_total) != 0) {
					result = SUCCESS;
				}
			}
		} else {
			result = LOGIN;
		}

		return result;
	}



	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}



	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	/**
	 * @return user_id
	 */
	public int getUser_id() {
		return user_id;
	}



	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	/**
	 * @return cart_id
	 */
	public int getCart_id() {
		return cart_id;
	}



	/**
	 * @param cart_id セットする cart_id
	 */
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}



	/**
	 * @return item_id
	 */
	public int getItem_id() {
		return item_id;
	}



	/**
	 * @param item_id セットする item_id
	 */
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}



	/**
	 * @return item_name
	 */
	public String getItem_name() {
		return item_name;
	}



	/**
	 * @param item_name セットする item_name
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}



	/**
	 * @return item_price
	 */
	public BigDecimal getItem_price() {
		return item_price;
	}



	/**
	 * @param item_price セットする item_price
	 */
	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}



	/**
	 * @return order_count
	 */
	public int getOrder_count() {
		return order_count;
	}



	/**
	 * @param order_count セットする order_count
	 */
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}



	/**
	 * @return sub_total
	 */
	public BigDecimal getSub_total() {
		return sub_total;
	}



	/**
	 * @param sub_total セットする sub_total
	 */
	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}



	/**
	 * @return item_comment
	 */
	public String getItem_comment() {
		return item_comment;
	}



	/**
	 * @param item_comment セットする item_comment
	 */
	public void setItem_comment(String item_comment) {
		this.item_comment = item_comment;
	}



	/**
	 * @return cartList
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}



	/**
	 * @param cartList セットする cartList
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}



	/**
	 * @return itemList
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}



	/**
	 * @param itemList セットする itemList
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}




}
