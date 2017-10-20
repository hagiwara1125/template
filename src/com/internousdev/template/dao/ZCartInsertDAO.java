package com.internousdev.template.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ZCartDTO;
import com.internousdev.template.dto.ZItemDTO;
import com.internousdev.template.util.MySQLConnector;



/**
 * カートテーブルに追加する商品の情報を取得するDAOクラス
 * @author HINAKO HAIGWARA
 * @since 2017/10/16
 * @version 1.0
 */
public class ZCartInsertDAO {

	public ArrayList<ZItemDTO> itemStatus(int item_id) {

		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest", "root", "mysql");
		Connection con = db.getConnection();
		ArrayList<ZItemDTO> itemList = new ArrayList<ZItemDTO>();

		String sql = "select * from item where item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ZItemDTO dto = new ZItemDTO();
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getBigDecimal("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setItem_comment(rs.getString("item_comment"));

				itemList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return itemList;
	}


	/**
	 * カートテーブルへ情報を追加するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/16
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @param item_id 商品ID
	 * @param order_count 注文数
	 * @param sub_total 小計
	 * @return addCount 追加件数
	 */
	public int addToCart(int user_id, int item_id, int order_count, BigDecimal sub_total) {
		int addCount = 0;

		MySQLConnector db = new MySQLConnector("con.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest", "root", "mysql");
		Connection con = db.getConnection();
		String sql = "insert into cart(user_id, item_id, order_count, sub_total) values(?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, item_id);
			ps.setInt(3, order_count);
			ps.setBigDecimal(4, sub_total);
			addCount = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return addCount;

	}


	/**
	 * カート内の商品情報を取得しリストに格納するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/16
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @return cartList カート情報
	 */

	public ArrayList<ZCartDTO> selected(int user_id) {

		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest", "root", "mysql");
		Connection con = db.getConnection();
		ArrayList<ZCartDTO> cartList = new ArrayList<ZCartDTO>();
		String sql = "select * from cart where user_id = ?";
		String select2 = "SELECT * FROM item WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ZCartDTO dto = new ZCartDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setCart_id(rs.getInt("cart_id"));
				dto.setItem_id(rs.getInt("item_id"));
				dto.setOrder_count(rs.getInt("order_count"));
				cartList.add(dto);

				PreparedStatement ps2 = con.prepareStatement(select2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while(rs2.next()) {
					dto.setItem_name(rs2.getString("item_name"));
					dto.setItem_price(rs2.getBigDecimal("item_price"));
				}
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



	/**
	 * カート内に同じ商品があった場合、数量を足すメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/16
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @param item_id 商品ID
	 * @param order_count 注文数
	 * @return addCount 追加件数
	 */

	public int update(int user_id, int item_id, int order_count, BigDecimal sub_total) {
		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest", "root", "mysql");
		Connection con = db.getConnection();
		String sql = "update cart set order_count = ?, sub_total = ? where user_id = ? and item_id = ?";

		int addCount = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, item_id);
			ps.setInt(3, order_count);
			ps.setBigDecimal(4, sub_total);
			addCount = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return addCount;
	}

}