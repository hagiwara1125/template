package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.util.LoginConnector;
import com.opensymphony.xwork2.ActionSupport;



/**
 * ログイン画面からログインするためのActionクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルID
	 */
	private static final long serialVersionUID = 4645576835938878193L;

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
	 * ログインフラグ
	 */
	private boolean login_flg;

	/**
	 * ユーザーフラグ
	 */
	private int user_flg;

	/**
	 * エラーメッセージ(日本語)
	 */
	private String errmsg1;

	/**
	 * エラーメッセージ(英語)
	 */
	private String errmsg2;



	/**
	 * ユーザー認証できればSUCCESS, 管理者認証できればLOGINを返すメソッド
	 * @author HINAKO HAGIWARA
	 * @since 2017/10/20
	 * @verion 1.0
	 * @return ログイン成功=SUCCESS, ログイン失敗=ERROR, 管理者ログイン=LOGIN
	 */

	public String execute() {
		String result = ERROR;

		LoginConnector login = new LoginConnector(phone_email,password);
		result = null;
		result = login.login(session);

		if(result.equals("error")){
			errmsg1 = "※入力が間違っているか、既にログインされています。";
			errmsg2 = "(Incorrect Email/Password or you are already logged in)";
			session.put("user", result);

		} else if(result.equals("login")) {
			session.put("user", result);

		} else if(result.equals("success")) {
			session.put("user", result);
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
	 * @return user_id
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
	 * メールアドレスを取得するためのメソッド
	 * @return phone_email メールアドレス
	 */
	public String getPhone_email() {
		return phone_email;
	}

	/**
	 * メールアドレスを格納するためのメソッド
	 * @param phone_email メールアドレス
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
	 * 氏名を取得するためのメソッド
	 * @return user_name 氏名
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * 氏名を格納するためのメソッド
	 * @param user_name 氏名
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * ログインフラグを取得するためのメソッド
	 * @return login_flg ログインフラグ
	 */
	public boolean isLogin_flg() {
		return login_flg;
	}

	/**
	 * ログインフラグを格納するためのメソッド
	 * @param login_flg ログインフラグ
	 */
	public void setLogin_flg(boolean login_flg) {
		this.login_flg = login_flg;
	}

	/**
	 * ユーザーフラグを取得するためのメソッド
	 * @return user_flg ユーザーフラグ
	 */
	public int getUser_flg() {
		return user_flg;
	}

	/**
	 * ユーザーフラグを格納するためのメソッド
	 * @param user_flg ユーザーフラグ
	 */
	public void setUser_flg(int user_flg) {
		this.user_flg = user_flg;
	}

	/**
	 * エラーメッセージ(日本語)を取得するためのメソッド
	 * @return errmsg1 エラーメッセージ(日本語)
	 */
	public String getErrmsg1() {
		return errmsg1;
	}

	/**
	 * エラーメッセージ(日本語)を格納するメソッド
	 * @param errmsg1 エラーメッセージ(日本語)
	 */
	public void setErrmsg1(String errmsg1) {
		this.errmsg1 = errmsg1;
	}

	/**
	 * エラーメッセージ(英語)を取得するメソッド
	 * @return errmsg2 エラーメッセージ(英語)
	 */
	public String getErrmsg2() {
		return errmsg2;
	}

	/**
	 * エラーメッセージ(英語)を格納するためのメソッド
	 * @param errmsg2 エラーメッセージ(英語)
	 */
	public void setErrmsg2(String errmsg2) {
		this.errmsg2 = errmsg2;
	}

}