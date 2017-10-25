package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dao.ItemDetailDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * 商品詳細を表示するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/22
 * @version 1.0
 */

public class ItemDetailAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 5232703757934972869L;

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
	 * 商品ID
	 */
	private int item_category;

	/**
	 * 商品名
	 */
	private String item_name;

	/**
	 * 価格
	 */
	private BigDecimal item_price;

	/**
	 * 在庫数
	 */
	private int item_stock;

	/**
	 * 画像パス
	 */
	private String img_path;

	/**
	 * 商品説明
	 */
	private String item_comment;

	/**
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * データベースから取得した商品情報リスト
	 */
	private ArrayList<ItemDTO> selectList = new ArrayList<>();



	/**
	 * 商品詳細を表示するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/22
	 * @version 1.0
	 * @return SUCCESS or ERROR
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if (session.containsKey("user_id")) {
			user_id = (int) session.get("user_id");
			//カート情報の取得
			CartSelectDAO cartDao = new CartSelectDAO();
			cartList = cartDao.selectedItem(user_id);
		}

        ItemDetailDAO dao = new ItemDetailDAO();
        displayList = dao.select(item_id);

        for(int i=0;i < selectList.size();i++){

			int userStock = selectList.get(i).getItem_stock();

			for(int j=0;j<cartList.size();j++){
				if(selectList.get(i).getItem_id() == cartList.get(j).getItem_id()){
					userStock -= cartList.get(j).getOrder_count();
				}
			}
			selectList.get(i).setUser_stock(userStock);
		}

        if(displayList.size() != 0) {
        	this.item_name = displayList.get(0).getItem_name();
        	this.img_path = displayList.get(0).getImg_path();
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
	 * @return item_stock
	 */
	public int getItem_stock() {
		return item_stock;
	}


	/**
	 * @param item_stock セットする item_stock
	 */
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
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
	 * @return item_comment
	 */
	public String getItem_comment() {
		return item_comment;
	}


	/**
	 * @param item_comment セットする item_comment
	 */
	public void setItem_comment(String item_comment) {
		this.item_comment = item_comment;
	}


	/**
	 * @return displayList
	 */
	public ArrayList<ItemDTO> getDisplayList() {
		return displayList;
	}


	/**
	 * @param displayList セットする displayList
	 */
	public void setDisplayList(ArrayList<ItemDTO> displayList) {
		this.displayList = displayList;
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

}
