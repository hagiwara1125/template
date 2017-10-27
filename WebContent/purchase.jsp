<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.Calendar"%>
<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int[] yearList = new int[10];
	for (int i = 0; i < 10; i++) {
		yearList[i] = year;
		year++;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ご注文情報入力画面</title>
<!-- cssの設定・読み込み -->
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18/build/cssreset/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="css/user_main_design.css">
</head>
<body>




	<header>
		<s:include value="header.jsp" />
	</header>

	<div class="contents" style="height: 100％; padding-top: 200px;">
		<div style="text-align: right; margin-right: 20px;">
			<b>ご注文情報入力</b>_ご注文情報確認_お手続き完了
		</div>


		<!-- ここからまるっとs:form処理 -->
		<s:form name="form" action="CheckCreditAction" theme="simple">

			<br>
			<h1>ご注文情報の入力</h1>
			<br>


			<small> クレジットカード情報を以下のフォームに入力してください。 </small>
			<br>
			<small> <font color="red"><s:property
						value="error_message" /> </font>
			</small>
			<table class="visible_table" style="width: 400px">
				<tr>
					<th style="width: 160px;">クレジットカード種類</th>
					<td colspan="2"><s:select name="credit_type"
							list='{"Pisa","Americanexcite","Sistercard"}' /></td>
				</tr>
				<tr>
					<th>カード番号(16桁)</th>
					<td colspan="2"><input type="text" name="credit_number1"
						style="width: 40px;" pattern="[0-9]{4}" maxlength="4" required />-
						<input type="text" name="credit_number2" style="width: 40px;"
						pattern="[0-9]{4}" maxlength="4" required />- <input type="text"
						name="credit_number3" style="width: 40px;" pattern="[0-9]{4}"
						maxlength="4" required />- <input type="text"
						name="credit_number4" style="width: 40px;" pattern="[0-9]{4}"
						maxlength="4" required /></td>
				</tr>
				<tr>
					<th>カード名義</th>
					<td colspan="2"><input type="text" name="credit_holder"
						pattern="[a-z|A-Z| |]{1,}" required /></td>
				</tr>
				<tr>
					<th>有効期限</th>
					<td><s:select name="expiration_month"
							list="{1,2,3,4,5,6,7,8,9,10,11,12}" /> 月</td>
					<td><select class="form-control" id="se1"
						name="expiration_year">
							<%
								for (int y : yearList) {
							%>
							<option value="<%=y%>"><%=y%></option>
							<%
								}
							%>
					</select> 年</td>
				</tr>
				<tr>
					<th>セキュリティコード</th>
					<td colspan="2"><input type="password" size="15"
						name="security_code" pattern="[0-9]{3}" maxlength="3" required />
					</td>
				</tr>
			</table>
			<br>
			<hr>

			<br>
			<!-- 操作ボタンの部分 -->
			<table style="margin: 0 auto; height: 120px;">
				<tr>
					<td style="border: 0px"><button class="actbtn">確認</button></td>
				</tr>
				<tr>
					<td style="border: 0px"><button class="actbtn">お買い物に戻る</button></td>
				</tr>
			</table>
		</s:form>

		<div style="height: 80px"></div>
	</div>


	<footer style="margin-bottom: 0%;"> </footer>
</body>
</html>