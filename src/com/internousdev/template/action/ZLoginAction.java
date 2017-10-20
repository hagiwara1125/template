package com.internousdev.template.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ZBuyItemDAO;
import com.internousdev.template.dao.ZLoginDAO;
import com.internousdev.template.dto.ZBuyItemDTO;
import com.internousdev.template.dto.ZLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログイン認証処理
 * Login.jspからログインID、ログインパスワードを受け取り
 * DBへ問い合わせを行います。
 *
 * @author internous
 * @param loginUserId
 * @param loginPassword
 *
 * @return result
 */
public class ZLoginAction extends ActionSupport implements SessionAware{

	/**
	 * ログインID
	 */
	public String loginUserId;

	/**
	 * ログインパスワード
	 */
	public String loginPassword;

	/**
	 * 処理結果を格納
	 */
	public String result;

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> loginUserInfoMap = new HashMap<>();

	/**
	 * ログイン情報取得DAO
	 */
	public ZLoginDAO loginDAO = new ZLoginDAO();

	/**
	 * ログイン情報格納IDTO
	 */
	private ZLoginDTO loginDTO = new ZLoginDTO();

	/**
	 * アイテム情報を取得
	 */
	public ZBuyItemDAO buyItemDAO = new ZBuyItemDAO();

	/**
	 * 実行メソッド
	 */
	public String execute() {

		result = ERROR;

		// ログイン実行
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		loginUserInfoMap.put("loginUser", loginDTO);

		// ログイン情報を比較
		if(((ZLoginDTO) loginUserInfoMap.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;

			// アイテム情報を取得
			ZBuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			loginUserInfoMap.put("login_user_id",	loginDTO.getLoginId());
			loginUserInfoMap.put("id", buyItemDTO.getId());
			loginUserInfoMap.put("buyItem_name", buyItemDTO.getItemName());
			loginUserInfoMap.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> loginUserInfoMap) {
		this.loginUserInfoMap = loginUserInfoMap;
	}
}
