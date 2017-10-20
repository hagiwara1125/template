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
<fmt:setBundle basename="com.internousdev.template.property.item_list"
	var="lang" />

<title><s:text name="lang.item_list.title" /></title>

</head>

<body>

<header>
	<s:include value="dropmenu.jsp" />
</header>

<s:iterator value="selectList">
	<a
		href="<s:url action="ItemDetailAction"><s:param name="item_id" value="%{item_id}" /></s:url>"><img
		class="img" src="<s:property value="img_path" />" height="250px">
		<s:hidden value="item_id" /></a>
	<s:property value="item_name" />
	<fmt:formatNumber value="${item_price}" pattern="###,###,###" />
</s:iterator>



</body>
</html>