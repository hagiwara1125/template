package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;



/**
 * TOP画面へ遷移するActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/16
 * @version 1.0
 */
public class ZGoTopAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -1888983405841259065L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;



	/**
	 * TOP画面に遷移するための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/16
	 * @version 1.0
	 */
	public String execute() {
		String result = SUCCESS;

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
