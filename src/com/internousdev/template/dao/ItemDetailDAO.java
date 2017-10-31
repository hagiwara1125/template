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

	/**
	 * 商品詳細情報を取得し格納するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/22
	 * @version 1.0
	 * @param item_id 商品ID
	 * @return displayList 商品詳細情報リスト
	 */

	public ArrayList<ItemDTO> select(int item_id) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/","calicocat", "root", "mysql");
		Connection con =db.getConnection();
		ArrayList<ItemDTO> displayList =new ArrayList<ItemDTO>();
		ItemDTO dto = null;


		String sql = "SELECT * FROM item WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				dto =new ItemDTO();
				dto.setItem_id(rs.getInt("item_id")); //商品ID
				dto.setItem_category(rs.getInt("item_category")); //商品カテゴリ
				dto.setItem_name(rs.getString("item_name")); //商品名
				dto.setItem_price(rs.getBigDecimal("item_price")); //価格
				dto.setItem_stock(rs.getInt("item_stock")); //在庫数
				dto.setImg_path(rs.getString("img_path")); //画像パス
				dto.setItem_comment(rs.getString("item_comment")); //商品説明
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