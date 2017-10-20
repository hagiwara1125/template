package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ZCartDeleteDAO;
import com.internousdev.template.dao.ZCartSelectDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.ZCartAssist;

/**
 * カートの中身を削除するためのクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/16
 * @version 1.0
 */
public class ZCartDeleteAction extends ZCartAssist implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 8186904234531748368L;

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
	private BigDecimal total_price = BigDecimal.ZERO;

	/**
	 * 削除処理をした件数
	 */
	private int delCount;

	/**
	 * 検索したカート内の商品情報リスト
	 */
	private List<CartDTO> cartList = new ArrayList<>();



	/**
	 * カートの中身を削除するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/16
	 * @version 1.0
	 */
	public String execute() throws SQLException {
		String result = ERROR;


		//セッション情報切れになっていないかの確認
		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			ZCartDeleteDAO dao = new ZCartDeleteDAO();
			ZCartSelectDAO dao2 = new ZCartSelectDAO();

			delCount = dao.delete(user_id, cart_id);
			if(delCount > 0) {
				cartList = dao2.selectedItem(user_id);
				if(cartList.size() > 0) {
					for(int i = 0; i < cartList.size(); i++) {
						total_price = total_price.add((cartList.get(i).getItem_price()).multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count())));
						cartList.get(i).setSub_total(total_price);
					}
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
	 * 合計金額を取得するためのメソッド
	 * @return total_price 合計金額
	 */
	public BigDecimal getTotal_price() {
		return total_price;
	}

	/**
	 * 合計金額を格納するためのメソッド
	 * @param total_price 合計金額
	 */
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	/**
	 * 削除処理をした件数を取得するためのメソッド
	 * @return delCount 削除処理をした件数
	 */
	public int getDelCount() {
		return delCount;
	}

	/**
	 * 削除処理をした件数を格納するためのメソッド
	 * @param delCount 削除処理をした件数
	 */
	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}

	/**
	 * 検索したカート内の商品情報リストを取得するためのメソッド
	 * @return cartList 検索したカート内の商品情報リスト
	 */
	public List<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * 検索したカート内の商品情報リストを格納するためのメソッド
	 * @param cartList 検索したカート内の商品情報リスト
	 */
	public void setCartList(List<CartDTO> cartList) {
		this.cartList = cartList;
	}

}
