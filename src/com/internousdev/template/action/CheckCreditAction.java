package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CartSelectDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.util.creditcard.manager.CreditUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * クレジットカードの種類を判別し、情報が正しいか確認するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/24
 * @version 1.0
 */

public class CheckCreditAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -5464269166944278350L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * クレジットカード種類
	 */
	private int credit_id;

	/**
	 * クレジットカードブランド
	 */
	private String credit_brand;

	/**
	 * クレジットカード番号
	 */
	private String credit_number;

	/**
	 * 名義人
	 */
	private String credit_name;

	/**
	 * セキュリティコード
	 */
	private String security_code;

	/**
	 * 有効期限(月)
	 */
	private int expiration_month;

	/**
	 * 有効期限(年)
	 */
	private int expiration_year;

	/**
	 * エラーフラグ
	 */
	private int err_flg = 0;

	/**
	 * カート情報リスト
	 */
	ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();




	public String execute() {
		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");
			CartSelectDAO dao = new CartSelectDAO();
			cartList = dao.selectedItem(user_id);

			if(credit_number.startsWith("4")) {
				credit_id = 1;
			} else if(credit_number.startsWith("5")) {
				credit_id = 2;
			} else if(credit_number.startsWith("3")) {
				credit_id = 3;
			} else {
				err_flg = 1;
				return ERROR;
			}

			if(credit_id == 1) {
				credit_brand = "Visa";
			} else if(credit_id == 2) {
				credit_brand = "MasterCard";
			} else if(credit_id == 3) {
				credit_brand = "AmericanExpress";
			}

			CreditUtil util = new CreditUtil(credit_id, credit_number);

			//クレジットカード番号上6桁の照合
			if(util.brandCheck()) {
				//クレジットカード番号16桁、セキュリティコード、有効期限、名義人の照合
				if(util.creditCheck(security_code, expiration_month, expiration_year, credit_name)) {

					return SUCCESS;

				} else {
					err_flg = 1;
					return ERROR;
				}
			} else {
				err_flg = 1;
				return ERROR;
			}

		} else {
			return ERROR;
		}
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
	 * @return credit_id
	 */
	public int getCredit_id() {
		return credit_id;
	}




	/**
	 * @param credit_id セットする credit_id
	 */
	public void setCredit_id(int credit_id) {
		this.credit_id = credit_id;
	}




	/**
	 * @return credit_brand
	 */
	public String getCredit_brand() {
		return credit_brand;
	}




	/**
	 * @param credit_brand セットする credit_brand
	 */
	public void setCredit_brand(String credit_brand) {
		this.credit_brand = credit_brand;
	}




	/**
	 * @return credit_number
	 */
	public String getCredit_number() {
		return credit_number;
	}




	/**
	 * @param credit_number セットする credit_number
	 */
	public void setCredit_number(String credit_number) {
		this.credit_number = credit_number;
	}




	/**
	 * @return credit_name
	 */
	public String getCredit_name() {
		return credit_name;
	}




	/**
	 * @param credit_name セットする credit_name
	 */
	public void setCredit_name(String credit_name) {
		this.credit_name = credit_name;
	}




	/**
	 * @return security_code
	 */
	public String getSecurity_code() {
		return security_code;
	}




	/**
	 * @param security_code セットする security_code
	 */
	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}




	/**
	 * @return expiration_month
	 */
	public int getExpiration_month() {
		return expiration_month;
	}




	/**
	 * @param expiration_month セットする expiration_month
	 */
	public void setExpiration_month(int expiration_month) {
		this.expiration_month = expiration_month;
	}




	/**
	 * @return expiration_year
	 */
	public int getExpiration_year() {
		return expiration_year;
	}




	/**
	 * @param expiration_year セットする expiration_year
	 */
	public void setExpiration_year(int expiration_year) {
		this.expiration_year = expiration_year;
	}




	/**
	 * @return err_flg
	 */
	public int getErr_flg() {
		return err_flg;
	}




	/**
	 * @param err_flg セットする err_flg
	 */
	public void setErr_flg(int err_flg) {
		this.err_flg = err_flg;
	}




	/**
	 * @return cartList
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}




	/**
	 * @param cartList セットする cartList
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}




	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
