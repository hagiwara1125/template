package com.internousdev.template.action;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TOP画面からマイページ画面に遷移するActionクラス
 * @author HINAKO HAIGWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class GoMyPageAction extends ActionSupport implements SessionAware {

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

}
