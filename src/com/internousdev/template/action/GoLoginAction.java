package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;



/**
 * ログイン画面に遷移するためのクラス
 * @author HIANAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class GoLoginAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 3302807651272581229L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;



	/**
	 * ログイン画面に遷移するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @return success 成功
	 */
	public String execute() {
		return SUCCESS;

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


}