package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartDeleteDAO;
import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * カート内の商品を削除するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartDeleteAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 2981545994323859728L;

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
	 * 注文数
	 */
	private int order_count;

	/**
	 * 合計金額
	 */
	private BigDecimal sub_total = BigDecimal.ZERO;

	/**
	 * 削除回数
	 */
	private int delCount;

	/**
	 * カート情報リスト
	 */
	private List<CartDTO> cartList = new ArrayList<>();



	/**
	 * カート内の商品を削除するための実行メソッド
	 * @author HINAKO HAGIWRA
	 * @since 2017/10/23
	 * @version 1.0
	 * @return SUCCESS:削除成功, ERROR:削除失敗
	 */

	public String execute() {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			CartDeleteDAO dao = new CartDeleteDAO();
			CartSelectDAO dao2 = new CartSelectDAO();

			delCount = dao.delete(user_id, cart_id); //カート内削除
			if(delCount > 0) { //削除回数が1より多い場合
				cartList = dao2.selectedItem(user_id); //カート内情報
				if(cartList.size() > 0) { //カートサイズが0より多い場合
					for(int i = 0; i < cartList.size(); i++) {
						sub_total = sub_total.add((cartList.get(i).getItem_price()).multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count()))); //小計
						cartList.get(i).setSub_total(sub_total);
					}

					result = SUCCESS;
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
	 * 削除回数を取得するためのメソッド
	 * @return delCount 削除回数
	 */
	public int getDelCount() {
		return delCount;
	}

	/**
	 * 削除回数を格納するためのメソッド
	 * @param delCount 削除回数
	 */
	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}

	/**
	 * カート情報リストを取得するためのメソッド
	 * @return cartList カート情報リスト
	 */
	public List<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * カート情報リストを格納するためのメソッド
	 * @param cartList カート情報リスト
	 */
	public void setCartList(List<CartDTO> cartList) {
		this.cartList = cartList;
	}

}