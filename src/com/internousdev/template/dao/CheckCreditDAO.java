package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;



/**
 * クレジットカード情報照合に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @wsince 2017/10/27
 * @version 1.0
 */

public class CheckCreditDAO {

	/**
	 * クレジットカード情報を照合するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/27
	 * @version 1.0
	 * @param credit_type クレジットカード種類
	 * @param credit_number クレジットカード番号
	 * @param credit_holder 名義人
	 * @param expiration_month 有効期限(月)
	 * @param expiration_year 有効期限(年)
	 * @param security_code セキュリティコード
	 * @return selected_num 照合回数
	 */

	public int checkCreditInfo(String credit_type, String credit_number, String credit_holder, String expiration_month, String expiration_year, String security_code) {

		int selected_num = 0;

		try {
			DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
			Connection con = db.getConnection();

			String sql = "SELECT * FROM credit_card WHERE"
					+ " credit_type = ? AND"
					+ " credit_number = ? AND"
					+ " credit_holder = ? AND"
					+ " expiration_month = ? AND"
					+ " expiration_year = ? AND"
					+ " security_code = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, credit_type); //クレジットカード種類
			ps.setString(2, credit_number); //クレジットカード番号
			ps.setString(3, credit_holder); //名義人
			ps.setString(4, expiration_month); //有効期限(月)
			ps.setString(5, expiration_year); //有効期限(年)
			ps.setString(6, security_code); //セキュリティコード
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				selected_num = rs.getInt("credit_id");
			}

			if(con != null) {
				con.close();
				ps.close();
				rs.close();
			}

		} catch(SQLException e) {
			e.printStackTrace();

		}

		return selected_num;
	}

}