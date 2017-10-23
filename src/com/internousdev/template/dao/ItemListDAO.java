package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.util.DBConnector;



/**
 * 商品一覧情報に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/22
 * @version 1.0
 */

public class ItemListDAO {

	/**
	 * 商品一覧リストを表示するためのメソッド
	 * @author HINAKO HAGIWAR
	 * @since 2017/10/22
	 * @version 1.0
	 * @return itemList 商品一覧リスト
	 */

	public ArrayList<ItemDTO> select(int item_category) {
		DBConnector db = new DBConnector("com.mysql..jdbc.Driver", "jdbc:mysql://localhost/", "calico", "root", "mysql");
		Connection con = db.getConnection();
		ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

		ItemDTO dto = null;
		String sql;
		if(item_category != 0) {
			sql = "SELECT * FROM item WHERE category = ? ORDER BY item_name ASC";
		} else {
			sql = "SELECT * FROM item ORDER BY item_name ASC";
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto = new ItemDTO();
				dto.setItem_id(rs.getInt("item_id"));
				dto.setVariation_id(rs.getInt("variateionn_id"));
				dto.setItem_user(rs.getInt("item_user"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_color(rs.getString("item_color"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setImg_path(rs.getString("img_path"));
				dto.setItem_comment(rs.getString("item_comment"));
				if(item_category != 0)dto.setItem_category(rs.getInt("item_category"));
				itemList.add(dto);

			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return itemList;

	}

}