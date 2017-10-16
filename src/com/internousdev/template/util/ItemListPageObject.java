package com.internousdev.template.util;

import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;

/**
 * ページネーションが必要なリストのために、1ページごとの情報を保持するためのクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/15
 * @version 1.0
 */

public class ItemListPageObject {

	/**
	 * ページID
	 */
	private int page_id;

	/**
	 * ページネートされた商品のリスト
	 */
	private ArrayList<ItemDTO> paginatedItemList = new ArrayList<ItemDTO>();



	/**
	 * ページネートされた商品リストを取得するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/15
	 * @return paginatedItemList ページネートされた商品リスト
	 */
	public ArrayList<ItemDTO> getPagenatedList() {
		return paginatedItemList;
	}

	/**
	 * ページネートされた商品を格納するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/15
	 * @param list DTOに格納されたArrayList
	 */
	public void setPaginatedList(ArrayList<ItemDTO> list) {
		paginatedItemList = list;
	}

	/**
	 * ItemListPagesクラスのpagenate()において使われる
	 * これにより、DTOのインスタンスが該当ページに1つずつ格納されていく
	 * @param list DTOに格納されたArrayList
	 * @param j 繰り返し用変数
	 */
	public void addPaginatedList(ArrayList<ItemDTO> list, int j) {
		paginatedItemList.add((ItemDTO) list.get(j));
	}



	/**
	 * ページIDを取得するためのメソッド
	 * @return page_id ページID
	 */
	public int getPage_id() {
		return page_id;
	}

	/**
	 * ページIDを格納するためのメソッド
	 * @param page_id ページID
	 */
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}

	/**
	 * ページネートされた商品のリストを取得するためのメソッド
	 * @return paginatedItemList 当該1ページに表示される商品のリスト
	 */
	public ArrayList<ItemDTO> getPaginatedItemList() {
		return paginatedItemList;
	}

	/**
	 * ページネートされた商品のリストを格納するためのメソッド
	 * @param paginatedItemList 当該1ページに表示される商品のリスト
	 */
	public void setPaginatedItemList(ArrayList<ItemDTO> paginatedItemList) {
		this.paginatedItemList = paginatedItemList;
	}
 }