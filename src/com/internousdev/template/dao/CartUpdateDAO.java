package com.internousdev.template.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.util.DBConnector;



/**
 * カート内の注文数更新に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartUpdateDAO {

	/**
	 * カート内の商品の注文数を更新するためのメソッド
	 * @author HINAKO HAIGWRA
	 * @since 2017/10/23
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @param cart_id カートID
	 * @param order_count 注文数
	 * @param sub_total 小計
	 * @return cartList カート情報リスト
	 */

	public int updateCart(int cart_id, int user_id, int order_count, BigDecimal sub_total) {
		int updateCount = 0;

		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "UPDATE cart SET order_count = ?, sub_total = ? WHERE user_id = ? AND cart_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart_id);
			ps.setInt(2, user_id);
			ps.setInt(3, order_count);
			ps.setBigDecimal(4, sub_total);
			updateCount = ps.executeUpdate();

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

		return updateCount;
	}


	/**
	 * カート内の注文数が更新された場合、商品の在庫数を変更するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @param cart_id カートID
 	 * @return cartList カート情報リスト
	 */

	public ArrayList<CartDTO> itemStatus(int cart_id) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sql = "SELECT * FROM cart WHERE cart_id = ?";
		String sql2 = "SELECT * FROM item WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setCart_id(rs.getInt("cart_id"));
				dto.setItem_id(rs.getInt("item_id"));
				dto.setOrder_count(rs.getInt("order_count"));
				cartList.add(dto);

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while(rs2.next()) {
					dto.setItem_name(rs.getString("item_name"));
					dto.setItem_price(rs2.getBigDecimal("item_price"));
					dto.setSub_total(rs.getBigDecimal("sub_total"));
					dto.setItem_stock(rs2.getInt("item_stock"));
				}

				cartList.add(dto);
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

}