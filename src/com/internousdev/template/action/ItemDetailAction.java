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
	 * 商品一覧情報リスト
	 */
	private ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * DBの商品情報リスト
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
	 * 商品カテゴリを取得するためのメソッド
	 * @return item_category 商品カテゴリ
	 */
	public int getItem_category() {
		return item_category;
	}

	/**
	 * 商品カテゴリを格納するためのメソッド
	 * @param item_category 商品カテゴリ
	 */
	public void setItem_category(int item_category) {
		this.item_category = item_category;
	}

	/**
	 * 商品名を取得するためのメソッド
	 * @return item_name 商品名
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * 商品名を格納するためのメソッド
	 * @param item_name 商品名
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * 価格を取得するためのメソッド
	 * @return item_price 価格
	 */
	public BigDecimal getItem_price() {
		return item_price;
	}

	/**
	 * 価格を格納するためのメソッド
	 * @param item_price 価格
	 */
	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}

	/**
	 * 在庫数を取得するためのメソッド
	 * @return item_stock 在庫数
	 */
	public int getItem_stock() {
		return item_stock;
	}

	/**
	 * 在庫数を格納するためのメソッド
	 * @param item_stock 在庫数
	 */
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	/**
	 * 画像パスを取得するためのメソッド
	 * @return img_path 画像パス
	 */
	public String getImg_path() {
		return img_path;
	}

	/**
	 * 画像パスを格納するためのメソッド
	 * @param img_path 画像パス
	 */
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	/**
	 * 商品説明を取得するためのメソッド
	 * @return item_comment 商品説明
	 */
	public String getItem_comment() {
		return item_comment;
	}

	/**
	 * 商品説明を格納するためのメソッド
	 * @param item_comment 商品説明
	 */
	public void setItem_comment(String item_comment) {
		this.item_comment = item_comment;
	}

	/**
	 * 商品一覧情報リストを取得するためのメソッド
	 * @return displayList 商品一覧情報リスト
	 */
	public ArrayList<ItemDTO> getDisplayList() {
		return displayList;
	}

	/**
	 * 商品一覧情報リストを格納するためのメソッド
	 * @param displayList 商品一覧情報リスト
	 */
	public void setDisplayList(ArrayList<ItemDTO> displayList) {
		this.displayList = displayList;
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
	 * DBの商品情報リストを取得するためのメソッド
	 * @return selectList DBの商品情報リスト
	 */
	public ArrayList<ItemDTO> getSelectList() {
		return selectList;
	}


	/**
	 * DBの商品情報リストを格納するためのメソッド
	 * @param selectList DBの商品情報リスト
	 */
	public void setSelectList(ArrayList<ItemDTO> selectList) {
		this.selectList = selectList;
	}

}