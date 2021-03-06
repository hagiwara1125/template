package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.DBConnector;



/**
 * カート情報に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartSelectDAO {

	/**
	 * カート情報を取得するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @return cartList カート情報
	 */

	public ArrayList<CartDTO> selectedItem(int user_id) {
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
				dto.setSub_total(rs.getBigDecimal("sub_total")); //小計

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while(rs2.next()) {
					dto.setItem_name(rs2.getString("item_name")); //商品名
					dto.setItem_price(rs2.getBigDecimal("item_price")); //価格
					dto.setSub_total(rs.getBigDecimal("sub_total")); //小計
					dto.setImg_path(rs2.getString("img_path")); //画像パス
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