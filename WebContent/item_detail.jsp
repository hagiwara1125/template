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
<fmt:setBundle basename="com.internousdev.template.property.item_detal"
	var="lang" />

<title><s:text name="lang.item_detail.title" /></title>

<link rel="stylesheet" type="text/css" href="./css/item_detail.css">

</head>

<body>

	<!-- ヘッダーここから -->

	<header>
		<s:include value="header.jsp" />
	</header>

	<!-- ヘッダーここまで -->


	<div class="center">

		<div class="sidebar">
			<s:include value="item.jsp" />
		</div>


		<div class="contents">

			<div class="subtitle">
				<s:text name="lang.item_detail.subtitle" />
			</div>


			<s:iterator value="displayList">
				<form action="CartInsertAction"
					name="cartInsertForm<s:property value="#st.count"/>">

					<div class="modal-body">
						<!-- 商品詳細 -->
						<div style="width: 100%; margin-bottom: 10px;" align="center">
						</div>
						<div class="alt-table-responsive">
							<table style="margin: 0 auto;">
								<tbody>
									<tr class="row">
										<td class="col-xs-8 col-sm-8 col-md-8" width="250" rowspan="2"
											align="center" valign="top"><img style="width: 100%;"
											src="<s:property value="img_path"/>" class="img-responsive"></td>
										<td class="col-xs-4 col-sm-4 col-md-4" align="left"
											valign="top">
											<div>
												<span class="product-detail-price1"
													style="boder-bottom: solid;"><s:text
														name="lang.itemlist.price" /></span> <br> <span
													class="product-detail-price2">￥<script>
																					decimal_floor(<s:property value="price"/>);
																				</script></span> <span class="product-detail-price3">（<s:text
														name="lang.itemlist.etax" />）
												</span> <br> <br> <span class="product-detail-comment">
													<s:property value="item_comment" />
												</span>
												<div>
													<s:if test="user_stock<=10 && user_stock>0">
														<font color="red"><s:text
																name="lang.itemlist.small" />:<s:property
																value="user_stock" /></font>
													</s:if>
												</div>
											</div>
										</td>
									</tr>
									<tr class="row">
										<td class=col-xs- align="left" valign="top">
											<div class=col-xs-12>
												<s:if test="user_stock > 0">
													<p class="product-detail-amount-p">
														<s:text name="lang.itemlist.quantity" />
														<select name="order_count"
															id="orderCount<s:property value="#st.count"/>"
															class="form-control">
														</select>
													</p>
													<font color="red"><div
															id="stock_error<s:property value="#st.count"/>"></div></font>
												</s:if>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<s:text name="lang.itemlist.close" />
						</button>
						<s:if test="user_stock > 0">
							<s:hidden name="item_id" value="%{item_id}" />
							<span id="cartsw<s:property value="#st.count"/>"><input
								type="submit" class="btn btn-default" id="cartbtn"
								value="<s:text name="lang.itemlist.cart"/>"></span>
						</s:if>
						<s:else>
							<div class="btn btn-default active" id="emptybtn">
								<s:text name="lang.itemlist.outofstock" />
							</div>
						</s:else>
					</div>
					<s:token />
				</form>

				<script>
									var sel = document.forms.cartInsertForm<s:property value="#st.count"/>.order_count;
									sel.options.length = 0;
									for (var i = 1; i <= <s:property value="user_stock"/>
											&& i <= 10; i++) {
										sel.options[i - 1] = new Option(i);
									}
								</script>

			</s:iterator>


		</div>
	</div>


	<footer style="text-align: center;">
		<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
	</footer>
</body>
</html>