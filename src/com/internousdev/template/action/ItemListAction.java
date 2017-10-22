package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ItemListDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
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
	 * 総データ数
	 */
	private int number;

	/**
	 * ページネーション番号表示リスト
	 */
	private ArrayList<Integer> list = new ArrayList<Integer>();

	/**
	 * 現在のページ
	 */
	private int pageNum = 1;

	/**
	 * 総ページ数
	 */
	private int maxPage;



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
			GoCartDAO cartDao = new GoCartDAO();
			cartList = cartDao.selectItem(user_id);

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

			number = selectList.size();
			if(number > 0) {

				//ページネーション処理
				ArrayList<ItemListPageObject> allPages = new ArrayList<ItemListPageObject>();
				ItemListPages allp = new ItemListPages();
				allPages = allp.paginate(selectList, 9);
				maxPage = allp.getMaxPage(selectList, 9);
				displayList = allPages.get(pageNum - 1).getPaginatedList();
				for(int i = 0; i < maxPage; i++) {
					list.add(i);
				}
				result = SUCCESS;
			}

			result = SUCCESS;

		}

		return result;
	}

}
