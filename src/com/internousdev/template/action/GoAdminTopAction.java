package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;



/**
 * 管理者TOP画面へ遷移するためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class GoAdminTopAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -5479504922026765803L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;



	/**
	 * 管理者TOP画面に遷移するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @return ERROR or SUCCESS
	 */

	public String execute() {
		String result = ERROR;

		if(session.get("user_id") != null) {
			result = SUCCESS;
		}

		return result;
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