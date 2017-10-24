package com.internousdev.template.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.DBConnector;



/**
 * 決済完了に関するDAOクラス
 * @author HIANKO HAGIWARA
 * @since 2017/10/24
 * @version 1.0
 */

public class PurchaseCompleteDAO {

	/**
	 * 商品とカートの情報を取得するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/24
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @return cartList カート情報リスト
	 */

	public ArrayList<CartDTO> cartSelect(int user_id) {

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
				dto.setUser_id(rs.getInt("user_id"));
				dto.setCart_id(rs.getInt("cart_id"));
				dto.setItem_id(rs.getInt("item_id"));
				dto.setOrder_count(rs.getInt("order_count"));

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while(rs.next()) {
					dto.setItem_name(rs2.getString("item_name"));
					dto.setItem_price(rs2.getBigDecimal("item_price"));
					dto.setImg_path(rs2.getString("img_path"));
					dto.setItem_stock(rs2.getInt("item_stock"));

				}

				cartList.add(dto);

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}finally {
			try {
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}

		}

		return cartList;

	}


	/**
	 * 購入情報を登録するためのメソッド
	 * @param user_id ユーザーID
	 * @param item_id 商品ID
	 * @param order_count 注文数
	 * @param sub_total 小計
	 * @return 登録件数
	 */

	public int purchaseInsert(int user_id, int item_id, int order_count, BigDecimal sub_total) {
		int addCount = 0;

		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "INSERT INTO purchase(user_id, item_id, order_count, sub_total) VALUES(?, ?, ?, ?)";

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
	 * カートテーブル内の情報を削除するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/24
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @return ret 削除件数
	 */
	public int cartDelete(int user_id) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		int ret = 0;

		String sql = "DELETE FROM cart WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ret = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}


	/**
	 * 商品在庫数を更新するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/24
	 * @version 1.0
	 * @param item_id 商品ID
	 * @param item_stock 商品在庫数
	 * @return ret 更新件数
	 */
	public int stockUpdate(int item_id, int new_stock) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		int ret = 0;

		String sql = "UPDATE item SET item_stock = ? WHERE item_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			ps.setInt(2, new_stock);
			ret = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

}