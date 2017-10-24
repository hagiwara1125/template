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

	public ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	/**
	 * 商品一覧リストを取得するためのメソッド
	 * @author HINAKO HAGIWAR
	 * @since 2017/10/22
	 * @version 1.0
	 * @return itemList 商品一覧リスト
	 */

	public ArrayList<ItemDTO> select() {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = null;
		sql = "SELECT * FROM item";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItem_id(rs.getInt("item_id"));
				dto.setVariation_id(rs.getInt("variateion_id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setImg_path(rs.getString("img_path"));
				dto.setItem_page(rs.getInt("item_page"));
				itemList.add(dto);

				System.out.println("ItemListAction - 取得商品一覧 : " + itemList);
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



	/**
	 * カテゴリ別に商品を表示させる情報リスト取得のためのメソッド
	 * @author HIANKO HAGIWARA
	 * @since2 017/10/22
	 * @version 1.0
	 */

	public ArrayList<ItemDTO> select(int item_category) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = null;
		sql = "SELECT * FROM item WHERE item_category = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItem_id(rs.getInt("item_id"));
				dto.setVariation_id(rs.getInt("variateion_id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setImg_path(rs.getString("img_path"));
				dto.setItem_page(rs.getInt("item_page"));
				dto.setCategory_page(rs.getInt("category_page"));
				itemList.add(dto);
			}

			System.out.println("ItemListAction - カテゴリ別取得商品一覧 : " + itemList);

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