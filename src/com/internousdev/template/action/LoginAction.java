package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;



/**
 * ログインするためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = -2623658405143610601L;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * メールアドレス
	 */
	private String phone_email;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ログインフラグ
	 */
	private int login_flg;

	/**
	 * 管理者
	 */
	private boolean admin = true;



	/**
	 * ログインするための実行メソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @version 1.0
	 * @return SUCCESS:ログイン成功, ERROR:ログイン失敗, admin:管理者ログイン
	 */

	public String execute() {
		String result = ERROR;

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto = dao.select(phone_email, password);

		if(login_flg == 1) {
			return ERROR;
		}

		if(phone_email.equals(dto.getPhone_email())) {
			if(password.equals(dto.getPassword())) {
				if(dto.getLogin_flg() != 1) {
					if(admin) {
						dao.update(dto.getUser_id());
						int user_flg = (int)dto.getUser_flg();
						if(user_flg == 3) {
							session.put("user_flg", dto.getUser_flg());
							session.put("user_id", dto.getUser_id());
							session.put("login_flg", dto.getLogin_flg());
							result = "adimin";

						} else {
							session.put("user_flg", dto.getUser_flg());
							session.put("user_id", dto.getUser_id());
							session.put("login_flg", dto.getLogin_flg());
							result = SUCCESS;
						}
					}
				}
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
	 * メールアドレスを取得するためのメソッド
	 * @return phone_email メールアドレス
	 */
	public String getPhone_email() {
		return phone_email;
	}

	/**
	 * メールアドレスを格納するためのメソッド
	 * @param phone_email メールアドレスl
	 */
	public void setPhone_email(String phone_email) {
		this.phone_email = phone_email;
	}

	/**
	 * パスワードを取得するためのメソッド
	 * @return password パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを格納するためのメソッド
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * 管理者を取得するためのメソッド
	 * @return admin 管理者
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * 管理者を格納するためのメソッド
	 * @param admin 管理者
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}