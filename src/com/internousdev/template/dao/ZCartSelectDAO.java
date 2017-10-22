package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.DBConnector;



/**
 * カート遷移に関するDAOクラス
 * @author HIANKO HAIGWARA
 * @since 2017/10/16
 * @version 1.0
 */
public class ZCartSelectDAO {

	public ArrayList<CartDTO> selectedItem(int user_id) {

		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest", "root", "mysql");
		Connection con = db.getConnection();

		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sql = "select * from cart where user_id = ?";
		String sql2 = "select * from item where item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setCart_id(rs.getInt("cart_id"));
				dto.setItem_id(rs.getInt("item_id"));
				dto.setOrder_count(rs.getInt("order_count"));
				dto.setSub_total(rs.getBigDecimal("sub_total"));

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while(rs.next()) {

					dto.setItem_name(rs2.getString("item_name"));
					dto.setItem_price(rs2.getBigDecimal("item_price"));
					dto.setSub_total(rs.getBigDecimal("sub_total"));
					dto.setImg_path(rs2.getString("img_path"));
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