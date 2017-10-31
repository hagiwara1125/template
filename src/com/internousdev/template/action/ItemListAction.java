package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dao.ItemListDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.ItemListAllPages;
import com.internousdev.template.util.ItemListPageObject;
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
	 * 商品一覧情報リスト
	 */
	private ArrayList<ItemDTO> selectList = new ArrayList<>();

	/**
	 * 商品表示情報リスト
	 */
	public ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * セッション情報
	 */
	private Map<String,Object> session;

	/**
	 * 総ページ数
	 */
	private int maxPage;

	/**
	 * 現在のページ
	 */
	private int pageNum = 1;

	/**
	 * 総データ数
	 */
	private int number;

	/**
	 * カテゴリ
	 */
	private int item_category = 0;

	/**
	 * 在庫数メッセージ
	 */
	private String stock_alert;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * ページネーション番号表示リスト
	 */
	private ArrayList<Integer> list = new ArrayList<Integer>();



	/**
	 * DBから商品情報を取得するための実行メソッド
	 * @author HINAKO HAGIWRA
	 * @since 2017/1022
	 * @version 1.0
	 */
	public String execute(){
		String result = ERROR;

		if (session.containsKey("user_id")) {
			user_id = (int) session.get("user_id");

			//カート情報の取得
			CartSelectDAO cartDao = new CartSelectDAO();
			cartList = cartDao.selectedItem(user_id);
		}

		// 商品情報の取得
		ItemListDAO dao = new ItemListDAO();
		selectList = dao.select(item_category);


		for(int i=0;i < selectList.size();i++){

			int userStock = selectList.get(i).getItem_stock();

			for(int j=0;j<cartList.size();j++){
				if(selectList.get(i).getItem_id() == cartList.get(j).getItem_id()){
					userStock -= cartList.get(j).getOrder_count();
				}
			}
			selectList.get(i).setUser_stock(userStock);
		}

		try{

			// ページネーション処理
			number = selectList.size();
			if(number > 0) {
				ArrayList<ItemListPageObject> allPages = new ArrayList<ItemListPageObject>();
				ItemListAllPages allp = new ItemListAllPages();
				allPages = allp.paginate(selectList, 12);
				maxPage = allp.getMaxPage(selectList, 12);
				itemList = allPages.get(pageNum-1).getPaginatedList();
				if(maxPage <= 5){
					for(int i=1;i<=maxPage;i++){
						list.add(i);
					}
				}
				else if(maxPage >=6){
					if(pageNum <=3){
						for(int i=1;i<=5;i++){
							list.add(i);
						}
					}
					else if(pageNum >=4 && pageNum <= maxPage-3){
						for(int i=pageNum-2;i<=pageNum+2;i++){
							list.add(i);
						}
					}
					else if(pageNum>=maxPage-2){
						for(int i=maxPage-4;i<=maxPage;i++){
							list.add(i);
						}
					}
				}
			}
		}catch (IndexOutOfBoundsException e) {
			result =SUCCESS;
		}
		return result;
	}

	/**
	 * 総ページ数を取得するメソッド
	 * @return maxPage　総ページ数
	 */
	public int getMaxPage() {
		return maxPage;
	}

	/**
	 * 総ページ数を格納するメソッド
	 * @param maxPage 総ページ数
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * 現在のページを取得するメソッド
	 * @return pageNum　 現在のページ
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * 現在のページを格納するメソッド
	 * @param pageNum  現在のページ
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * 総データ数を取得するメソッド
	 * @return number　総データ数
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 総データ数を格納するメソッド
	 * @param number 総データ数
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * 商品情報のリストを取得するメソッド
	 * @return itemList　商品情報のリスト
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	/**
	 * 商品情報のリストを格納するメソッド
	 * @param itemList 商品情報のリスト
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 商品情報のリストを取得するメソッド
	 * @return selectList 商品情報のリスト
	 */
	public ArrayList<ItemDTO> getSelectList() {
		return selectList;
	}

	/**
	 * 商品情報のリストを格納するメソッド
	 * @param selectList 商品情報のリスト
	 */
	public void setSelectList(ArrayList<ItemDTO> selectList) {
		this.selectList = selectList;
	}

	/**
	 * セッション情報を取得するメソッド
	 * @return session セッション情報
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション情報を格納するメソッド
	 * @param session セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * シリアルIDを取得するメソッド
	 * @return serialversionuid シリアルID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * カテゴリー取得メソッド
	 * @return item_category　カテゴリー
	 */
	public int getItem_category() {
		return item_category;
	}

	/**
	 *  カテゴリー格納メソッド
	 * @param item_category　カテゴリー
	 */
	public void setItem_category(int item_category) {
		this.item_category = item_category;
	}

	/**
	 * 在庫数メッセージ取得メソッド
	 * @return stock_alert　在庫数メッセージ
	 */
	public String getStock_alert() {
		return stock_alert;
	}

	/**
	 * 在庫数メッセージ格納メソッド
	 * @param stock_alert　在庫数メッセージ
	 */
	public void setStock_alert(String stock_alert) {
		this.stock_alert = stock_alert;
	}

	/**
	 * ユーザーID取得メソッド
	 * @return user_id ユーザーID
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * ユーザーID格納メソッド
	 * @param user_id ユーザーID
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * データベースから取得した商品情報リスト取得メソッド
	 * @return cartList　データベースから取得した商品情報リスト
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * データベースから取得した商品情報リスト格納メソッド
	 * @param cartList　データベースから取得した商品情報リスト
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * ページネーション番号表示リスト取得するメソッド
	 * @return list　ページネーション番号表示リスト
	 */
	public ArrayList<Integer> getList() {
		return list;
	}

	/**
	 * ページネーション番号表示リスト格納するメソッド
	 * @param list　ページネーション番号表示リスト
	 */
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}

}