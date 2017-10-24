package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;



/**
 * 商品詳細情報に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/22
 * @version 1.0
 */

public class ItemDetailDAO {

	public ArrayList<ItemDTO> select(int item_id) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		ItemDTO dto = new ItemDTO();
		ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();


		String sql = "SELECT * FROM item WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				dto.setItem_id(rs.getInt("item_id"));
				dto.setItem_category(rs.getInt("item_category"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setImg_path(rs.getString("img_path"));
				dto.setItem_comment(rs.getString("item_comment"));
				displayList.add(dto);
			}

		} catch(SQLException e) {
			e.printStackTrace();

	}
		try {
			con.close();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return displayList;

	}

}