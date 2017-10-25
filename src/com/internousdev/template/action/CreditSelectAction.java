package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;



public class CreditSelectAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 5857997141423040932L;
	/**
	 * セッション
	 */
	private Map<String, Object> session;

	public String execute() {
		return SUCCESS;
	}

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	*	sessionを取得するメソッド
	*	@return session
	*/
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	*	sessionを格納する
	*	@param session
	*/
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}