/**
 *
 */
package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.PurchaseHistoryDAO;
import com.internousdev.template.dto.PurchaseDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 購入履歴情報を取得するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/30
 * @version 1.0
 */

public class PurchaseHistoryAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 2691527162985622987L;

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
	 * 注文数
	 */
	private int order_count;

	/**
	 * 小計
	 */
	private BigDecimal sub_total;

	/**
	 * 購入日
	 */
	private String purchase_date;

	/**
	 * 購入履歴情報リスト
	 */
	private ArrayList<PurchaseDTO> purchaseHistoryList = new ArrayList<PurchaseDTO>();



	/**
	 * 購入履歴を取得するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/30
	 * @version 1.0
	 * @return SUCCESS or ERROR
	 */

	public String execute() {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			PurchaseHistoryDAO dao = new PurchaseHistoryDAO();
			purchaseHistoryList = dao.purchaseHistoryList(user_id);


			if(purchaseHistoryList.size() != 0) {
				result = SUCCESS;

			} else {
				result = SUCCESS;
			}
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
	 * @return purchase_date
	 */
	public String getPurchase_date() {
		return purchase_date;
	}





	/**
	 * @param purchase_date セットする purchase_date
	 */
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}





	/**
	 * @return purchaseHistoryList
	 */
	public ArrayList<PurchaseDTO> getPurchaseHistoryList() {
		return purchaseHistoryList;
	}





	/**
	 * @param purchaseHistoryList セットする purchaseHistoryList
	 */
	public void setPurchaseHistoryList(ArrayList<PurchaseDTO> purchaseHistoryList) {
		this.purchaseHistoryList = purchaseHistoryList;
	}

}