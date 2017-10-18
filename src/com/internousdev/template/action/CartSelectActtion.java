package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * カートの情報を取得するActionActionクラス
 *
 * @author HINAKO HINAKO
 * @since 2017/10/18
 * @version 1.0
 */
public class CartSelectActtion extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -1687576469649710395L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * カートID
	 */
	private int cart_id;

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
	 * 商品価格
	 */
	private BigDecimal item_price;

	/**
	 * 注文数
	 */
	private int order_count;

	/**
	 * 小計
	 */
	private BigDecimal sub_total = BigDecimal.ZERO;

	/**
	 * 合計金額
	 */
	private BigDecimal total_price = BigDecimal.ZERO;

	/**
	 * 商品画像
	 */
	private String img_path;

	/**
	 * カート内の商品情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();



	/**
	 * 実行メソッド
	 * 1 : セッション情報を持っているか判断
	 * 2 : session内のuser_idを使用し、カートへ登録された情報を取得
	 * 3 : カート内の情報を元に小計・合計金額を算出
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/18
	 * @version 1.0
	 */
	public String execute() {
		String result = ERROR;

		if (session.containsKey("user_id")) {
			user_id = (int) session.get("user_id");

			CartSelectDAO dao = new CartSelectDAO();
			cartList = dao.selectedItem(user_id);
			for (int i = 0; i < cartList.size(); i++) {

				sub_total = (cartList.get(i).getItem_price())
						.multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count()));
				cartList.get(i).setSub_total(sub_total);

				total_price = total_price.add(sub_total);
			}

			result = SUCCESS;
		} else {
			result = LOGIN;
		}
		return result;
	}



	/**
	 * セッション情報を取得するためのメソッド
	 * @return session セッション情報
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション情報を格納するためのメソッド
	 * @param session セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	 * 注文数を取得するためのメソッド
	 * @return order_count 注文数
	 */
	public int getOrder_count() {
		return order_count;
	}

	/**
	 * 注文数を格納するためのメソッド
	 * @param order_count 注文数
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
	 * カート内の情報リストを取得するためのメソッド
	 * @return cartList カート内の情報リスト
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * カート内の情報リストを格納するためのメソッド
	 * @param cartList カート内の情報リスト
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

}