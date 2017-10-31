package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartInsertDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * カートに商品を追加するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartInsertAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 2673132052167697437L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

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
	 * 価格
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
	 * 商品説明
	 */
	private String item_comment;

	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList;

	/**
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> itemList;



	/**
	 * カートに商品を追加するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @verion 1.0
	 * @return SUCCESS:商品追加, ERROR:失敗, LOGIN:ログイン画面
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("user_id")){
			user_id = (int)session.get("user_id");

			CartInsertDAO dao = new CartInsertDAO();
			itemList = dao.itemStatus(item_id); //追加商品情報
			cartList = dao.selected(user_id); //カート内情報

			for(int i = 0; i < cartList.size(); i++) {
				if(cartList.get(i).getItem_id() == item_id) {
					if(itemList.get(0).getItem_stock() - cartList.get(i).getOrder_count() - order_count < 0) { //在庫-注文数が0以上の場合
						order_count = itemList.get(i).getItem_stock(); //在庫数以上の注文数は在庫数に変更
					} else {
						order_count += cartList.get(i).getOrder_count(); //在庫数が注文数より多いなら、そのまま注文数が入る
						if(order_count > 20) { //同一商品を20個以上同カート内に入れた場合
							order_count = 20; //同カート内に同商品は20個まで(選択肢が20までなので、必然的に最大値は20)
						}
					}

					//BigDecimalの計算は、multiplyを使用して、int等をBigDecimalに合わせてから
					sub_total = itemList.get(0).getItem_price().multiply(BigDecimal.valueOf(order_count)); //小計
					dao.update(order_count, user_id, item_id, sub_total); //同商品の場合注文数のみ追加
					result = SUCCESS;
					return result;
				}
			}

			if(itemList.get(0).getItem_stock() > 0) { //在庫数が0以上の場合
				sub_total = itemList.get(0).getItem_price().multiply(BigDecimal.valueOf(order_count)); //小計
				if(dao.addToCart(user_id, item_id, order_count, sub_total) != 0) { //()内が0でない場合
					result = SUCCESS;
				}
			}
		} else {
			result = LOGIN;
		}

		return result;
	}



	/**
	 * 生成されたシリアルIDを取得するためのメソッド
	 * @return serialversionuid 生成されたシリアルID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return item_name 商品ID
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
	 * カート情報リストを取得するためのメソッド
	 * @return cartList カート情報リスト
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * カート情報リストを格納するためのメソッド
	 * @param cartList カート情報リスト
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * 商品情報リストを取得するためのメソッド
	 * @return itemList 商品情報リスト
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	/**
	 * 商品情報リストを格納するためのメソッド
	 * @param itemList 商品情報リスト
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}

}