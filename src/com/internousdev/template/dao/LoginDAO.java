package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;



/**
 * ログインに関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class LoginDAO {

	/**
	 * DBから会員情報を取得するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @param phone_email メールアドレス
	 * @param password パスワード
	 * @return dto ユーザー情報
	 */

	public LoginDTO select(String phone_email, String password) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();

		String sql = "SELECT * FROM users WHERE phone_email = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, phone_email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				dto.setPhone_email(rs.getString("phone_email")); //メールアドレス
				dto.setPassword(rs.getString("password")); //パスワード
				dto.setUser_id(rs.getInt("user_id")); //ユーザーID
				dto.setUser_flg(rs.getInt("login_flg")); //ログインフラグ
				dto.setUser_flg(rs.getInt("user_flg")); //ユーザーフラグ
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return dto;
	}


	/**
	 * ログインフラグを1に更新するメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @param phone_email メールアドレス
	 * @param password パスワード
	 * @return count 更新回数
	 */

	public int update(int user_id) {
		int count = 0;
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "UPDATE users SET login_flg = 1 WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			count = ps.executeUpdate();

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


	/**
	 * ログインフラグが1のままセッションが切られた時にログインフラグを0にするためのメソッド
	 * @since 2017/10/20
	 * @version 1.0
	 * @param user_name 氏名
	 * @param password パスワード
	 * @return count 更新回数
	 */

	public int loginflg(String user_name, String password) {
		int count = 0;
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "UPDATE users SET login_flg = 0 WHERE user_name = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, password);
			count = ps.executeUpdate();

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