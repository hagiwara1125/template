package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.UserDTO;
import com.internousdev.template.util.DBConnector;



/**
 * 会員情報に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class MyPageDAO {

	/**
	 * 会員情報を取得してリストに格納するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @return userList ユーザーリスト
	 */

	public ArrayList<UserDTO> select(int user_id) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();

		String sql = "SELECT * FROM users WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setPhone_email(rs.getString("phone_email"));
				dto.setPassword(rs.getString("password"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setPostal(rs.getString("postal"));
				dto.setAddress(rs.getString("address"));
				dto.setUser_flg(rs.getInt("user_flg"));
				userList.add(dto);

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}
		try {
			con.close();
		} catch(Exception e) {
			e.printStackTrace();

		}

		return userList;
	}

}