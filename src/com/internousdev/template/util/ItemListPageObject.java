package com.internousdev.template.util;

import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;

/**
 * ページネーションが必要なリストのために、1ページ毎の情報を保持するためのクラス
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
	 * 当該1ページに表示される商品のリスト
	 */
	private ArrayList<ItemDTO> pagenatedItemList = new ArrayList<ItemDTO>();



	/**
	 * ページネートされた商品リストを取得するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/15
	 * @return pagenatedItemList ページネートされた商品リスト
	 */
	public ArrayList<ItemDTO> getPagenatedList() {
		return pagenatedItemList;
	}

	/**
	 * ページネートされた商品を格納するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/15
	 * @param list DTOに格納されたArrayList
	 */
	public void setPagenatedList(ArrayList<ItemDTO> list) {
		pagenatedItemList = list;
	}

	/**
	 * ItemListPagesクラスのpagenate()において使われる
	 * これにより、DTOのインスタンスが該当ページに1つずつ格納されていく
	 * @param list DTOに格納されたArrayList
	 * @param j 繰り返し用変数
	 */
	public void addPagenatedList(ArrayList<ItemDTO> list, int j) {
		pagenatedItemList.add((ItemDTO) list.get(j));
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
	 * 当該1ページに表示される商品のリストを取得するためのメソッド
	 * @return pagenatedItemList 当該1ページに表示される商品のリスト
	 */
	public ArrayList<ItemDTO> getPagenatedItemList() {
		return pagenatedItemList;
	}

	/**
	 * 当該1ページに表示される商品のリストを格納するためのメソッド
	 * @param pagenatedItemList 当該1ページに表示される商品のリスト
	 */
	public void setPagenatedItemList(ArrayList<ItemDTO> pagenatedItemList) {
		this.pagenatedItemList = pagenatedItemList;
	}
 }
