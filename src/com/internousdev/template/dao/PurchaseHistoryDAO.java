package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.PurchaseDTO;
import com.internousdev.template.util.DBConnector;



/**
 * 購入履歴に関するDAOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/30
 * @version 1.0
 */

public class PurchaseHistoryDAO {

	/**
	 * 購入履歴を取得し格納するためのメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/30
	 * @version 1.0
	 * @param user_id ユーザーID
	 * @return purchaseHistoryList 購入履歴情報リスト
	 */

	public ArrayList<PurchaseDTO> purchaseHistoryList = new ArrayList<PurchaseDTO>();

	public ArrayList<PurchaseDTO> purchaseHistoryList(int user_id) {
		DBConnector db = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "calicocat", "root", "mysql");
		Connection con = db.getConnection();

		String sql = "SELECT item_name, order_count, sub_total, date_format(purchase_date, '%Y-%m-%d')"
				+ " AS 'purchase_date' FROM purchase left JOIN item ON purchase.item_id = item.item_id"
				+ " WHERE user_id = ? ORDER BY purchase_date DESC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				PurchaseDTO dto = new PurchaseDTO();
				dto.setItem_name(rs.getString("item_name")); //商品名
				dto.setSub_total(rs.getBigDecimal("sub_total")); //小計
				dto.setOrder_count(rs.getInt("order_count")); //注文数
				dto.setPurchase_date(rs.getString("purchase_date")); //購入日

				purchaseHistoryList.add(dto);
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

		return purchaseHistoryList;

	}

}