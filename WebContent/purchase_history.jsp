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
	basename="com.internousdev.template.property.purchase_history"
	var="lang" />

<title>Calico Cat - 購入履歴画面<%-- <s:text name="lang.purchase_history.title" /> --%></title>

<link rel="stylesheet" type="text/css" href="./css/purchase_history.css">

</head>

<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="container">

		<div id="main">
			<h1>購入履歴</h1>

			<br>

			<table>
			<thead>
			<tr>
			<th>購入商品</th>
			<th>購入個数</th>
			<th>小計</th>
			<th>購入日</th>
			</tr>
			</thead>
			<tbody>
			<s:iterator value="purchaseList" status="st">
			<s:iterator value="itemList.get(#st.index)" />
			<tr>
			<td><s:property value="item_name" /></td>
			<td><s:property value="order_count" /> 個</td>
			<td><fmt:formatNumber value="${sub_total}" pattern="###,###,###" /> 円(税込)</td>
			<td><s:property value="purchase_date" /></td>
			</tr>
			</s:iterator>
			</tbody>

			</table>

		</div>

		<div id="footer">
			<footer style="text-align: center;">
				<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
			</footer>
		</div>

	</div>

</body>
</html>