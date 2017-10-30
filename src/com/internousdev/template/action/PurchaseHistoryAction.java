/**
 *
 */
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.PurchaseHistorySelectDAO;
import com.internousdev.template.dto.ItemDTO;
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
	private String user_id;

	/**
	 * 購入履歴情報リスト
	 */
	private ArrayList<PurchaseDTO> purchaseList = new ArrayList<PurchaseDTO>();

	/**
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();



	/**
	 * 購入履歴を取得するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/30
	 * @version 1.0
	 * @return SUCCESS or ERROR
	 */

	public String execute() {
		String result = ERROR;

		PurchaseHistorySelectDAO dao = new PurchaseHistorySelectDAO();
		if(dao.selectPurchaseHistory(user_id, "", "", "", "", "")) {
			purchaseList = dao.getPurchaseList();
			itemList = dao.getItemList();
		}

		result = SUCCESS;

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
	public String getUser_id() {
		return user_id;
	}





	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}





	/**
	 * @return purchaseList
	 */
	public ArrayList<PurchaseDTO> getPurchaseList() {
		return purchaseList;
	}





	/**
	 * @param purchaseList セットする purchaseList
	 */
	public void setPurchaseList(ArrayList<PurchaseDTO> purchaseList) {
		this.purchaseList = purchaseList;
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