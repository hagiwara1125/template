package com.internousdev.template.dto;



/**
 * ログイン情報を取得・格納するためのDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/19
 * @version 1.0
 */

public class NewLoginDTO {

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
	 * ログインフラグ
	 */
	private boolean login_flg;

	/**
	 * ユーザーフラグ
	 */
	private int user_flg;



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

}