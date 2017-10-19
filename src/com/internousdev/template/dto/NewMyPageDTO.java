package com.internousdev.template.dto;



/**
 * マイページ情報を取得・格納するためのDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/19
 * @version 1.0
 */

public class NewMyPageDTO {

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * メールアドレス
	 *
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
	 * 削除フラグ
	 */
	private boolean delete_flg;

	/**
	 * 姓
	 */
	private String family_name;

	/**
	 * 姓(カナ)
	 */
	private String family_name_kana;

	/**
	 * 名
	 */
	private String given_name;

	/**
	 * 名(カナ)
	 */
	private String given_name_kana;

	/**
	 * 氏名
	 */
	private String user_name;

	/**
	 * 性別
	 */
	private String sex;

	/**
	 * 郵便番号
	 */
	private String postal;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * 電話番号
	 */
	private String phone_number;

	/**
	 * OAuthID
	 */
	private String oauth_id;

	/**
	 * OAuth名
	 */
	private int oauth_name;

	/**
	 * OAuthアカウント
	 */
	private String oauth_account;

	/**
	 * 登録日
	 */
	private String register_date;

	/**
	 * 更新日
	 */
	private String update_date;



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

	/**
	 * 削除フラグを取得するためのメソッド
	 * @return delete_flg 削除フラグ
	 */
	public boolean isDelete_flg() {
		return delete_flg;
	}

	/**
	 * 削除フラグを格納するためのメソッド
	 * @param delete_flg 削除フラグ
	 */
	public void setDelete_flg(boolean delete_flg) {
		this.delete_flg = delete_flg;
	}

	/**
	 * 姓を取得するためのメソッド
	 * @return family_name 姓
	 */
	public String getFamily_name() {
		return family_name;
	}

	/**
	 * 姓を格納するためのメソッド
	 * @param family_name 姓
	 */
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	/**
	 * 姓(カナ)を取得するためのメソッド
	 * @return family_name_kana 姓(カナ)
	 */
	public String getFamily_name_kana() {
		return family_name_kana;
	}

	/**
	 * 姓(カナ)を格納するためのメソッド
	 * @param family_name_kana 姓(カナ)
	 */
	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;
	}

	/**
	 * @return given_name
	 */
	public String getGiven_name() {
		return given_name;
	}

	/**
	 * @param given_name セットする given_name
	 */
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	/**
	 * @return given_name_kana
	 */
	public String getGiven_name_kana() {
		return given_name_kana;
	}

	/**
	 * @param given_name_kana セットする given_name_kana
	 */
	public void setGiven_name_kana(String given_name_kana) {
		this.given_name_kana = given_name_kana;
	}

	/**
	 * @return user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name セットする user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex セットする sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return postal
	 */
	public String getPostal() {
		return postal;
	}

	/**
	 * @param postal セットする postal
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number セットする phone_number
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @return oauth_id
	 */
	public String getOauth_id() {
		return oauth_id;
	}

	/**
	 * @param oauth_id セットする oauth_id
	 */
	public void setOauth_id(String oauth_id) {
		this.oauth_id = oauth_id;
	}

	/**
	 * @return oauth_name
	 */
	public int getOauth_name() {
		return oauth_name;
	}

	/**
	 * @param oauth_name セットする oauth_name
	 */
	public void setOauth_name(int oauth_name) {
		this.oauth_name = oauth_name;
	}

	/**
	 * @return oauth_account
	 */
	public String getOauth_account() {
		return oauth_account;
	}

	/**
	 * @param oauth_account セットする oauth_account
	 */
	public void setOauth_account(String oauth_account) {
		this.oauth_account = oauth_account;
	}

	/**
	 * @return register_date
	 */
	public String getRegister_date() {
		return register_date;
	}

	/**
	 * @param register_date セットする register_date
	 */
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	/**
	 * @return update_date
	 */
	public String getUpdate_date() {
		return update_date;
	}

	/**
	 * @param update_date セットする update_date
	 */
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

}