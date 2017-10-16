package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.ItemListDAO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.ItemListAllPages;
import com.internousdev.template.util.ItemListPageObject;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品一覧を表示するActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/13
 * @version 1.0
 */

public class ItemListAction extends ActionSupport {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -3068800794434055497L;

	/**
	 * 商品カテゴリー
	 */
	private int item_category = 0;

	/**
	 * 商品一覧リスト
	 */
	private ArrayList<ItemDTO> selectList = new ArrayList<ItemDTO>();

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
	 * 商品一覧を取得し、ページネーションを作成できたらSUCCESSを返すメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/13
	 * @version 1.0
	 * @return ERROR or SUCCESS
	 */
	public String execute() {
		String result = ERROR;

		ItemListDAO dao = new ItemListDAO();
		selectList = dao.select(item_category);

		if(selectList.size() > 0) {
			result = SUCCESS;
		}

		number = selectList.size();
		if(number > 0) {

			//ページネーション処理
			ArrayList<ItemListPageObject> allPages = new ArrayList<ItemListPageObject>();
			ItemListAllPages allp = new ItemListAllPages();
			allPages = allp.paginate(selectList, 12);
			maxPage = allp.getMaxPage(selectList, 12);
			displayList = allPages.get(pageNum - 1).getPaginatedItemList();
			for(int i = 0; i < maxPage; i++) {
				list.add(i);
			}
			result = SUCCESS;
		}
		result = SUCCESS;
		return result;
	}


	/**
	 *
	 */
	public ArrayList<ItemDTO> getDisplayList() {
		return displayList;
	}

	/**
	 *
	 */
	public void setDisplayList(ArrayList<ItemDTO> displayList) {
		this.displayList = displayList;
	}

}