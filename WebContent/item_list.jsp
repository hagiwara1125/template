<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 国際化 ここから -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.template.property.item_list"
	var="lang" />
<!-- 国際化 ここまで -->

<meta charset="utf-8">
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

<title><s:text name="lang.item_list.item_list" /></title>

</head>


<body>

	<ul class="outline">
		<li>
			<div class="category">
				<s:text name="lang.test_item.SearchT" />
			</div>
			<ul class="menu">
				<li><a
					href="<s:url action="ItemListAction"><s:param name="category" value="1" /></s:url>"><s:text
							name="lang.test_item.gourmet" /></a></li>
				<li><a
					href='<s:url action="ItemListAction"><s:param name="category" value="2"/></s:url>'><s:text
							name="lang.test_item.spot" /></a></li>
				<li><a
					href='<s:url action="ItemListAction"><s:param name="category" value="3"/></s:url>'><s:text
							name="lang.test_item.activity" /></a></li>
			</ul>
		</li>

	</ul>
	<script type="text/javascript" src="./js/sidebar.js"></script>

	<div id="contents">


		<div class="subtitle">
			<s:text name="lang.item_list.cart" />
		</div>

		<div class="display_list">
			<s:iterator value="selectList">
				<div class="template">
					<div class="hvr-float-shadow">
						<div class="item_img">
							<a
								href="<s:url action="ItemDetailAction"><s:param name="item_id" value="%{item_id}"/></s:url>"><img
								class="item_img" src="<s:property value="img_path"/>"
								height="250px"> <s:hidden value="item_id" /> </a>
						</div>
					</div>
					<div class="item_name">
						<s:property value="item_name" />
					</div>
					<div class="item_price">
						￥
						<fmt:formatNumber value="${price}" pattern="###,###,###" />
					</div>
				</div>
			</s:iterator>
		</div>

		<footer style="padding-top: 110%; text-align: center;">
			<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
		</footer>

	</div>



</body>
</html>