package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.LogoutDAO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * ログアウトするためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class LogoutAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -380586590629719424L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * ログインフラグ
	 */
	private int login_flg;



	/**
	 * ログアウトするための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @return SUCCESS:ログアウト成功, ERROR:ログアウト失敗
	 */

	public String execute() {
		String result = ERROR;

		if(session.get("user_id") != null) {
			LogoutDAO dao = new LogoutDAO();
			dao.update((int)session.get("user_id"), 0);
			session.clear();
			if(session.isEmpty()) {
				result = SUCCESS;
			}
		}

		return result;
	}



	/**
	 * 生成されたシリアルIDを取得するためのメソッド
	 * @return serialversionuid 生成されたシリアルID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * セッション情報を取得するためのメソッド
	 * @return session セッション情報
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション情報を格納するためのメソッド
	 * @param session セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * ユーザーIDを取得するためのメソッド
	 * @return user_id ユーザーID
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * ユーザーIDを格納するためのメソッド
	 * @param user_id ユーザーID
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * ログインフラグを取得するためのメソッド
	 * @return login_flg ログインフラグ
	 */
	public int getLogin_flg() {
		return login_flg;
	}

	/**
	 * ログインフラグを格納するためのメソッド
	 * @param login_flg ログインフラグ
	 */
	public void setLogin_flg(int login_flg) {
		this.login_flg = login_flg;
	}

}