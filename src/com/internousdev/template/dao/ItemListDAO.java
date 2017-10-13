package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;



/**
 * 商品一覧を取得するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/13
 * @version 1.0
 */
public class ItemListDAO {

	/**
	 * 商品一覧をMySQLから検索するメソッド
	 * @param item_category 商品カテゴリー
	 * @return itemList 商品情報のリスト
	 */
	public ArrayList<ItemDTO> select(int item_category) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

		ItemDTO dto = null;
		String sql;
		if(item_category != 0) {
			sql = "SELECT * FROM item where category=? ORDER BY item_name ASC";
		} else {
			sql = "SELECT * FROM item ORDER BY item_name ASC";

		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if(item_category != 0) ps.setInt(1, item_category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto = new ItemDTO();
				dto.setItem_id(rs.getInt("item_id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setItem_stock(rs.getInt("item_stock!"));
				dto.setImg_path(rs.getString("img_path"));
				dto.setItem_comment(rs.getString("itme_commect"));
				if(item_category != 0) dto.setItem_category(rs.getInt("item_category"));
				itemList.add(dto);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return itemList;

	}

}