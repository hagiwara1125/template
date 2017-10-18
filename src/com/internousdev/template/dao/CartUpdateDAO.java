package com.internousdev.template.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.MySQLConnector;



/**
 * カート内の商品注文数を更新するDAOクラス
 *
 * @author HINAKO HAGIWARA
 * @since 2017/10/18
 * @version 1.0
 */
public class CartUpdateDAO {

	public int updateCart(int cart_id, int user_id, int order_count, BigDecimal sub_total) {
		int updateCount = 0;

		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest",
				"root", "mysql");
		Connection con = db.getConnection();
		String sql = "update cart set order_count = ?, sub_total = ?, where user_id = ?, cart_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order_count);
			ps.setBigDecimal(2, sub_total);
			ps.setInt(3, user_id);
			ps.setInt(4, cart_id);
			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCount;

	}

	public ArrayList<CartDTO> itemStatus(int cart_id) {
		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest",
				"root", "mysql");
		Connection con = db.getConnection();

		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sql = "select * from cart where cart_id = ?";
		String sql2 = "SELECT * FROM item WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setCart_id(rs.getInt("cart_id"));
				dto.setItem_id(rs.getInt("cart_id"));
				dto.setOrder_count(rs.getInt("order_count"));
				cartList.add(dto);

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while (rs2.next()) {
					dto.setItem_name(rs2.getString("item_name"));
					dto.setItem_price(rs2.getBigDecimal("item_price"));
					dto.setSub_total(rs.getBigDecimal("sub_total"));
					dto.setItem_stock(rs2.getInt("item_stock"));
				}

				cartList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cartList;
	}

}
