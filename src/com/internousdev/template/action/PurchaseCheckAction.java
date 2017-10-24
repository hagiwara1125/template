package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * 購入確認画面に必要な情報を取得し遷移するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/24
 * @version 1.0
 */

public class PurchaseCheckAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 5351535579005550240L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 商品ID
	 */
	private int item_id;

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
	 * クレジットカード情報を照合し、格納するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/24
	 * @version 1.0
	 * @return SUCCESS or ERROR
	 */

	public String execute() {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			CartSelectDAO dao = new CartSelectDAO();

			//アレイリストに情報を入れる
			cartList = dao.selectedItem(user_id);

			for(int i = 0; i < cartList.size(); i++) {

				sub_total = (cartList.get(i).getItem_price()).multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count()));
				cartList.get(i).setSub_total(sub_total);

				total_price = total_price.add(sub_total);
			}

			result = SUCCESS;


		} else {
			result = LOGIN;
		}

		return result;
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
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
