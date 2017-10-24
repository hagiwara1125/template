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
<meta http-equiv="X-UA=Compativble" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta charset="utf-8">

<!-- 国際化 -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.template.property.login"
	var="lang" />

<title><s:text name="lang.login.title" /></title>

<style>
#categorylist


<
s


:property



value


="
category
"/
>
{
background-color


:


#ffdb99


;
}
</style>
<style>
.navbar {
	background-color: #ffb959;
}

.navbar .navbar-brand {
	color: #ecf0f1;
}

.navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
	color: #ddd;
}

.navbar .navbar-text {
	color: #ecf0f1;
}

.navbar .navbar-nav .nav-link {
	color: #ecf0f1;
	border-radius: .25rem;
	margin: 0 0.25em;
}

.navbar .navbar-nav .nav-link:not (.disabled ):hover, .navbar .navbar-nav .nav-link:not
	 (.disabled ):focus {
	color: #ecdbff;
}

.navbar .navbar-nav .nav-item.active .nav-link, .navbar .navbar-nav .nav-item.active .nav-link:hover,
	.navbar .navbar-nav .nav-item.active .nav-link:focus, .navbar .navbar-nav .nav-item.show .nav-link,
	.navbar .navbar-nav .nav-item.show .nav-link:hover, .navbar .navbar-nav .nav-item.show .nav-link:focus
	{
	color: #ecdbff;
	background-color: #ddd;
}

.navbar .navbar-toggle {
	border-color: #ddd;
}

.navbar .navbar-toggle:hover, .navbar .navbar-toggle:focus {
	background-color: #ddd;
}

.navbar .navbar-toggle .navbar-toggler-icon {
	color: #ecf0f1;
}

.navbar .navbar-collapse, .navbar .navbar-form {
	border-color: #ecf0f1;
}

.navbar .navbar-link {
	color: #ecf0f1;
}

.navbar .navbar-link:hover {
	color: #ecdbff;
}

@media ( max-width : 575px) {
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #8e44ad;
	}
}

@media ( max-width : 767px) {
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #8e44ad;
	}
}

@media ( max-width : 991px) {
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #8e44ad;
	}
}

@media ( max-width : 1199px) {
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #8e44ad;
	}
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item {
	color: #ecf0f1;
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item:hover,
	.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item:focus {
	color: #ecdbff;
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item.active {
	color: #ecdbff;
	background-color: #8e44ad;
}
</style>
</head>
<body>
	<div id="pagecover">


		<!-- <div class="container"> -->
		<!-- 	<div class="row"> -->
		<div id="loginbox">
			<h1>
				<s:text name="lang.login.login" />
			</h1>
			<div id="rightbox">
				<p>
					<s:text name="lang.login.loginwithyouremailaddress" />
				</p>
				<s:form action="LoginAction">
					<input type="text" name="phone_email" required="required"
						placeholder=<s:text name="lang.login.mailadress"/> />
					<br>
					<br>
					<input type="password" name="password" required="required"
						placeholder=<s:text name="lang.login.password" /> />
					<div style="color: red; font-size: 11px;"></div>
					<button class="button">
						<s:text name="lang.login.login" />
					</button>
					<s:token />
				</s:form>
			</div>


		</div>
	</div>
	<!-- </div> -->
	<!-- </div> -->

</body>
</html>