package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.CheckCreditDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * クレジットカードの種類を判別し、情報が正しいか確認するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/24
 * @version 1.0
 */

public class CheckCreditAction extends ActionSupport implements SessionAware{

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -5391032299857437684L;

	/**
	 * セッション情報
	 */
	private Map<String,Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 支払い方法
	 */
	private int pay_id;

	/**
	 * クレジットカードID
	 */
	private int credit_id;

	/**
	 * クレジットカード種類
	 */
	private String credit_type;

	/**
	 * クレジット番号
	 */
	private String credit_number_all;

	/**
	 * クレジットカード番号1
	 */
	private String credit_number1;

	/**
	 * クレジットカード番号2
	 */
	private String credit_number2;

	/**
	 * クレジットカード番号3
	 */
	private String credit_number3;

	/**
	 * クレジットカード番号4
	 */
	private String credit_number4;

	/**
	 * クレジット名義
	 */
	private String credit_holder;

	/**
	 * セキュリティコード
	 */
	private String security_code;

	/**
	 * 有効期限（月）
	 */
	private String expiration_month;

	/**
	 * 有効期限（年）
	 */
	private String expiration_year;

	/**
	 * エラーメッセージ
	 */
	private String error_message;

	/**
	 * カートリスト
	 */
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	/**
	 * 銀行振り込み
	 */
	public static final int bank = 1;

	/**
	 * クレジットカード決済
	 */
	public static final int credit = 2;



	/**
	 * クレジットの種類を判別するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/27
	 * @version 1.0
	 * @return SUCCESS or ERROR
	 */

	public String execute() {
		String result = ERROR;

		if(session.containsKey("user_id")) {
			user_id = (int)session.get("user_id");


			error_message = "入力情報に誤りがあります。";

			String credit_number_all =
					credit_number1 + "-" + credit_number2 + "-" + credit_number3 + "-" + credit_number4;

			CheckCreditDAO dao = new CheckCreditDAO();

			if(dao.checkCreditInfo(credit_type, credit_number_all, credit_holder, expiration_month, expiration_year, security_code) > 0) {

				credit_number1 = "****";
				credit_number2 = "****";
				credit_number3 = "****";

				security_code = "***";

				error_message = "";

				result = SUCCESS;
			}
		}

		return result;
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
	 * @return pay_id
	 */
	public int getPay_id() {
		return pay_id;
	}



	/**
	 * @param pay_id セットする pay_id
	 */
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
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
	 * @return credit_type
	 */
	public String getCredit_type() {
		return credit_type;
	}



	/**
	 * @param credit_type セットする credit_type
	 */
	public void setCredit_type(String credit_type) {
		this.credit_type = credit_type;
	}



	/**
	 * @return credit_number_all
	 */
	public String getCredit_number_all() {
		return credit_number_all;
	}



	/**
	 * @param credit_number_all セットする credit_number_all
	 */
	public void setCredit_number_all(String credit_number_all) {
		this.credit_number_all = credit_number_all;
	}



	/**
	 * @return credit_number1
	 */
	public String getCredit_number1() {
		return credit_number1;
	}



	/**
	 * @param credit_number1 セットする credit_number1
	 */
	public void setCredit_number1(String credit_number1) {
		this.credit_number1 = credit_number1;
	}



	/**
	 * @return credit_number2
	 */
	public String getCredit_number2() {
		return credit_number2;
	}



	/**
	 * @param credit_number2 セットする credit_number2
	 */
	public void setCredit_number2(String credit_number2) {
		this.credit_number2 = credit_number2;
	}



	/**
	 * @return credit_number3
	 */
	public String getCredit_number3() {
		return credit_number3;
	}



	/**
	 * @param credit_number3 セットする credit_number3
	 */
	public void setCredit_number3(String credit_number3) {
		this.credit_number3 = credit_number3;
	}



	/**
	 * @return credit_number4
	 */
	public String getCredit_number4() {
		return credit_number4;
	}



	/**
	 * @param credit_number4 セットする credit_number4
	 */
	public void setCredit_number4(String credit_number4) {
		this.credit_number4 = credit_number4;
	}



	/**
	 * @return credit_holder
	 */
	public String getCredit_holder() {
		return credit_holder;
	}



	/**
	 * @param credit_holder セットする credit_holder
	 */
	public void setCredit_holder(String credit_holder) {
		this.credit_holder = credit_holder;
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
	public String getExpiration_month() {
		return expiration_month;
	}



	/**
	 * @param expiration_month セットする expiration_month
	 */
	public void setExpiration_month(String expiration_month) {
		this.expiration_month = expiration_month;
	}



	/**
	 * @return expiration_year
	 */
	public String getExpiration_year() {
		return expiration_year;
	}



	/**
	 * @param expiration_year セットする expiration_year
	 */
	public void setExpiration_year(String expiration_year) {
		this.expiration_year = expiration_year;
	}



	/**
	 * @return error_message
	 */
	public String getError_message() {
		return error_message;
	}



	/**
	 * @param error_message セットする error_message
	 */
	public void setError_message(String error_message) {
		this.error_message = error_message;
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