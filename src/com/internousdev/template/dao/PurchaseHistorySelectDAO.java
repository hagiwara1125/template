package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.dto.PurchaseDTO;
import com.internousdev.template.dto.UserDTO;
import com.internousdev.util.DBConnector;

/**
 * 購入履歴情報取得に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/30
 * @version 1.0
 */
public class PurchaseHistorySelectDAO {

	/**
	 * 購入履歴情報リスト
	 */
	ArrayList<PurchaseDTO> purchaseList = new ArrayList<PurchaseDTO>();

	/**
	 * 商品情報リスト
	 */
	ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	/**
	 * 顧客情報リスト
	 */
	ArrayList<UserDTO> userList = new ArrayList<UserDTO>();


	/**
	 * 購入履歴情報を取得するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/30
	 * @version 1.0
	 *
	 */

	public boolean selectPurchaseHistory(String user_id, String search_purchase_date, String search_item_name, String search_user_name, String search_item_category, String sort) {
		boolean result = false;

		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "SELECT * FROM item"
				+ " JOIN purchase ON item.item_id = purchase.item_id"
				+ " JOIN users ON users.user_id = purchase.user_id"
				+ " WHERE purchase.user_id LIKE ?"
				+ " AND purchase.purchase_date LIKE ?"
				+ " AND item.item_name LIKE ?"
				+ " AND users.user_name LIKE ?"
				+ " AND item.item_category LIKE ?"
				+ " ORDER BY purchase.purchase_date DESC";

		if(sort.equals("1")) {
			sql = "SELECT * FROM item"
					+ " JOIN purchase ON item.item_id = purchase.item_id"
					+ " JOIN users ON users.user_id = purchase.user_id"
					+ " WHERE purchase.user_id LIKE ?"
					+ " AND purchase.purchase_date LIKE ?"
					+ " AND item.item_name LIKE ?"
					+ " AND users.user_name LIKE ?"
					+ " AND item.item_category LIKE ?"
					+ " ORDER BY purchase.purchase_date ASC";

		} else if(sort.equals("2")) {
			sql = "SELECT * FROM item"
					+ " JOIN purchase ON item.item_id = purchase.item_id"
					+ " JOIN users.user_id = purchase.user_id"
					+ " WHERE purchase.user_id LIKE ?"
					+ " AND purchase.purchase_date LIKE ?"
					+ " AND item.item_name LIKE ?"
					+ " AND users.user_name LIKE ?"
					+ " AND item.item_category LIKE ?"
					+ " ORDER BY purchase.order_count ASC";

		} else if(sort.equals("3")) {
			sql = "SELECT * FROM item"
					+ " JOIN purchase ON item.item_id = purchase.item_id"
					+ " JOIN users ON users.user_id = purchase.user_id"
					+ " WHERE purchase.user_id LIKE ?"
					+ " AND purchase.purchase_date LIKE ?"
					+ " AND item.item_name LIKE ?"
					+ " AND users.user_name LIKE ?"
					+ " AND item.item_category LIKE ?"
					+ " ORDER BY purchase.order_count DESC";
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if(user_id.length() != 0) {
			ps.setString(1, user_id);
			} else {
				ps.setString(1, "%" + user_id + "%");
			}
			ps.setString(2, "%" + search_purchase_date + "%");
			ps.setString(3, "%" + search_item_name + "%");
			ps.setString(4, "%" + search_user_name + "%");
			ps.setString(5, "%" + search_item_category + "%");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PurchaseDTO pdto = new PurchaseDTO();
				ItemDTO idto = new ItemDTO();
				UserDTO udto = new UserDTO();
				pdto.setUser_id(rs.getInt("user_id"));
				pdto.setPurchase_date(rs.getString("purchase_date").substring(0, 19));
				idto.setItem_name(rs.getString("item_name"));
				pdto.setOrder_count(rs.getInt("order_count"));
				pdto.setSub_total(rs.getBigDecimal("sub_total"));
				udto.setUser_name(rs.getString("user_name"));
				purchaseList.add(pdto);
				itemList.add(idto);
				userList.add(udto);
				result = true;

			}

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}

		}

		return result;

	}


	/**
	 * @return purchaseList
	 */
	public ArrayList<PurchaseDTO> getPurchaseList() {
		return purchaseList;
	}


	/**
	 * @param purchaseList セットする purchaseList
	 */
	public void setPurchaseList(ArrayList<PurchaseDTO> purchaseList) {
		this.purchaseList = purchaseList;
	}


	/**
	 * @return itemList
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}


	/**
	 * @param itemList セットする itemList
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}


	/**
	 * @return userList
	 */
	public ArrayList<UserDTO> getUserList() {
		return userList;
	}


	/**
	 * @param userList セットする userList
	 */
	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}
}