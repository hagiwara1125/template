package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ZCartInsertDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * カートに特定の商品を格納するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/16
 * @version 1.0
 */
public class ZCartInsertAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 5672962007419891754L;

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
	 * 商品価格
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
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> itemList;

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList;



	/**
	 * 実行メソッド
	 * カートに特定の商品を追加できたらSUCCESSを返す
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/16
	 * @version 1.0
	 * @return success or error
	 */
	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");
			ZCartInsertDAO dao = new ZCartInsertDAO();
			itemList = dao.itemStatus(item_id);

			cartList = dao.selected(user_id);
			for(int i = 0; i < cartList.size(); i++) {
				if(cartList.get(i).getItem_id() == item_id) {
					if(itemList.get(0).getItem_stock() - cartList.get(i).getOrder_count() - order_count < 0) {
						order_count = itemList.get(i).getItem_stock();
					} else {
						order_count += cartList.get(i).getOrder_count();
						if(order_count > 30) {
							order_count = 30;
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
	 * セッション情報を取得するためのメソッド
	 * @return session セッション情報
	 */
	public Map<String, Object> GetSession() {
		return session;
	}

	/**
	 * セッション情報を格納するためのメソッド
	 * @param session セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * ユーザーIDを取得するためのメソッド
	 * @return user_id ユーザーID
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	* ユーザーIDを格納するためのメソッド
	* @param user_id ユーザーID
	*/
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * カートIDを取得するためのメソッド
	 * @return cart_id カートID
	 */
	public int getCart_id() {
		return cart_id;
	}

	/**
	 * カートIDを格納するためのメソッド
	 * @param cart_id カートID
	 */
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	/**
	 * 商品IDを取得するためのメソッド
	 * @return item_id 商品ID
	 */
	public int getItem_id() {
		return item_id;
	}

	/**
	 * 商品IDを格納するためのメソッド
	 * @param item_id 商品ID
	 */
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	/**
	 * 商品名を取得するためのメソッド
	 * @return item_name 商品名
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * 商品名を格納するためのメソッド
	 * @param item_name 商品名
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * 商品価格を取得するためのメソッド
	 * @return item_price 商品価格
	 */
	public BigDecimal getItem_price() {
		return item_price;
	}

	/**
	 * 商品価格を格納するためのメソッド
	 * @param item_price 商品価格
	 */
	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}

	/**
	 * 注文数を取得するためのメソッド
	 * @return order_count 注文数
	 */
	public int getOrder_count() {
		return order_count;
	}

	/**
	 * 注文数を格納するためのメソッド
	 * @param order_count 注文数
	 */
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	/**
	 * 小計を取得するためのメソッド
	 * @return sub_total 小計
	 */
	public BigDecimal getSub_total() {
		return sub_total;
	}

	/**
	 * 小計を格納するためのメソッド
	 * @param sub_total 小計
	 */
	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	/**
	 * 商品情報リストを取得するためのメソッド
	 * @return itemList 商品情報リスト
	 */
	public ArrayList<ItemDTO> itemList() {
		return itemList;
	}

	/**
	 * 商品情報リストを格納するためのメソッド
	 * @param itemList 商品情報リスト
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}

	/**
	 * カート情報リストを取得するためのメソッド
	 * @return cartList カート情報リスト
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * カート情報リストを格納するためのメソッド
	 * @param cartList カート情報リスト
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}


}