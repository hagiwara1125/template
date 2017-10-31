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
<fmt:setBundle basename="com.internousdev.template.property.login"
	var="lang" />

<title><s:text name="lang.login.title" /></title>

<link rel="stylesheet" type="text/css" href="./css/login.css">

</head>

<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="container">

		<div id="main">
				<h1 class="subtitle">
					<s:text name="lang.login.login" />
				</h1>
			<div id="login_box">
				<p>
					<s:text name="lang.login.input" />
				</p>
				<s:form action="LoginAction">
					<div class=login-form>
						<input type="text" name="phone_email" required="required"
							placeholder=<s:text name="lang.login.mailadress"/> />
					</div>
					<br>
					<br>

					<div class=login-form>
						<input type="password" name="password" required="required"
							placeholder=<s:text name="lang.login.password" /> />
					</div>
					<div style="color: red; font-size: 11px;"></div>
					<button class="button">
						<s:text name="lang.login.login" />
					</button>
					<s:token />
				</s:form>
			</div>

		</div>

		<div id="footer">
			<footer style="text-align: center;">
				<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
			</footer>
		</div>

	</div>

</body>
</html>