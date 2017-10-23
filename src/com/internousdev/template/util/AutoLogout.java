package com.internousdev.template.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.internousdev.util.login.LogoutDAO;



/**
 * セッション切れの場合自動でログアウトするクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/23
 * @version 1.0
 */

public class AutoLogout implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {

	}

	public void sessionDestroyed(HttpSessionEvent event) {



		// セッションが消される時のセッションキーを取得する
		Object logoutUserId = event.getSession().getAttribute("user_id");

		if(logoutUserId != null) {
			int userId = (int) logoutUserId;

			LogoutDAO dao = new LogoutDAO();
			dao.update(userId, false);
		}
	}

}