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
<fmt:setBundle basename="com.internousdev.template.property.cart"
	var="lang" />

<title><s:text name="lang.cart.title" /></title>

<link rel="stylesheet" type="text/css" href="./css/cart.css">

</head>

<body>

	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="container">

		<div id="main">

			<h1 class="kago">
				<s:text name="lang.cart.cart" />
			</h1>

			<s:if test="%{cartList.size() > 0 && #session.user_id != null}">
				<table class="cartlist">

					<thead>
						<tr>
							<th class="img2"><s:text name="lang.cart.img" /></th>
							<th><s:text name="lang.cart.item_name" /></th>
							<th class="okisa"><s:text name="lang.cart.price" /></th>
							<th class="okisa"><s:text name="lang.cart.order_count" /></th>
							<th class="okisa"><s:text name="lang.cart.sub_total" /></th>
							<th class="okisa"><s:text name="lang.cart.delete" /></th>
						</tr>
					</thead>

					<tbody>

						<s:iterator value="cartList" status="st">
							<tr>
								<td class="img2"><img src="<s:property value="img_path" />"
									alt="" width="100" height="100"></td>
								<td><s:property value="item_name" /></td>

								<td><fmt:formatNumber value="${item_price}"
										pattern="###,###,###" /> <s:text name="lang.cart.yen" /></td>

								<td><s:form action="CartUpdateAction">
										<s:select
											list="{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}"
											name="order_count" value="%{order_count}" theme="simple"
											onChange="this.form.submit()" />
										<s:hidden name="cart_id" value="%{cart_id}" />
									</s:form></td>

								<td><fmt:formatNumber value="${sub_total}"
										pattern="###,###,###" /> <s:text name="lang.cart.yen" /></td>

								<td><s:form action="CartDeleteAction">
										<s:hidden name="user_id" value="%{user_id}" />
										<s:hidden name="cart_id" value="%{cart_id}" />
										<button type="submit" class="btn btn-default">
											<s:text name="lang.cart.delete" />
										</button>
										<s:token />
									</s:form></td>
							</tr>

						</s:iterator>

					</tbody>

				</table>

				<h2 class="total">
					<s:text name="lang.cart.total_price" />
					<fmt:formatNumber value="${total_price}" pattern="###,###,###" />
					<s:text name="lang.cart.yen" />
					(<s:text name="lang.cart.tax_include" />)
				</h2>

				<table class="kaimonobox">
					<tr>

						<!-- ツアーリストへ戻る -->
						<td class="kaimonotd"><s:form action="ItemListAction">
								<s:param name="item_category" value="0" />
								<button type="submit" class="btn btn-default center-block">
									<s:text name="lang.cart.item_list" />
								</button>
							</s:form></td>

						<!-- 購入ボタンフォーム -->
						<td class="kaimonotd"><s:form action="GoPurchaseAction">
								<button type="submit" class="btn btn-warning center-block">
									<s:text name="lang.cart.payment" />
								</button>
							</s:form></td>

					</tr>
				</table>
			</s:if>

			<s:else>
				<h1 class='empty'>
					<s:text name="lang.cart.empty" />
				</h1>
			</s:else>

		</div>

		<div id="footer">
			<footer style="text-align: center;">
				<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
			</footer>
		</div>

	</div>

</body>
</html>