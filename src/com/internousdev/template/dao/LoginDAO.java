package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.MySQLConnector;



/**
 * ログインに関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class LoginDAO {

	/**
	 * DBから会員情報を取得するためのメソッド
	 * @param phone_email メールアドレス
	 * @param password パスワード
	 * @return dto 会員情報を格納する
	 */

	public LoginDTO select(String phone_email, String password) {
		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();

		String sql = "select * from users where phone_email = ? and password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, phone_email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				dto.setUser_id(rs.getInt("user_id"));
				dto.setPhone_email(rs.getString("phone_email"));
				dto.setPassword(rs.getString("password"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setLogin_flg(rs.getBoolean("login_flg"));
				dto.setUser_flg(rs.getInt("user_flg"));

			}

		}catch(SQLException e) {
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
	 * ログインフラグを更新するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @param phone_email メールアドレス
	 * @param password パスワード
	 * @return cound 更新回数
	 */

	public int update(String phone_email, String password) {
		int count = 0;
		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		String sql = "update users set login_flg = true where phone_email = ? and password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, phone_email);
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


	/**
	 * ログインフラグがtrueのままセッションが切れた時にログインフラグをfalseにするためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @param user_name 氏名
	 * @param password パスワード
	 * @return count 更新回数
	 */

	public int loginflg(String user_name, String password) {
		int count = 0;
		MySQLConnector db = new MySQLConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "update users set login_flg = false where family_name = ? and password = ?";

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