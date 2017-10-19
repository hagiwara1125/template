package com.internousdev.template.dto;

import java.math.BigDecimal;



/**
 * 購入履歴情報を取得・格納するためのDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/19
 * @version 1.0
 */

public class NewPurchase {

	/**
	 *
	 */
	private int purchase_id;

	/**
	 *
	 */
	private int user_id;

	/**
	 *
	 */
	private int item_id;

	/**
	 *
	 */
	private int cart_id;

	/**
	 *
	 */
	private String item_name;

	/**
	 *
	 */
	private BigDecimal item_price;

	/**
	 *
	 */
	private int order_count;

	/**
	 *
	 */
	private BigDecimal sub_total;

	/**
	 *
	 */
	private BigDecimal total_price;

	/**
	 *
	 */
	private int item_stock;

	/**
	 *
	 */
	private String img_path;

	/**
	 *
	 */
	private String purchase_date;

	/**
	 *
	 */
	private int payment_method;



	/**
	 * @return purchase_id
	 */
	public int getPurchase_id() {
		return purchase_id;
	}

	/**
	 * @param purchase_id セットする purchase_id
	 */
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	/**
	 * @return user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return item_id
	 */
	public int getItem_id() {
		return item_id;
	}

	/**
	 * @param item_id セットする item_id
	 */
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	/**
	 * @return cart_id
	 */
	public int getCart_id() {
		return cart_id;
	}

	/**
	 * @param cart_id セットする cart_id
	 */
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	/**
	 * @return item_name
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * @param item_name セットする item_name
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * @return item_price
	 */
	public BigDecimal getItem_price() {
		return item_price;
	}

	/**
	 * @param item_price セットする item_price
	 */
	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}

	/**
	 * @return order_count
	 */
	public int getOrder_count() {
		return order_count;
	}

	/**
	 * @param order_count セットする order_count
	 */
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	/**
	 * @return sub_total
	 */
	public BigDecimal getSub_total() {
		return sub_total;
	}

	/**
	 * @param sub_total セットする sub_total
	 */
	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	/**
	 * @return total_price
	 */
	public BigDecimal getTotal_price() {
		return total_price;
	}

	/**
	 * @param total_price セットする total_price
	 */
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	/**
	 * @return item_stock
	 */
	public int getItem_stock() {
		return item_stock;
	}

	/**
	 * @param item_stock セットする item_stock
	 */
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	/**
	 * @return img_path
	 */
	public String getImg_path() {
		return img_path;
	}

	/**
	 * @param img_path セットする img_path
	 */
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	/**
	 * @return purchase_date
	 */
	public String getPurchase_date() {
		return purchase_date;
	}

	/**
	 * @param purchase_date セットする purchase_date
	 */
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	/**
	 * @return payment_method
	 */
	public int getPayment_method() {
		return payment_method;
	}

	/**
	 * @param payment_method セットする payment_method
	 */
	public void setPayment_method(int payment_method) {
		this.payment_method = payment_method;
	}

}