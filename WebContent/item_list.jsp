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

	<div class="item-list-wrapper">
		<s:iterator begin="0" end="pageCount" step="1" status="st">
			<div class="selection" id="page-<s:property value="#st.index" />">
				<s:iterator value="itemList">
					<s:if test="#st.index == category_page">
						<div class="item-box">
							<a
								href="<s:url action="ItemDetailAction" ><s:param name="item_id" value="item_id"/></s:url>">
								<img src="images/<s:property value="img_path" />" alt="">
								<br> <s:property value="item_name" /> <br> ￥ <fmt:formatNumber
									groupingUsed="true" value="${price}" />

							</a>
						</div>
					</s:if>
				</s:iterator>
			</div>
		</s:iterator>
		<div class="pagination-holder clearfix" style="margin-left: 15%;">
			<div id="light-pagination" class="pagination"></div>
		</div>
	</div>

</body>
</html>