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
	 * 購入日を取得するためのメソッド
	 * @return purchase_date 購入日
	 */
	public String getPurchase_date() {
		return purchase_date;
	}

	/**
	 * 購入日を格納するためのメソッド
	 * @param purchase_date 購入日
	 */
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	/**
	 * 購入履歴情報リストを取得するためのメソッド
	 * @return purchaseHistoryList 購入履歴情報リスト
	 */
	public ArrayList<PurchaseDTO> getPurchaseHistoryList() {
		return purchaseHistoryList;
	}

	/**
	 * 購入履歴情報リストを格納するためのメソッド
	 * @param purchaseHistoryList 購入履歴情報リスト
	 */
	public void setPurchaseHistoryList(ArrayList<PurchaseDTO> purchaseHistoryList) {
		this.purchaseHistoryList = purchaseHistoryList;
	}

}