package com.internousdev.template.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * DBConnectorクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/20
 * @version 1.0
 */

public class DBConnector {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/";
	private String dataBase;
	private String user = "root";
	private String password = "mysql";

	public DBConnector(String dataBase) {
		this.dataBase = dataBase;
	}

	public DBConnector(String dataBase, String user, String password) {
		this.dataBase = dataBase;
		this.user = user;
		this.password = password;
	}

	public DBConnector(String url, String dataBase, String user, String password) {
		this.url = url;
		checkUrl();
		this.dataBase = dataBase;
		this.user = user;
		this.password = password;
	}

	public DBConnector(String driver, String url, String dataBase, String user, String password) {
		this.driver = driver;
		this.url = url;
		checkUrl();
		this.dataBase = dataBase;
		this.user = user;
		this.password = password;
	}

	private void checkUrl() {
		String URL = "jdbc:mysql://localhost/";
		String[] tmp = new String[this.url.length()];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = this.url.substring(i, i + 1);
		}
		if ((!tmp[4].equals(":")) || (!tmp[10].equals(":")) || (!tmp[11].equals("/")) || (!tmp[12].equals("/"))
				|| (!tmp[(tmp.length - 1)].equals("/"))) {
			this.url = URL;
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.url + this.dataBase, this.user, this.password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}