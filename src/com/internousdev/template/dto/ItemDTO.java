package com.internousdev.template.dto;

import java.math.BigDecimal;



/**
 * 商品情報を取得・格納するためのDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/19
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
	 * バリエーションID
	 */
	private int variation_id;

	/**
	 * 商品カテゴリ
	 */
	private int item_category;

	/**
	 * 使用者
	 */
	private int item_user;

	/**
	 * 商品名
	 */
	private String item_name;

	/**
	 * 色
	 */
	private String item_color;

	/**
	 * 価格
	 */
	private BigDecimal item_price;

	/**
	 * 在庫数
	 */
	private int item_stock;

	/**
	 * カート内の注文数を引いた在庫数
	 */
	private int user_stock;

	/**
	 * 画像パス
	 */
	private String img_path;

	/**
	 * 商品説明
	 */
	private String item_comment;

	/**
	 * ページ番号
	 */
	private int item_page;

	/**
	 * カテゴリ別ページ番号
	 */
	private int category_page;

	/**
	 * 登録日
	 */
	private String registration_date;

	/**
	 * 更新日
	 */
	private String updation_date;

	/**
	 * 削除フラグ
	 */
	private boolean deleted_flg;



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
	 * バリエーションIDを取得するためのメソッド
	 * @return variation_id バリエーションID
	 */
	public int getVariation_id() {
		return variation_id;
	}

	/**
	 * バリエーションIDを格納するためのメソッド
	 * @param variation_id バリエーションID
	 */
	public void setVariation_id(int variation_id) {
		this.variation_id = variation_id;
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
	 * 使用者を取得するためのメソッド
	 * @return item_user 使用者
	 */
	public int getItem_user() {
		return item_user;
	}

	/**
	 * 使用者を格納するためのメソッド
	 * @param item_user 使用者
	 */
	public void setItem_user(int item_user) {
		this.item_user = item_user;
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
	 * 色を取得するためのメソッド
	 * @return item_color 色
	 */
	public String getItem_color() {
		return item_color;
	}

	/**
	 * 色を格納するためのメソッド
	 * @param item_color 色
	 */
	public void setItem_color(String item_color) {
		this.item_color = item_color;
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
	 * カート内の注文数を引いた在庫数を取得するためのメソッド
	 * @return user_stock カート内の注文数を引いた在庫数
	 */
	public int getUser_stock() {
		return user_stock;
	}

	/**
	 * カート内の注文数を引いた在庫数を格納するためのメソッド
	 * @param user_stock カート内の注文数を引いた在庫数
	 */
	public void setUser_stock(int user_stock) {
		this.user_stock = user_stock;
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
	 * ページ番号を取得するためのメソッド
	 * @return item_page ページ番号
	 */
	public int getItem_page() {
		return item_page;
	}

	/**
	 * ページ番号を格納するためのメソッド
	 * @param item_page ページ番号
	 */
	public void setItem_page(int item_page) {
		this.item_page = item_page;
	}

	/**
	 * カテゴリ別ページ番号を取得するためのメソッド
	 * @return category_page カテゴリ別ページ番号
	 */
	public int getCategory_page() {
		return category_page;
	}

	/**
	 * カテゴリ別ページ番号を格納するためのメソッド
	 * @param category_page カテゴリ別ページ番号
	 */
	public void setCategory_page(int category_page) {
		this.category_page = category_page;
	}

	/**
	 * 登録日を取得するためのメソッド
	 * @return registration_date 登録日
	 */
	public String getRegistration_date() {
		return registration_date;
	}

	/**
	 * 登録日を格納するためのメソッド
	 * @param registration_date 登録日
	 */
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	/**
	 * 更新日を取得するためのメソッド
	 * @return updation_date 更新日
	 */
	public String getUpdation_date() {
		return updation_date;
	}

	/**
	 * 更新日を格納するためのメソッド
	 * @param updation_date 更新日
	 */
	public void setUpdation_date(String updation_date) {
		this.updation_date = updation_date;
	}

	/**
	 * 削除フラグを取得するためのメソッド
	 * @return deleted_flg 削除フラグ
	 */
	public boolean isDeleted_flg() {
		return deleted_flg;
	}

	/**
	 * 削除フラグを格納するためのメソッド
	 * @param deleted_flg 削除フラグ
	 */
	public void setDeleted_flg(boolean deleted_flg) {
		this.deleted_flg = deleted_flg;
	}

}