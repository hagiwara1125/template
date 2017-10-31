package com.internousdev.template.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;



/**
 * カートへの商品追加に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartInsertDAO {

	/**
	 * カートに追加する商品情報を取得するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @param item_id 商品ID
	 * @return itemList 商品情報リスト
	 */

	public ArrayList<ItemDTO> itemStatus(int item_id) {

		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

		String sql = "SELECT * FROM item WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItem_name(rs.getString("item_name")); //商品名
				dto.setItem_price(rs.getBigDecimal("item_price")); //価格
				dto.setItem_stock(rs.getInt("item_stock")); //在庫数
				dto.setItem_comment(rs.getString("item_comment")); //商品説明
				itemList.add(dto);
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

		return itemList;
	}


	/**
	 * カートテーブルへ情報を追加するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @verison 1.0
	 * @param user_id ユーザーID
	 * @param item_id 商品ID
	 * @param order_count 注文数
	 * @param sub_total 小計
	 * @return addCount 追加回数
	 */

	public int addToCart(int user_id, int item_id, int order_count, BigDecimal sub_total) {
		int addCount = 0;

		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "INSERT INTO cart(user_id, item_id, order_count, sub_total) VALUES(?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id); //ユーザーID
			ps.setInt(2, item_id); //商品ID
			ps.setInt(3, order_count); //注文数
			ps.setBigDecimal(4, sub_total); //小計
			addCount = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

		return addCount;
	}


	/**
	 * カート内の商品情報を取得し格納するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @return cartList カート情報
	 */

	public ArrayList<CartDTO> selected(int user_id) {

		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sql = "SELECT * FROM cart WHERE user_id = ?";
		String sql2 = "SELECT * FROM item WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setUser_id(rs.getInt("user_id")); //ユーザーID
				dto.setCart_id(rs.getInt("cart_id")); //カートID
				dto.setItem_id(rs.getInt("item_id")); //商品ID
				dto.setOrder_count(rs.getInt("order_count")); //注文数
				cartList.add(dto);

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps.setInt(1, dto.getUser_id());
				ResultSet rs2 = ps2.executeQuery();
				while(rs.next()) {
					dto.setItem_name(rs2.getString("item_name")); //商品名
					dto.setItem_price(rs2.getBigDecimal("item_price")); //価格

				}
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

		return cartList;
	}


	/**
	 * カート内に同じ商品があった場合、注文数を足すメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @param item_id 商品ID
	 * @param order_count 注文数
	 * @param sub_total 小計
	 * @return 更新件数
	 */

	public int update(int order_count, int user_id, int item_id, BigDecimal sub_total) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "UPDATE cart SET order_count = ?, sub_total = ? WHERE user_id = ? and item_id = ?";

		int addCount = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order_count); //注文数
			ps.setBigDecimal(2, sub_total); //小計
			ps.setInt(3, user_id); //ユーザーID
			ps.setInt(4, item_id); //商品ID
			addCount = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}

			}
		}

		return addCount;

	}
}