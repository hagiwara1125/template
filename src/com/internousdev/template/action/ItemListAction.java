package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dao.ItemListDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * 商品一覧を表示するためのActoinクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/22
 * @version 1.0
 */

public class ItemListAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 8619602857814970859L;

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
	private int item_category = 0;

	/**
	 * データベースから取得した商品情報リスト
	 */
	private ArrayList<ItemDTO> selectList = new ArrayList<>();

	/**
	 * データベースから取得した商品情報を表示するための情報リスト
	 */
	public ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	/**
	 * データベースから取得した商品情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * ページネーションする全体のページ数
	 */
	private int pageCount;

	/**
	 * ページの限界値
	 */
	private int pageLimit = 12;



	/**
	 * 商品一覧情報を取得するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/22
	 * @version 1.0
	 * @return SUCCESS or ERROR
	 */

	public String execute() {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			//カート情報の取得
			CartSelectDAO cartDao = new CartSelectDAO();
			cartList = cartDao.selectedItem(user_id);

		}

		ItemListDAO dao = new ItemListDAO();
		selectList = dao.select(item_category);

		for(int i = 0; i < selectList.size(); i++) {
			int userStock = selectList.get(i).getItem_stock();

			for(int j = 0; j < cartList.size(); j++) {
				if(selectList.get(i).getItem_id() == cartList.get(j).getItem_id()) {
					userStock -= cartList.get(j).getOrder_count();
				}
			}
			selectList.get(i).setUser_stock(userStock);

			pageCount = itemList.size() / pageLimit;
			if(itemList.size() % pageLimit != 0) {
				pageCount++;

			}

			result = SUCCESS;

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
	 * @return item_category
	 */
	public int getItem_category() {
		return item_category;
	}



	/**
	 * @param item_category セットする item_category
	 */
	public void setItem_category(int item_category) {
		this.item_category = item_category;
	}



	/**
	 * @return selectList
	 */
	public ArrayList<ItemDTO> getSelectList() {
		return selectList;
	}



	/**
	 * @param selectList セットする selectList
	 */
	public void setSelectList(ArrayList<ItemDTO> selectList) {
		this.selectList = selectList;
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
	 * @return pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount セットする pageCount
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return pageLimit
	 */
	public int getPageLimit() {
		return pageLimit;
	}

	/**
	 * @param pageLimit セットする pageLimit
	 */
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

}