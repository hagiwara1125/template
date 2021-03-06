package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.PurchaseCompleteDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * 決済を完了するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/24
 * @version 1.0
 */

public class PurchaseCompleteAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -900960747089814351L;

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
	 * 小計
	 */
	private BigDecimal sub_total = BigDecimal.ZERO;

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * 購入日
	 */
	private Date purchase_date;



	/**
	 * 購入した商品情報を格納するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/24
	 * @version 1.0
	 * @return SUCCESS or ERROR
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			PurchaseCompleteDAO dao = new PurchaseCompleteDAO();

			//アレイリストに情報を入れる
			cartList = dao.cartSelect(user_id);

			for(int i = 0; i < cartList.size(); i++) {
				sub_total = cartList.get(i).getItem_price().multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count())); //小計
				int new_stock = cartList.get(i).getItem_stock() - cartList.get(i).getOrder_count(); //更新された在庫数

				if(new_stock >= 0) {
					if(dao.purchaseInsert(user_id, cartList.get(i).getItem_id(), cartList.get(i).getOrder_count(), sub_total) != 0) {
						if(dao.stockUpdate(cartList.get(i).getItem_id(), new_stock) > 0) { //在庫数の更新
							result = SUCCESS;
						}
					}

				}

			}

			if(result == SUCCESS) {
				if(dao.cartDelete(user_id) == 0) { //カート内商品削除

					result = ERROR;
				}
			}

		} else {
			result = LOGIN; //未ログイン時
		}

		return result;

	}



	/**
	 * 生成されたシリアルIDを取得するためのメソッド
	 * @return serialversionuid 生成されたシリアルID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * セッション情報を取得するためのメソッド
	 * @return session セッション情報
	 */
	public Map<String, Object> getSession() {
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

	/**
	 * 購入日を取得するためのメソッド
	 * @return purchase_date 購入日
	 */
	public Date getPurchase_date() {
		return purchase_date;
	}

	/**
	 * 購入日を格納するためのメソッド
	 * @param purchase_date 購入日
	 */
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

}