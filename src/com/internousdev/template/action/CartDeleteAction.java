package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartDeleteDAO;
import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * カート内の商品を削除するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class CartDeleteAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 2981545994323859728L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * カートID
	 */
	private int cart_id;

	/**
	 * 注文数
	 */
	private int order_count;

	/**
	 * 合計金額
	 */
	private BigDecimal sub_total = BigDecimal.ZERO;

	/**
	 * 削除回数
	 */
	private int delCount;

	/**
	 * カート内情報リスト
	 */
	private List<CartDTO> cartList = new ArrayList<>();



	/**
	 * カート内の商品を削除するための実行メソッド
	 * @author HINAKO HAGIWRA
	 * @since 2017/10/23
	 * @version 1.0
	 * @resturn SUCCESS:削除成功, ERROR:削除失敗
	 */

	public String execute() {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");

			CartDeleteDAO dao = new CartDeleteDAO();
			CartSelectDAO dao2 = new CartSelectDAO();

			delCount =dao.delete(user_id, cart_id);
			if(delCount > 0) {
				cartList = dao2.selectedItem(user_id);
				if(cartList.size() > 0) {
					for(int i = 0; i < cartList.size(); i++) {
						sub_total = sub_total.add((cartList.get(i).getItem_price()).multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count())));
						cartList.get(i).setSub_total(sub_total);
					}

					result = SUCCESS;
				}
			}

		} else {
			result = LOGIN;

		}

		return result;

	}



	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}



	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	/**
	 * @return user_id
	 */
	public int getUser_id() {
		return user_id;
	}



	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	/**
	 * @return cart_id
	 */
	public int getCart_id() {
		return cart_id;
	}



	/**
	 * @param cart_id セットする cart_id
	 */
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}



	/**
	 * @return order_count
	 */
	public int getOrder_count() {
		return order_count;
	}



	/**
	 * @param order_count セットする order_count
	 */
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}



	/**
	 * @return sub_total
	 */
	public BigDecimal getSub_total() {
		return sub_total;
	}



	/**
	 * @param sub_total セットする sub_total
	 */
	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}



	/**
	 * @return delCount
	 */
	public int getDelCount() {
		return delCount;
	}



	/**
	 * @param delCount セットする delCount
	 */
	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}



	/**
	 * @return cartList
	 */
	public List<CartDTO> getCartList() {
		return cartList;
	}



	/**
	 * @param cartList セットする cartList
	 */
	public void setCartList(List<CartDTO> cartList) {
		this.cartList = cartList;
	}

}
