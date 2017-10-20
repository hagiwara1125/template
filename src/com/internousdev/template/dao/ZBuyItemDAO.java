package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.ZBuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class ZBuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ZBuyItemDTO buyItemDTO = new ZBuyItemDTO();

	/**
	 * 商品情報取得メソッド
	 *
	 * @return ZBuyItemDTO
	 */
	public ZBuyItemDTO getBuyItemInfo() {

		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return buyItemDTO;
	}

	public ZBuyItemDTO getZBuyItemDTO() {
		return buyItemDTO;
	}
}