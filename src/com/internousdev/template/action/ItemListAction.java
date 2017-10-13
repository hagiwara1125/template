package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ItemListDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品一覧を表示するActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/13
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
	 * 商品カテゴリー
	 */
	private int item_category = 0;

	/**
	 * DBから取得した商品情報リスト
	 */
	private ArrayList<ItemDTO> selectList = new ArrayList<ItemDTO>();

	/**
	 * DBから取得した商品情報を表示するための情報リスト
	 */
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	/**
	 * DBから取得したカート情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * ページネーション番号表示リスト
	 */
	private ArrayList<Integer> list = new ArrayList<Integer>();

	/**
	 * 総ページ数
	 */
	private int max_page;

	/**
	 * 現在のページ
	 */
	private int page_number = 1;

	/**
	 * 総データ数
	 */
	private int number;



	/**
	 * MySQLより商品番号を取得するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/13
	 * @version 1.0
	 */
	public String execute() {
		String result = ERROR;

		ItemListDAO dao = new ItemListDAO();
		selectList = dao.select(item_category);

		for(int i = 0; i < selectList.size(); i++) {

			if(selectList.get(i).isI)
		}
	}

}