package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.util.DBConnector;



/**
 * 商品一覧を取得するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/13
 * @version 1.0
 */

public class ItemListDAO {

	/**
	 * 商品一覧をMySQLから取得し表示させるためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/19
	 * @version 1.0
	 * @return itemList 商品情報リスト
	 */


	ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	public ArrayList<ItemDTO> select() {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest", "root", "mysql");
		Connection con = db.getConnection();

		String sql = null;
		sql = "select * from item";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItem_id(rs.getInt("item_id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setImg_path(rs.getString("img_path"));
				itemList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}


	/**
	 * カテゴリ別に商品を表示させるためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/19
	 * @version 1.0
	 * @param item_category 商品カテゴリー
	 * @return itemList 商品情報リスト
	 */

	public ArrayList<ItemDTO> select(int item_category) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "template", "root", "mysql");
		Connection con = db.getConnection();

		String sql = null;
		sql = "select * from item where item_category = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItem_id(rs.getInt("item_id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setImg_path(rs.getString("img_path"));
				itemList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}


}