package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;



/**
 * ログアウトに関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class LogoutDAO {

	/**
	 * ログアウトをするためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @param login_flg ログインフラグ
	 * @return count 更新回数
	 */

	public int update(int user_id, int login_flg) {
		int count = 0;
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "update users set login_flg = ? where user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, login_flg);
			ps.setInt(2, user_id);
			ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return count;
	}

}