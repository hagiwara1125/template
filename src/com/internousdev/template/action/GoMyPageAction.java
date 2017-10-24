package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TOP画面からマイページ画面に遷移するActionクラス
 * @author HINAKO HAIGWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class GoMyPageAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 884068714403843702L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * メールアドレス
	 */
	private String phone_email;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 氏名
	 */
	private String user_name;

	/**
	 * 郵便番号
	 */
	private String postal;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * 会員情報リスト
	 */
	private ArrayList<UserDTO> userList = new ArrayList<UserDTO>();



	/**
	 * 会員情報を表示するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/23
	 * @version 1.0
	 * @return SUCEESS or ERROR
	 */

	public String execute() {
		if(session.get("user_id") == null) {
			return ERROR;
		}

		user_id = (int)session.get("user_id");
		MyPageDAO dao = new MyPageDAO();
		userList = dao.select(user_id);

		if(userList.size() == 0) {
			return ERROR;

		} else {

			return SUCCESS;
		}

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
	 * @return phone_email
	 */
	public String getPhone_email() {
		return phone_email;
	}




	/**
	 * @param phone_email セットする phone_email
	 */
	public void setPhone_email(String phone_email) {
		this.phone_email = phone_email;
	}




	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return user_name
	 */
	public String getUser_name() {
		return user_name;
	}




	/**
	 * @param user_name セットする user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}




	/**
	 * @return postal
	 */
	public String getPostal() {
		return postal;
	}




	/**
	 * @param postal セットする postal
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}




	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}




	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}




	/**
	 * @return userList
	 */
	public ArrayList<UserDTO> getUserList() {
		return userList;
	}




	/**
	 * @param userList セットする userList
	 */
	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}


}
