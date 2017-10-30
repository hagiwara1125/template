package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class AdminPurchaseHistoryAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -126629314965055072L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;


	public String execute() {
		String result = ERROR;

		if(session.get("user_id") != null) {

			result = SUCCESS;
			if(search_user_name == null) {
				search_user_name = "";
			}
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


}
