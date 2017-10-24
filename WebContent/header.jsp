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
<fmt:setBundle basename="com.internousdev.template.property.header"
	var="lang" />

<title><s:text name="lang.header.title" /></title>

<link rel="stylesheet" type="text/css" href="./css/header.css">

</head>

<body>

<!-- ログイン時 -->

	<s:if test="#session.user_flg==1">
		<div id="menulist">
			<ul id="dropmenu">
				<li><a href="#"><s:text name="lang.header.calicocat" /></a>
					<ul>
						<li><a href="#"><s:text name="lang.header.help" /></a></li>
						<li><a href="#"><s:text name="lang.header.inquiry" /></a></li>
					</ul></li>
				<li><a
					href="<s:url action="ItemListAction"><s:param name="item_category" value="0" /></s:url>"><s:text name="lang.header.product_list" /></a>
					<ul>
						<li><a
							href="<s:url action="ItemListAction"><s:param name="item_user" value="1" /></s:url>"><s:text name="lang.header.lover" /></a>
							<ul>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="1" /></s:url>"><s:text name="lang.header.kitchen" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="2" /></s:url>"><s:text name="lang.header.interior" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="3" /></s:url>"><s:text name="lang.header.stationery" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="4" /></s:url>"><s:text name="lang.header.fashion" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="5" /></s:url>"><s:text name="lang.header.accessories" /></a></li>
							</ul></li>
						<li><a
							href="<s:url action="ItemListAction"><s:param name="item_user" value="2" /></s:url>"><s:text name="lang.header.cats" /></a>
							<ul>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="6" /></s:url>"><s:text name="lang.header.food" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="7" /></s:url>"><s:text name="lang.header.snack" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="8" /></s:url>"><s:text name="lang.header.toy" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="9" /></s:url>"><s:text name="lang.header.daily" /></a>
							</ul></li>
					</ul></li>
				<li><a href="#"><s:text name="lang.header.service" /></a>
					<ul>
						<li><a href="GoMyPageAction"><s:text name="lang.header.mypage" /></a></li>
						<li><a href="CartSelectAction"><s:text name="lang.header.cart" /></a></li>
					</ul></li>
				<li><a href="<s:url action="LogoutAction"></s:url>"><s:text name="lang.header.logout" /></a></li>
			</ul>
		</div>
	</s:if>

<!-- 管理者ログイン -->

	<s:elseif test="#session.user_flg==3">
	</s:elseif>

<!-- 未ログイン時 -->

	<s:else>
		<ul id="dropmenu">
				<li><a href="#"><s:text name="lang.header.calicocat" /></a>
					<ul>
						<li><a href="#"><s:text name="lang.header.help" /></a></li>
						<li><a href="#"><s:text name="lang.header.inquiry" /></a></li>
					</ul></li>
				<li><a
					href="<s:url action="ItemListAction"><s:param name="item_category" value="0" /></s:url>"><s:text name="lang.header.product_list" /></a>
					<ul>
						<li><a
							href="<s:url action="ItemListAction"><s:param name="item_user" value="1" /></s:url>"><s:text name="lang.header.lover" /></a>
							<ul>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="1" /></s:url>"><s:text name="lang.header.kitchen" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="2" /></s:url>"><s:text name="lang.header.interior" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="3" /></s:url>"><s:text name="lang.header.stationery" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="4" /></s:url>"><s:text name="lang.header.fashion" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="5" /></s:url>"><s:text name="lang.header.accessories" /></a></li>
							</ul></li>
						<li><a
							href="<s:url action="ItemListAction"><s:param name="item_user" value="2" /></s:url>"><s:text name="lang.header.cats" /></a>
							<ul>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="6" /></s:url>"><s:text name="lang.header.food" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="7" /></s:url>"><s:text name="lang.header.snack" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="8" /></s:url>"><s:text name="lang.header.toy" /></a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="9" /></s:url>"><s:text name="lang.header.daily" /></a>
							</ul></li>
					</ul></li>
				<li><a href="#"><s:text name="lang.header.service" /></a>
					<ul>
						<li><a href="GoMyPageAction"><s:text name="lang.header.mypage" /></a></li>
						<li><a href="CartSelectAction"><s:text name="lang.header.cart" /></a></li>
					</ul></li>
			<li><a href="login.jsp"><s:text name="lang.header.login" /></a></li>
		</ul>
	</s:else>

</body>
</html>