package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dao.CartUpdateDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * カート内の商品の注文数を変更するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartUpdateAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -7315268366683434355L;

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
	 * 画像パス
	 */
	private String img_path;

	/**
	 * 小計
	 */
	private BigDecimal sub_total = BigDecimal.ZERO;

	/**
	 * 合計金額
	 */
	private BigDecimal total_price = BigDecimal.ZERO;

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	/**
	 * 更新処理件数
	 */
	private int updateCount;



	/**
	 * カート内の商品の注文数を更新するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @return SUCCESS:更新成功, ERROR:更新失敗, LOGIN:ログイン画面
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");
			CartUpdateDAO cUpDao = new CartUpdateDAO();
			CartSelectDAO cSeDao = new CartSelectDAO();
			ArrayList<CartDTO> itemStatus = new ArrayList<CartDTO>();
			itemStatus = cUpDao.itemStatus(cart_id);

			if(order_count <= itemStatus.get(0).getItem_stock()) {
				sub_total = itemStatus.get(0).getItem_price().multiply(BigDecimal.valueOf(order_count));

				//商品情報をカートに追加
				updateCount = cUpDao.updateCart(cart_id, user_id, order_count, sub_total);
				//アレイリストに追加
				cartList = cSeDao.selectedItem(user_id);

				if(updateCount > 0) {
					if(cartList.size() > 0) {
						for(int i = 0; i < cartList.size(); i++) {
							sub_total = (cartList.get(i).getItem_price()).multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count()));
							cartList.get(i).setSub_total(sub_total);
						}
						result = SUCCESS;
					}
				}

			}
		}


		System.out.println("CartUpdateAction - result : " + result);

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
	 * @param item_id セットする item_id
	 */
	public void setItem_id(int item_id) {
		this.item_id = item_id;
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
	 * @return img_path
	 */
	public String getImg_path() {
		return img_path;
	}



	/**
	 * @param img_path セットする img_path
	 */
	public void setImg_path(String img_path) {
		this.img_path = img_path;
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
	 * @return total_price
	 */
	public BigDecimal getTotal_price() {
		return total_price;
	}



	/**
	 * @param total_price セットする total_price
	 */
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
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



	/**
	 * @return updateCount
	 */
	public int getUpdateCount() {
		return updateCount;
	}



	/**
	 * @param updateCount セットする updateCount
	 */
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}

}