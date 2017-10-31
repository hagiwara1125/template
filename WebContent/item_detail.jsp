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
<fmt:setBundle basename="com.internousdev.template.property.item_detail"
	var="lang" />

<title><s:text name="lang.item_detail.title" /></title>

<link rel="stylesheet" type="text/css" href="./css/item_detail.css">

</head>

<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="container">

		<div id="main">

		<h1 class="itemdetail_title">商品詳細</h1>

		<s:form action="CartInsertAction">
				<s:iterator value="displayList">

					<p class="item_name">
						<s:property value="item_name" />
					</p>


					<img src="<s:property value= "img_path"/>" class="img">


					<table>
						<tr>
							<th class="priceth"><s:text name="lang.item_detail.comment" /></th>
							<td class="pricetd"><s:property escape="false" value="item_comment" /></td>
						</tr>
						<tr>
							<th class="priceth2"><s:text name="lang.item_detail.price" /></th>
							<td><div class="pricetd2">
									￥
									<fmt:formatNumber value="${item_price}" pattern="###,###,###" />
									<span class="tax"> (<s:text name="lang.item_detail.etax" />)
									</span>
								</div></td>
						</tr>
					</table>

					<div class="shoppingcart">

						<input type="hidden" name="item_id"
							value="<s:property value="item_id"/>" />


						<!-- 参加人数 必要か不必要か -->
						<s:text name="lang.item_detail.quantity" />
						<select name="order_count">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select> <input type="submit" class="btn btn-warning"
							value="<s:text name= "lang.item_detail.cart"/>" />

					</div>
					<s:token/>

				</s:iterator>

			</s:form>

		</div>

		<div id="footer">
			<footer style="text-align: center;">
				<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
			</footer>
		</div>

	</div>

</body>
</html>



<%-- 	<!-- ヘッダーここから -->

	<header>
		<s:include value="header.jsp" />
	</header>

	<!-- ヘッダーここまで -->


	<div class="center">

		<div class="contents">

			<div class="subtitle">
				<s:text name="lang.item_detail.subtitle" />
			</div>

			<s:form action="CartInsertAction">
				<s:iterator value="displayList">

					<p class="item_name">
						<s:property value="item_name" />
					</p>


					<img src="<s:property value= "img_path"/>" class="img">


					<table style="border: solid 1px white">
						<tr>
							<th><s:text name="lang.item_detail.comment" /></th>
							<td><s:property escape="false" value="item_comment" /></td>
						</tr>
						<tr>
							<th class="priceth"><s:text name="lang.item_detail.price" /></th>
							<td><div class="pricetd">
									￥
									<fmt:formatNumber value="${item_price}" pattern="###,###,###" />
									<span class="tax"> (<s:text name="lang.item_detail.etax" />)
									</span>
								</div></td>
						</tr>
					</table>

					<div class="shoppingcart">

						<input type="hidden" name="item_id"
							value="<s:property value="item_id"/>" />


						<!-- 参加人数 必要か不必要か -->
						<s:text name="lang.item_detail.quantity" />
						<select name="order_count">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select> <input type="submit" class="btn btn-warning"
							value="<s:text name= "lang.item_detail.cart"/>" />

					</div>
					<s:token/>

				</s:iterator>

			</s:form>

		</div>
	</div>

</body>
</html> --%>