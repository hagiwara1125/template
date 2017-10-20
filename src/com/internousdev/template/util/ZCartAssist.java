package com.internousdev.template.util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.template.dao.ZItemListDAO;
import com.internousdev.template.dto.ZCartDTO;
import com.internousdev.template.dto.ZItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author HINAKO HAGIWARA
 * @since 2017/10/16
 * @version 1.0
 */
public class ZCartAssist extends ActionSupport {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -2678566520288830251L;

	/**
	 * 合計金額
	 */
	private BigDecimal total_price = BigDecimal.ZERO;

	/**
	 * 合計注文数
	 */
	private int total_order;

	/**
	 * 注文数と商品の在庫数の合計
	 */
	private int total_number;



	/**
	 * カートに入っている商品の合計金額を計算して返すメソッド
	 * @param cartList カート内情報リスト
	 * @return total_price 合計金額
	 */
	public BigDecimal total_price(List<ZCartDTO> cartList) {
		cartList.forEach(cart -> total_price = total_price.add(cart.getItem_price().multiply(BigDecimal.valueOf(cart.getOrder_count()))));
		return total_price;
	}


	/**
	 * カートに入っている商品数を合計して返すメソッド
	 * @param cartList カート内情報リスト
	 * @return total_order 合計注文数
	 */
	public int total_order(List<ZCartDTO> cartList) {
		cartList.forEach(cart -> total_order += cart.getOrder_count());
		return total_order;
	}


	/**
	 * 注文数と在庫数を比較して在庫より上回らないようにするメソッド
	 * @param cart_id カートID
	 * @param quantity 注文数
	 * @param item_id 商品ID
	 * @return total_number 注文数と商品の在庫数の合計
	 * @throws SQLException 例外
	 */
	public int total_number(int cart_id, int quantity, int item_id) throws SQLException {
		ZItemListDAO itemStock = new ZItemListDAO();
		List<ZItemDTO> itemList = new ArrayList<>();
		itemList = itemStock.select(item_id);
		int stock = Math.min(itemList.get(0).getItem_stock(), 99);
		this.total_number = Math.min(cart_id + quantity, stock);
		return this.total_number;
	}

}