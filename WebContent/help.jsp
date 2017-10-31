<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 国際化 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<!-- 国際化 -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.template.property.help"
	var="lang" />

<title>Calico Cat - ヘルプ画面<%-- <s:text name="lang.help.title" /> --%></title>

<link rel="stylesheet" type="text/css" href="./css/help.css">

</head>

<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="container">

		<div id="main">
			<h2>同じ商品は一度に何個注文できますか？</h2>
			<p>
				一会計につき、同一商品は20個までとさせて頂いております。<br>
				同一商品を10個以上お求めの場合は、カートページにて変更をお願いいたします。
			</p>
			<br>

			<h2>支払方法は選べますか？</h2>
			<p>クレジットカード決済のみとなります。</p>
			<br>

			<h2>送料はかかりますか？</h2>
			<p>
				全国どこでも送料無料でお届けいたします。<br>
				なお、海外への発送は行っておりません。
			</p>
			<br>

			<h2>配送業者はどこですか？</h2>
			<p>みけねこむさしのお届け便さまとなります。</p>
			<br>

			<h2>注文してどのくらいで届きますか？</h2>
			<p>
				3営業日以内の発送となります。<br>
				発送後のお届け日数は、配送業者さまのサイトにてご確認ください。
			</p>
			<br>

		</div>

		<div id="footer">
			<footer style="text-align: center;">
				<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
			</footer>
		</div>

	</div>

</body>
</html>