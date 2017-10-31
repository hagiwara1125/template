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
	 * 商品一覧の情報を取得し格納するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/22
	 * @version 1.0
	 * @param item_category 商品カテゴリ
	 * @return itemList 商品一覧情報リスト
	 */

	public ArrayList<ItemDTO> select(int item_category){
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/","calicocat", "root", "mysql");
		Connection con =db.getConnection();
		ArrayList<ItemDTO> itemList =new ArrayList<ItemDTO>();

		ItemDTO dto = null;

		String sql;

		if(item_category != 0){
			sql = "SELECT * FROM item WHERE item_category = ? ORDER BY item_id ASC";
		}else{
			sql = "SELECT * FROM item ORDER BY item_id ASC";
		}

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			if(item_category != 0)ps.setInt(1, item_category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto =new ItemDTO();
				dto.setItem_id(rs.getInt("item_id")); //商品ID
				dto.setItem_name(rs.getString("item_name")); //商品名
				dto.setItem_stock(rs.getInt("item_stock")); //在庫数
				dto.setItem_price(rs.getBigDecimal("item_price")); //価格
				dto.setImg_path(rs.getString("img_path")); //画像パス
				dto.setItem_comment(rs.getString("item_comment")); //商品説明
				if(item_category != 0)dto.setItem_category(rs.getInt("item_category"));
				itemList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemList;
	}
}