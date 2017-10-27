<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ご注文内容確認画面</title>
<!-- cssの設定・読み込み -->
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18/build/cssreset/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="css/user_main_design.css">
</head>
<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div class="contents" style="height: 100％; padding-top: 5px;">
		<div style="text-align: right; margin-right: 20px;">
			ご注文情報入力_<b>ご注文内容確認</b>_お手続き完了
		</div>
		<h1>ご注文内容の確認</h1>
		以下の内容でご注文を確定いたします。<br> よろしければページ下の「確定」ボタンをクリックしてください
		<h3>--------【1/3】ご注文商品---------</h3>

		<br>

		<s:iterator value="cartList">
			<tr>
				<td class="col-md-5"><s:property value="item_name" /></td>
				<td class="col-md-2">&yen;<fmt:formatNumber
						value="${item_price}" pattern="###,###,###" /></td>
				<td class="col-md-2"><s:property value="order_count" /></td>
			</tr>
		</s:iterator>
		<h2>情報</h2>
		<table class="table">
			<tr>
				<th class="col-md-9">合計金額</th>
				<td class="col-md-3">&yen;<fmt:formatNumber
						value="${total_price}" pattern="###,###,###" /></td>
			</tr>

		</table>

		<br> <br>

		<h3>---------【3/3】お支払い情報----------</h3>


		クレジットカード情報
		<table class="visible_table" style="width: 540px">
			<tr>
				<th>クレジットカード種類</th>
				<td colspan="2"><s:property value="credit_type" /></td>
			</tr>
			<tr>
				<th>カード番号</th>
				<td colspan="2">XXXX - XXXX - XXXX - <s:property
						value="credit_number4" /></td>
			</tr>
			<tr>
				<th>カード名義</th>
				<td colspan="2"><s:property value="credit_holder" /></td>
			</tr>
			<tr>
				<th>有効期限</th>
				<td><s:property value="expiration_month" /> 月</td>
				<td><s:property value="expiration_year" /> 年</td>
			</tr>
			<tr>
				<th>セキュリティコード</th>
				<td colspan="2">XXX</td>
			</tr>
		</table>
		<br> <br>
		<hr style="border: 1px dashed">

		<br>
		<!-- 操作ボタンの部分 -->
		<table style="margin: 0 auto; height: 120px;">
			<tr>
				<td style="border: 0px"><s:form action="PurchaseCompleteAction">
						<button class="actbtn">確定</button>
					</s:form></td>

			</tr>
			<tr>
				<td style="border: 0px"><button class="actbtn">入力画面に戻る</button></td>
			</tr>
		</table>
		<br>
		<div style="height: 80px"></div>
	</div>


	<footer style="margin-bottom: 0%;"> </footer>
</body>
</html>