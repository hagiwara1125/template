package com.internousdev.template.util;

import java.util.Map;

import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */

@SuppressWarnings("serial")
public class LoginConnector extends ActionSupport {

	String phone_email = null;
	String password = null;

	public LoginConnector(String phone_email, String password) {
		this.phone_email = phone_email;
		this.password = password;
	}

	public String login(Map<String, Object> session) {
		String ret = "error";
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto = dao.select(this.phone_email, this.password);
		if ((this.phone_email.equals(dto.getPhone_email())) && (this.password.equals(dto.getPassword()))) {
			if (!dto.isLogin_flg()) {
				if (dao.update(dto.getPhone_email(), dto.getPassword()) > 0) {
					dto = dao.select(dto.getPhone_email(), dto.getPassword());

					session.put("userId", Integer.valueOf(dto.getUser_id()));
					session.put("loginFlg", Boolean.valueOf(dto.isLogin_flg()));

					int userFlg = dto.getUser_flg();
					if (userFlg == 3) {
						ret = "login";
					} else {
						ret = "success";
					}
				}
			}
		}
		return ret;
	}
}