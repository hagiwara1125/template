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
<fmt:setBundle basename="com.internousdev.template.property.item_list"
	var="lang" />

<title><s:text name="lang.item_list.title" /></title>
<link rel="stylesheet" type="text/css" href="./css/item_list.css">

</head>

<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="container">

		<div id="main">

			<h1 class="itemlist_title">商品一覧</h1>

			<div class="display_list">
				<s:iterator value="selectList">
					<div class="template">
						<div class="item_img">
							<a
								href="<s:url action="ItemDetailAction"><s:param name="item_id" value="%{item_id}"/></s:url>"><img
								class="item_img" src="<s:property value="img_path"/>"> <s:hidden
									value="item_id" /> </a>
						</div>
						<div class="item_name">
							<s:property value="item_name" />
						</div>
						<div class="item_price">
							￥
							<fmt:formatNumber value="${item_price}" pattern="###,###,###" />
						</div>
					</div>
				</s:iterator>
			</div>


			<br>
			<br>
			<table class="pagination">
				<tr>
					<s:if test="pageNum==1">
						<td class="page"><span aria-hidden="true">&laquo;</span></td>
					</s:if>

					<s:else>
						<td class="page"><a
							href="<s:url action="ItemListAction"><s:param name="pageNum" value="1"/><s:param name="item_category" value="%{item_category}"/></s:url>"
							aria-label="1ページへ"> <span aria-hidden="true">&laquo;</span>
						</a>
						<td>
					</s:else>

					<s:iterator value="list" status="st">
						<s:if test="list.get(#st.index) == pageNum">
							<td class="page"><a><s:property
										value="list.get(#st.index)" /></a></td>
						</s:if>
						<s:else>
							<td><a
								href="<s:url action="ItemListAction"><s:param name="pageNum" value="%{list.get(#st.index)}"/><s:param name="item_category" value="%{item_category}"/></s:url>"><s:property
										value="list.get(#st.index)" /></a></td>
						</s:else>
					</s:iterator>

					<s:if test="pageNum==maxPage">
						<td class="page"><span aria-hidden="true">&raquo;</span></td>
					</s:if>
					<s:else>
						<td><a
							href="<s:url action="ListAction"><s:param name="pageNum" value="%{maxPage}"/><s:param name="item_category" value="%{item_category}"/></s:url>"
							aria-label="1ページへ"> <span aria-hidden="true">&raquo;</span>
						</a></td>
					</s:else>
				</tr>
			</table>
		</div>
		<br> <br>

		<div id="footer">
			<footer style="text-align: center;">
				<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
			</footer>
		</div>

	</div>

</body>
</html>