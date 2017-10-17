package com.internousdev.template.dto;

import java.math.BigDecimal;



/**
 * 商品情報に関するDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/13
 * @version 1.0
 */

public class ItemDTO {

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 商品ID
	 */
	private int item_id;

	/**
	 * 商品名
	 */
	private String item_name;

	/**
	 * 商品カテゴリー
	 */
	private int category;

	/**
	 * 商品価格
	 */
	private BigDecimal item_price;

	/**
	 * 商品在庫数
	 */
	private int item_stock;

	/**
	 * 商品画像
	 */
	private String img_path;

	/**
	 * 商品説明
	 */
	private String comment;

	/**
	 * 商品フラグ
	 */
	private boolean item_flg;

	/**
	 * 公開フラグ
	 */
	private boolean release_flg;

	/**
	 * カート内の注文数を引いた商品在庫数
	 */
	private int cart_stock;



	/**
	 * ユーザーIDを取得するためのメソッド
	 * @return user_id ユーザーID
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * ユーザーIDを格納するためのクラス
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
	 * カテゴリを取得するためのメソッド
	 * @return category カテゴリ
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * カテゴリを格納するためのメソッド
	 * @param category カテゴリ
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * 商品価格を取得するためのメソッド
	 * @return item_price 商品価格
	 */
	public BigDecimal getItem_price() {
		return item_price;
	}

	/**
	 * 商品価格を格納するためのメソッド
	 * @param item_price 商品価格
	 */
	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}

	/**
	 * 商品在庫数を取得するためのメソッド
	 * @return item_stock 商品在庫数
	 */
	public int getItem_stock() {
		return item_stock;
	}

	/**
	 * 商品在庫数を格納するためのメソッド
	 * @param item_stock 商品在庫数
	 */
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	/**
	 * 商品画像を取得するためのメソッド
	 * @return img_path 商品画像
	 */
	public String getImg_path() {
		return img_path;
	}

	/**
	 * 商品画像を格納するためのメソッド
	 * @param img_path 商品画像
	 */
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	/**
	 * 商品説明を取得するためのメソッド
	 * @return comment 商品説明
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 商品説明を格納するためのメソッド
	 * @param comment 商品説明
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 商品フラグを取得するためのメソッド
	 * @return item_flg 商品フラグ
	 */
	public boolean isItem_flg() {
		return item_flg;
	}

	/**
	 * 商品フラグを格納するためのメソッド
	 * @param item_flg 商品フラグ
	 */
	public void setItem_flg(boolean item_flg) {
		this.item_flg = item_flg;
	}

	/**
	 * 公開フラグを取得するためのメソッド
	 * @return release_flg 公開フラグ
	 */
	public boolean isRelease_flg() {
		return release_flg;
	}

	/**
	 * 公開フラグを格納するためのメソッド
	 * @param release_flg 公開フラグ
	 */
	public void setRelease_flg(boolean release_flg) {
		this.release_flg = release_flg;
	}

	/**
	 * カート内の注文数を引いた商品在庫数を取得するためのメソッド
	 * @return cart_stock カート内の注文数を引いた商品在庫数
	 */
	public int getCart_stock() {
		return cart_stock;
	}

	/**
	 * カート内の注文数を引いた商品在庫数を格納するためのメソッド
	 * @param cart_stock カート内の注文数を引いた商品在庫数
	 */
	public void setCart_stock(int cart_stock) {
		this.cart_stock = cart_stock;
	}

}