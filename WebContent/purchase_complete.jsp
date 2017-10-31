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
<fmt:setBundle
	basename="com.internousdev.template.property.purchase_complete"
	var="lang" />

<title><s:text name="lang.purchase_complete.title" /></title>

<link rel="stylesheet" type="text/css"
	href="./css/purchase_complete.css">
<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	type="text/javascript"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>

</head>

<body>

	<script type="text/javascript">
		//History API が使えるブラウザかどうかをチェック
		if (window.history && window.history.pushState) {
			//. ブラウザ履歴に１つ追加
			history.pushState("nohb", null, "");
			$(window).on("popstate", function(event) {
				//. このページで「戻る」を実行
				if (!event.originalEvent.state) {
					//. もう一度履歴を操作して終了
					history.pushState("nohb", null, "");
					window.alert("ブラウザバックは無効です。");
					return;
				}
			});
		}
	</script>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="container">

		<div id="main">

			<h1><s:text name="lang.purchase_complete.subtitle" /></h1>
			<br>
			<p><s:text name="lang.purchase_complete.thanks" /></p>

			<p><s:text name="lang.purchase_complete.plan" /></p>

			<p><s:text name="lang.purchase_complete.wait" /></p>

			<p><s:text name="lang.purchase_complete.also" /></p>
		</div>

		<div id="footer">
			<footer style="text-align: center;">
				<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
			</footer>
		</div>

	</div>

</body>
</html>