package com.internousdev.template.dto;

import java.math.BigDecimal;



/**
 * 商品情報に関するDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/13
 * @version 1.0
 */

public class ZItemDTO {

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
	 * 商品名
	 */
	private String item_name;

	/**
	 * 商品カテゴリ
	 */
	private int item_category;

	/**
	 * 商品カラー
	 */
	private String item_color;

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
	private String item_comment;

	/**
	 * 商品フラグ
	 */
	private boolean item_flg;

	/**
	 * 公開フラグ
	 */
	private boolean release_flg;

	/**
	 * 在庫数通知
	 */
	private String stock_alert;

	/**
	 * カート内の注文数を引いた商品在庫数
	 */
	private int user_stock;

	/**
	 * ページ番号
	 */
	private int pageNum;

	/**
	 * カテゴリ別ページ番号
	 */
	private int categoryPageNum;



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
	 * 商品カラーを取得するためのメソッド
	 * @return item_color 商品カラー
	 */
	public String getItem_color() {
		return item_color;
	}

	/**
	 * 商品カラーを格納するためのメソッド
	 * @param item_color 商品カラー
	 */
	public void setItem_color(String item_color) {
		this.item_color = item_color;
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
	public String getItem_comment() {
		return item_comment;
	}

	/**
	 * 商品説明を格納するためのメソッド
	 * @param comment 商品説明
	 */
	public void setItem_comment(String item_comment) {
		this.item_comment = item_comment;
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
	 * 在庫数通知を取得するためのメソッド
	 * @return stock_alert 在庫数通知
	 */
	public String getStock_alert() {
		return stock_alert;
	}

	/**
	 * 在庫数通知を格納するためのメソッド
	 * @param stock_alert 在庫数通知
	 */
	public void setStock_alert(String stock_alert) {
		this.stock_alert = stock_alert;
	}

	/**
	 * カート内の注文数を引いた商品在庫数を取得するためのメソッド
	 * @return user_stock カート内の注文数を引いた商品在庫数
	 */
	public int getUser_stock() {
		return user_stock;
	}

	/**
	 * カート内の注文数を引いた商品在庫数を格納するためのメソッド
	 * @param user_stock カート内の注文数を引いた商品在庫数
	 */
	public void setUser_stock(int user_stock) {
		this.user_stock = user_stock;
	}

	/**
	 * ページ番号を取得するためのメソッド
	 * @return pageNum ページ番号
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * ページ番号を格納するためのメソッド
	 * @param pageNum ページ番号
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * カテゴリ別ページ番号を取得するためのメソッド
	 * @return categoryPageNum カテゴリ別ページ番号
	 */
	public int getCategoryPageNum() {
		return categoryPageNum;
	}

	/**
	 * カテゴリ別ページ番号を格納するためのメソッド
	 * @param categoryPageNum カテゴリ別ページ番号
	 */
	public void setCategoryPageNum(int categoryPageNum) {
		this.categoryPageNum = categoryPageNum;
	}

}