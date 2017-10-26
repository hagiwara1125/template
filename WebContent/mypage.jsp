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
<fmt:setBundle basename="com.internousdev.template.property.mypage"
	var="lang" />

<title><s:text name="lang.mypage.title" /></title>

<link rel="stylesheet" type="text/css" href="css/mypage.css">

</head>
<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<s:iterator value="userList">
		<table class="userinfo">
			<tbody>
				<tr>
					<td class="tdtitle"><s:text name="lang.mypage.userid" /></td>
					<td class="tdsub"><s:property value="user_id" /></td>
				</tr>
				<tr>
					<td class="tdtitle"><s:text name="lang.mypage.name" /></td>
					<td class="tdsub"><s:property value="user_name" /></td>
				</tr>
				<tr>
					<td class="tdtitle"><s:text name="lang.mypage.phone" /></td>
					<td class="tdsub"><s:property value="phone_number" /></td>
				</tr>
				<tr>
					<td class="tdtitle"><s:text name="lang.mypage.mail" /></td>
					<td class="tdsub"><s:property value="phone_email" /></td>
				</tr>
				<tr>
					<td class="tdtitle"><s:text name="lang.mypage.address" /></td>
					<td class="tdsub">〒<s:property value="postal" /><br> <s:property
							value="address" /></td>
				</tr>
			</tbody>
		</table>
	</s:iterator>

		<footer style="text-align: center; font-size: 14px; bottom: 0;">
			<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
		</footer>

</body>
</html>