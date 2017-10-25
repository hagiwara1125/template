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
<link rel="stylesheet" type="test/css" href="./css/item_list.css">

</head>

<body>

	<div id="pagecover">

		<header>
			<s:include value="header.jsp" />
		</header>

		<div class="container" style="margin-top: 50px;">

			<div id="contents">

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
								<fmt:formatNumber value="${item_price}" pattern="###,###,###" />
							</div>
						</div>
					</s:iterator>
				</div>

				<div class="col-xs-12 col-sm-12 col-md-12">
					<nav>
						<ul class="pagination">

							<s:if test="pageNum==1">
								<li class="disabled"><span aria-hidden="true">&laquo;</span>
								</li>
							</s:if>

							<s:else>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="pageNum" value="1"/><s:param name="item_category" value="%{item_category}"/></s:url>"
									aria-label="1ページへ"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</s:else>

							<s:iterator value="list" status="st">
								<s:if test="list.get(#st.index) == pageNum">
									<li class="active"><a><s:property
												value="list.get(#st.index)" /></a></li>
								</s:if>
								<s:else>
									<li><a
										href="<s:url action="ItemListAction"><s:param name="pageNum" value="%{list.get(#st.index)}"/><s:param name="item_category" value="%{item_category}"/></s:url>"><s:property
												value="list.get(#st.index)" /></a></li>
								</s:else>
							</s:iterator>

							<s:if test="pageNum==maxPage">
								<li class="disabled"><span aria-hidden="true">&raquo;</span>
								</li>
							</s:if>
							<s:else>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="pageNum" value="%{maxPage}"/><s:param name="item_category" value="%{item_category}"/></s:url>"
									aria-label="1ページへ"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</s:else>
						</ul>
					</nav>
				</div>


			</div>

		</div>
	</div>

	<footer>
		<s:include value="footerload.jsp" />
	</footer>

</body>
</html>