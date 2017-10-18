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
 * 商品一覧を表示するActionクラス
 *
 * @author HINAKO HAGIWARA
 * @since 2017/10/13
 * @version 1.0
 */

public class ItemListAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -3068800794434055497L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 商品カテゴリー
	 */
	private int item_category = 0;

	/**
	 * 在庫数メッセージ
	 */
	private String stock_alert;

	/**
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> selectList = new ArrayList<ItemDTO>();

	/**
	 * 商品情報表示リスト
	 */
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	/**
	 * カート内情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * 1ページに表示する商品一覧リスト
	 */
	private ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();

	/**
	 * ページネーション番号表示リスト
	 */
	private ArrayList<Integer> list = new ArrayList<Integer>();

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
	 * 商品情報を取得し、ページネーションを作成できたらSUCCESSを返すメソッド
	 *
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/13
	 * @version 1.0
	 * @return ERROR or SUCCESS
	 */
	public String execute() {
		String result = ERROR;

		/* 動作確認 */System.out.println("ItemListAction - result :" + result);

		if (session.containsKey("user_id")) {
			user_id = (int) session.get("user_id");

			// カート内情報の取得
			CartSelectDAO cartDao = new CartSelectDAO();
			cartList = cartDao.selectedItem(user_id);
		}

		ItemListDAO dao = new ItemListDAO();
		selectList = dao.select(item_category);

		for (int i = 0; i < selectList.size(); i++) {
			if (selectList.get(i).isRelease_flg() == false || selectList.get(i).isItem_flg() == false) {
				selectList.remove(i);
				i--;
				continue;
			}

			int userStock = selectList.get(i).getItem_stock();

			for (int j = 0; j < cartList.size(); j++) {
				if (selectList.get(i).getItem_id() == cartList.get(j).getItem_id()) {
					userStock -= cartList.get(j).getOrder_count();
				}
			}
			selectList.get(i).setUser_stock(userStock);
		}
		try {
			number = selectList.size();
			if (number > 0) {
				ArrayList<ItemListPageObject> allPages = new ArrayList<ItemListPageObject>();
				ItemListAllPages allp = new ItemListAllPages();
				allPages = allp.paginate(selectList, 12);
				maxPage = allp.getMaxPage(selectList, 12);
				itemList = allPages.get(pageNum - 1).getPagenatedList();
				if (maxPage <= 5) {
					for (int i = 1; i <= maxPage; i++) {
						list.add(i);
					}
				} else if (maxPage >= 6) {
					if (pageNum <= 3) {
						for (int i = 1; i <= 5; i++) {
							list.add(i);
						}
					} else if (pageNum >= 4 && pageNum <= maxPage-3) {
						for (int i = pageNum - 2; i <= pageNum + 2; i++) {
							list.add(i);
						}
					} else if (pageNum >= maxPage-2) {
						for (int i = maxPage-4; i <= maxPage; i++) {
							list.add(i);
						}
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			return ERROR;
		}
		result = SUCCESS;
		return result;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            セットする session
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
	 * @param user_id
	 *            セットする user_id
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
	 * @param item_category
	 *            セットする item_category
	 */
	public void setItem_category(int item_category) {
		this.item_category = item_category;
	}

	/**
	 * @return stock_alert
	 */
	public String getStock_alert() {
		return stock_alert;
	}

	/**
	 * @param stock_alert
	 *            セットする stock_alert
	 */
	public void setStock_alert(String stock_alert) {
		this.stock_alert = stock_alert;
	}

	/**
	 * @return selectList
	 */
	public ArrayList<ItemDTO> getSelectList() {
		return selectList;
	}

	/**
	 * @param selectList
	 *            セットする selectList
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
	 * @param itemList
	 *            セットする itemList
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
	 * @param cartList
	 *            セットする cartList
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * @return displayList
	 */
	public ArrayList<ItemDTO> getDisplayList() {
		return displayList;
	}

	/**
	 * @param displayList
	 *            セットする displayList
	 */
	public void setDisplayList(ArrayList<ItemDTO> displayList) {
		this.displayList = displayList;
	}

	/**
	 * @return list
	 */
	public ArrayList<Integer> getList() {
		return list;
	}

	/**
	 * @param list
	 *            セットする list
	 */
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}

	/**
	 * @return maxPage
	 */
	public int getMaxPage() {
		return maxPage;
	}

	/**
	 * @param maxPage
	 *            セットする maxPage
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * @return pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum
	 *            セットする pageNum
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            セットする number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}