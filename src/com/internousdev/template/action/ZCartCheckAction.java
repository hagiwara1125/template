package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ZCartSelectDAO;
import com.internousdev.template.dao.ZMyPageDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * 購入内容確認に必要な情報を取得し遷移するActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/18
 * @version 1.0
 */

public class ZCartCheckAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -3873819962417048258L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 商品ID
	 */
	private int item_id;

	/**
	 * 小計
	 */
	private BigDecimal sub_total = BigDecimal.ZERO;

	/**
	 * 合計金額
	 */
	private BigDecimal total_price = BigDecimal.ZERO;

	/**
	 * ユーザー情報リスト
	 */
	private ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	/**
	 * カート情報リスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * 商品情報リスト
	 */
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();



	/**
	 * カート内の商品情報の照合、格納をするメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/18
	 * @version 1.0
	 */

	public String execute() {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			ZMyPageDAO myDao = new ZMyPageDAO();
			ZCartSelectDAO cartDao = new ZCartSelectDAO();

			//アレイリストに情報を入れる
			userList = myDao.select(user_id);
			cartList = cartDao.selectedItem(user_id);

			for(int i = 0; i < cartList.size(); i++) {

				sub_total = (cartList.get(i).getItem_price().multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count())));
				cartList.get(i).setSub_total(sub_total);

				total_price = total_price.add(sub_total);
			}
			result =SUCCESS;
		}else {
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
	 * ユーザーIDを取得するためのメソッド
	 * @return user_idーID
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
	 * 会員情報リストを取得するためのメソッド
	 * @return userList 会員情報リスト
	 */
	public ArrayList<UserDTO> getUserList() {
		return userList;
	}

	/**
	 * 会員情報リストを格納するためのメソッド
	 * @param userList 会員情報リスト
	 */
	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
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