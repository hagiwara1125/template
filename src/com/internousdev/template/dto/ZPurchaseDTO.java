package com.internousdev.template.dto;

import java.math.BigDecimal;

/**
 * 商品購入に関するDTOクラス
 * @author HIANKO HAGIWARA
 * @since 2017/10/13
 * @version 1.0
 */

public class ZPurchaseDTO {


	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 購入ID
	 */
	private int purchase_id;

	/**
	 * カートID
	 */
	private int cart_id;

	/**
	 * 商品ID
	 */
	private int item_id;

	/**
	 * 商品名
	 */
	private String item_name;

	/**
	 * 商品価格
	 */
	private BigDecimal item_price;

	/**
	 * 購入数
	 */
	private int order_count;

	/**
	 * 小計
	 */
	private BigDecimal sub_total;

	/**
	 * 合計金額
	 */
	private BigDecimal total_price;

	/**
	 * 商品在庫数
	 */
	private int item_stock;

	/**
	 * 商品画像
	 */
	private String img_path;

	/**
	 * 購入日
	 */
	private String purcase_date;



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
	 * 購入IDを取得するためのメソッド
	 * @return purcase_id 購入ID
	 */
	public int getPurchase_id() {
		return purchase_id;
	}

	/**
	 * 購入IDを格納するためのメソッド
	 * @param purchase_id 購入ID
	 */
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	/**
	 * カートIDを取得するためのメソッド
	 * @return cart_id カートID
	 */
	public int getCart_id() {
		return cart_id;
	}

	/**
	 * カートIDを格納するためのメソッド
	 * @param cart_id カートID
	 */
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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
	 * 購入数を取得するためのメソッド
	 * @return order_count 購入数
	 */
	public int getOrder_count() {
		return order_count;
	}

	/**
	 * 購入数を格納するためのメソッド
	 * @param order_count 購入数
	 */
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	/**
	 * 小計を取得するためのメソッド
	 * @return sub_total 小計
	 */
	public BigDecimal getSub_total() {
		return sub_total;
	}

	/**
	 * 小計を格納するためのメソッド
	 * @param sub_total 小計
	 */
	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	/**
	 * 合計金額を取得するためのメソッド
	 * @return total_price 合計金額
	 */
	public BigDecimal getTotal_price() {
		return total_price;
	}

	/**
	 * 合計金額を格納するためのメソッド
	 * @param total_price 合計金額
	 */
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
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
	 * 購入日を取得するためのメソッド
	 * @return purcase_date 購入日
	 */
	public String getPurcase_date() {
		return purcase_date;
	}

	/**
	 * 購入日を格納するためのメソッド
	 * @param purcase_date 購入日
	 */
	public void setPurcase_date(String purcase_date) {
		this.purcase_date = purcase_date;
	}

}
