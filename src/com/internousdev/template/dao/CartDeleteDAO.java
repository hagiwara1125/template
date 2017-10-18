package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.MySQLConnector;



/**
 * カートテーブル内情報の削除に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/16
 * @version 1.0
 */
public class CartDeleteDAO {

	public int delete(int user_id, int cart_id) {
		int delCount = 0;
		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "templatetest", "root", "mysql");
		Connection con = db.getConnection();
		String sql = "delete from cart where user_id = ? and cart_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, cart_id);
			delCount = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return delCount;
	}
}