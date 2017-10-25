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
	private int creditId;

	/**
	 * クレジットカードブランド
	 */
	private String creditBrand;

	/**
	 * クレジットカード番号
	 */
	private String creditNumber;

	/**
	 * 名義人
	 */
	private String nameE;

	/**
	 * セキュリティコード
	 */
	private String securityCode;

	/**
	 * 有効期限(月)
	 */
	private int expirationMonth;

	/**
	 * 有効期限(年)
	 */
	private int expirationYear;

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

			if(creditNumber.startsWith("4")) {
				creditId = 1;
			} else if(creditNumber.startsWith("5")) {
				creditId = 2;
			} else if(creditNumber.startsWith("3")) {
				creditId = 3;
			} else {
				err_flg = 1;
				return ERROR;
			}

			if(creditId == 1) {
				creditBrand = "Visa";
			} else if(creditId == 2) {
				creditBrand = "MasterCard";
			} else if(creditId == 3) {
				creditBrand = "AmericanExpress";
			}

			CreditUtil util = new CreditUtil(creditId, creditNumber);

			//クレジットカード番号上6桁の照合
			if(util.brandCheck()) {
				//クレジットカード番号16桁、セキュリティコード、有効期限、名義人の照合
				if(util.creditCheck(securityCode, expirationMonth, expirationYear, nameE)) {

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
	 * @return creditId
	 */
	public int getCreditId() {
		return creditId;
	}




	/**
	 * @param creditId セットする creditId
	 */
	public void setCreditId(int creditId) {
		this.creditId = creditId;
	}




	/**
	 * @return creditBrand
	 */
	public String getCreditBrand() {
		return creditBrand;
	}




	/**
	 * @param creditBrand セットする creditBrand
	 */
	public void setCreditBrand(String creditBrand) {
		this.creditBrand = creditBrand;
	}




	/**
	 * @return creditNumber
	 */
	public String getCreditNumber() {
		return creditNumber;
	}




	/**
	 * @param creditNumber セットする creditNumber
	 */
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}




	/**
	 * @return nameE
	 */
	public String getNameE() {
		return nameE;
	}




	/**
	 * @param nameE セットする nameE
	 */
	public void setNameE(String nameE) {
		this.nameE = nameE;
	}




	/**
	 * @return securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}




	/**
	 * @param securityCode セットする securityCode
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}




	/**
	 * @return expirationMonth
	 */
	public int getExpirationMonth() {
		return expirationMonth;
	}




	/**
	 * @param expirationMonth セットする expirationMonth
	 */
	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}




	/**
	 * @return expirationYear
	 */
	public int getExpirationYear() {
		return expirationYear;
	}




	/**
	 * @param expirationYear セットする expirationYear
	 */
	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
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
