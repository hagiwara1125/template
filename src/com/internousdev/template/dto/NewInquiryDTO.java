package com.internousdev.template.dto;



/**
 * 問い合わせ情報を取得・格納するためのDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/19
 * @version 1.0
 */

public class NewInquiryDTO {

	/**
	 * 問い合わせID
	 */
	private int inquiry_id;

	/**
	 * 問い合わせ者氏名
	 */
	private String inquiry_name;

	/**
	 * メールアドレス
	 */
	private String inquiry_email;

	/**
	 * 件名
	 */
	private String inquiry_title;

	/**
	 * 内容
	 */
	private String inquiry_comment;

	/**
	 * 問い合わせ日
	 */
	private String inquiry_date;



	/**
	 * 問い合わせIDを取得するためのメソッド
	 * @return inquiry_id 問い合わせID
	 */
	public int getInquiry_id() {
		return inquiry_id;
	}

	/**
	 * 問い合わせIDを格納するためのメソッド
	 * @param inquiry_id 問い合わせID
	 */
	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}

	/**
	 * 問い合わせ者氏名を取得するためのメソッド
	 * @return inquiry_name 問い合わせ者氏名
	 */
	public String getInquiry_name() {
		return inquiry_name;
	}

	/**
	 * 問い合わせ者氏名を格納するためのメソッド
	 * @param inquiry_name 問い合わせ者氏名
	 */
	public void setInquiry_name(String inquiry_name) {
		this.inquiry_name = inquiry_name;
	}

	/**
	 * メールアドレスを取得するためのメソッド
	 * @return inquiry_email メールアドレス
	 */
	public String getInquiry_email() {
		return inquiry_email;
	}

	/**
	 * メールアドレスを格納するためのメソッド
	 * @param inquiry_email メールアドレス
	 */
	public void setInquiry_email(String inquiry_email) {
		this.inquiry_email = inquiry_email;
	}

	/**
	 * 件名を取得するためのメソッド
	 * @return inquiry_title 件名
	 */
	public String getInquiry_title() {
		return inquiry_title;
	}

	/**
	 * 件名を格納するためのメソッド
	 * @param inquiry_title 件名
	 */
	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}

	/**
	 * 内容を取得するためのメソッド
	 * @return inquiry_comment 内容
	 */
	public String getInquiry_comment() {
		return inquiry_comment;
	}

	/**
	 * 内容を格納するためのメソッド
	 * @param inquiry_comment 内容
	 */
	public void setInquiry_comment(String inquiry_comment) {
		this.inquiry_comment = inquiry_comment;
	}

	/**
	 * 問い合わせ日を取得するためのメソッド
	 * @return inquiry_date 問い合わせ日
	 */
	public String getInquiry_date() {
		return inquiry_date;
	}

	/**
	 * 問い合わせ日を格納するためのメソッド
	 * @param inquiry_date 問い合わせ日
	 */
	public void setInquiry_date(String inquiry_date) {
		this.inquiry_date = inquiry_date;
	}

}