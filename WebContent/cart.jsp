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
<fmt:setBundle basename="com.internousdev.template.property.cart"
	var="lang" />

<title><s:text name="lang.cart.title" /></title>

<link rel="stylesheet" type="text/css" href="css/cart.css">

</head>



<body>

	<!-------------- ヘッダー -------------->
	<header>
		<s:include value="header.jsp" />
	</header>

	<div id="contents" style="margin-bottom: 50px; color: #000000;">

		<div class="col-sm-12 center">


			<h1 class="kago">
				<s:text name="lang.cart.cart" />
			</h1>
		</div>

		<s:if test="%{cartList.size() > 0 && #session.user_id != null}">

			<table class="cartlist">

				<thead>
					<tr>
						<th class="img"><s:text name="lang.cart.img" /></th>
						<th><s:text name="lang.cart.item_name" /></th>
						<th class="okisa"><s:text name="lang.cart.price" /></th>
						<th class="okisa"><s:text name="lang.cart.sub_total" /></th>
						<th class="okisa"><s:text name="lang.cart.order_count" /></th>
						<th class="okisa"><s:text name="lang.cart.delete" /></th>
					</tr>
				</thead>

				<tbody>

					<s:iterator value="cartList" status="st">
						<tr>
							<td class="img2"><img src="<s:property value="img_path" />"
								alt="" width="130" height="100"></td>
							<td><s:property value="item_name" /></td>

							<td><fmt:formatNumber value="${item_price}"
									pattern="###,###,###" /> <s:text name="lang.cart.yen" /></td>

							<td><fmt:formatNumber value="${sub_total}"
									pattern="###,###,###" /> <s:text name="lang.cart.yen" /></td>

							<td><s:form action="CartUpdateAction">
									<s:select
										list="{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}"
										name="order_count" value="%{order_count}" theme="simple"
										onChange="this.form.submit()" />
									<s:hidden name="cart_id" value="%{cart_id}" />
								</s:form></td>

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
				<s:text name="lang.cart.tax_include" />
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

	<div class="saigo">
		<footer style="text-align: center;">
			<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
		</footer>
	</div>

</body>
</html>