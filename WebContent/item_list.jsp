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

<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>

<style>
#categorylist<s:property value ="category"/>
{
background-color:#ffdb99;
}
</style>
<style>
.navbar {
	background-color: #ffb959;
}

.navbar .navbar-brand {
	color: #ecf0f1;
}

.navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
	color: #ddd;
}

.navbar .navbar-text {
	color: #ecf0f1;
}

.navbar .navbar-nav .nav-link {
	color: #ecf0f1;
	border-radius: .25rem;
	margin: 0 0.25em;
}

.navbar .navbar-nav .nav-link:not (.disabled ):hover, .navbar .navbar-nav .nav-link:not
	(.disabled ):focus {
	color: #ecdbff;
}

.navbar .navbar-nav .nav-item.active .nav-link, .navbar .navbar-nav .nav-item.active .nav-link:hover,
	.navbar .navbar-nav .nav-item.active .nav-link:focus, .navbar .navbar-nav .nav-item.show .nav-link,
	.navbar .navbar-nav .nav-item.show .nav-link:hover, .navbar .navbar-nav .nav-item.show .nav-link:focus
	{
	color: #ecdbff;
	background-color: #ddd;
}

.navbar .navbar-toggle {
	border-color: #ddd;
}

.navbar .navbar-toggle:hover, .navbar .navbar-toggle:focus {
	background-color: #ddd;
}

.navbar .navbar-toggle .navbar-toggler-icon {
	color: #ecf0f1;
}

.navbar .navbar-collapse, .navbar .navbar-form {
	border-color: #ecf0f1;
}

.navbar .navbar-link {
	color: #ecf0f1;
}

.navbar .navbar-link:hover {
	color: #ecdbff;
}

@media ( max-width : 575px) {
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #ddd;
	}
}

@media ( max-width : 767px) {
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #ddd;
	}
}

@media ( max-width : 991px) {
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #ddd;
	}
}

@media ( max-width : 1199px) {
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ecf0f1;
	}
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ecdbff;
	}
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ecdbff;
		background-color: #ddd;
	}
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item {
	color: #ecf0f1;
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item:hover,
	.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item:focus {
	color: #ecdbff;
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item.active {
	color: #ecdbff;
	background-color: #ddd;
}
</style>
<!--[if lt IE 11]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.js"></script>
<![endif]-->
</head>
<body>
	<div id="pagecover">

	<header>
		<s:include value="header.jsp"></s:include>
	</header>

		<div class="container" style="margin-top: 50px;">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12">
					<section class="guide">
						<h1>
							<s:text name="lang.itemlist.title" />
						</h1>
						<p>
							<s:text name="lang.itemlist.toptext" />
						</p>
					</section>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm12 col-md-3">
					<div class="list-group">
						<a
							href="<s:url action="UserItemListAction"><s:param name="category" value="0"/></s:url>"
							id="categorylist0" class="list-group-item"><s:text
								name="lang.itemlist.allitem" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="1"/></s:url>"
							id="categorylist1" class="list-group-item"><s:text
								name="lang.itemlist.vegetable" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="2"/></s:url>"
							id="categorylist2" class="list-group-item"><s:text
								name="lang.itemlist.meat" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="3"/></s:url>"
							id="categorylist3" class="list-group-item"><s:text
								name="lang.itemlist.seafood" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="4"/></s:url>"
							id="categorylist4" class="list-group-item"><s:text
								name="lang.itemlist.fruits" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="5"/></s:url>"
							id="categorylist5" class="list-group-item"><s:text
								name="lang.itemlist.egg" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="6"/></s:url>"
							id="categorylist6" class="list-group-item"><s:text
								name="lang.itemlist.potato" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="7"/></s:url>"
							id="categorylist7" class="list-group-item"><s:text
								name="lang.itemlist.mushroom" /></a> <a
							href="<s:url action="UserItemListAction"><s:param name="category" value="9"/></s:url>"
							id="categorylist9" class="list-group-item"><s:text
								name="lang.itemlist.other" /></a>
					</div>
				</div>

				<div class="col-xs-12 col-xs-12 col-md-9" id="listarea">
					<div class="row">
						<s:if test="itemList.size()!=0">
							<s:iterator value="itemList" status="st">
								<div class='col-sm-6 col-md-4' id="itembox">
									<a href="#<s:property value="#st.count"/>" data-toggle="modal"
										data-target="#<s:property value="#st.count"/>">
										<div class="thumbnail">
											<img src="<s:property value='img_path'/>"
												style="width: 100%; height: 150px; object-fit: cover;">

											<div class="caption">
												<h3 style="height: 3.5em; word-wrap: break-word;">
													<s:property value="item_name" />
												</h3>
												<p>
													<script>
														decimal_floor(<s:property value="item_price"/>)
													</script>
													<s:text name="lang.itemlist.yen" />
												</p>
											</div>
										</div>
									</a>
								</div>


								<!-- 商品詳細モーダル -->
								<div class="modal fade" id="<s:property value="#st.count"/>"
									tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span>×</span>
												</button>
												<h4 class="modal-title">
													<s:property value="item_name" />
												</h4>
											</div>
											<form action="CartInsertAction"
												name="cartInsertForm<s:property value="#st.count"/>">
												<div class="modal-body">
													<!-- 商品詳細 -->
													<div style="width: 100%; margin-bottom: 10px;"
														align="center">
													</div>
													<div class="alt-table-responsive">
														<table style="margin: 0 auto;">
															<tbody>
																<tr class="row">
																	<td class="col-xs-8 col-sm-8 col-md-8" width="250"
																		rowspan="2" align="center" valign="top"><img style="width:100%;"
																		src="<s:property value="img_path"/>"
																		class="img-responsive"></td>
																	<td class="col-xs-4 col-sm-4 col-md-4" align="left"
																		valign="top">
																		<div>
																			<span class="product-detail-price1"
																				style="boder-bottom: solid;"><s:text
																					name="lang.itemlist.price" /></span> <br> <span
																				class="product-detail-price2">￥<script>
																					decimal_floor(<s:property value="price"/>);
																				</script></span>
																			<span class="product-detail-price3">（<s:text
																					name="lang.itemlist.etax" />）
																			</span> <br><br>
																			<span class="product-detail-comment"> <s:property
																				value="item_comment" />
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
														<s:if test="recommend_id.get(#st.index)!=0">
															<div class="row">
																<div class="col-xs-10 col-xs-offset-1"
																	id="recommendarea">
																	<h4>
																		<s:text name="lang.itemlist.recommend" />
																	</h4>
																	<br>
																	<a
																		href="<s:url action="SelectRecipeAction"><s:param name="search_recipe_id" value="%{recommend_id.get(#st.index)}"/></s:url>"><s:property
																			value="recommend_name.get(#st.index)" /></a>

																</div>
															</div>
														</s:if>
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">
														<s:text name="lang.itemlist.close" />
													</button>
													<s:if test="user_stock > 0">
														<s:hidden name="item_id" value="%{itemId}" />
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
												<s:token/>
											</form>
										</div>
									</div>
								</div>

								<script>
									var sel = document.forms.cartInsertForm<s:property value="#st.count"/>.order_count;
									sel.options.length = 0;
									for (var i = 1; i <= <s:property value="user_stock"/>
											&& i <= 10; i++) {
										sel.options[i - 1] = new Option(i);
									}
								</script>


							</s:iterator>
						</s:if>
						<s:else>
							<div class='col-xs-12 col-sm-12 col-md-9' id="itembox">
								<s:text name="lang.itemlist.nomatch" />
							</div>
						</s:else>
						<div class="col-xs-12 col-sm-12 col-md-12">
							<nav>
								<ul class="pagination">

									<s:if test="pageNum==1">
										<li class="disabled"><span aria-hidden="true">&laquo;</span>
										</li>
									</s:if>

									<s:else>
										<li><a
											href="<s:url action="UserItemListAction"><s:param name="pageNum" value="1"/><s:param name="category" value="%{category}"/></s:url>"
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
												href="<s:url action="UserItemListAction"><s:param name="pageNum" value="%{list.get(#st.index)}"/><s:param name="category" value="%{category}"/></s:url>"><s:property
														value="list.get(#st.index)" /></a></li>
										</s:else>
									</s:iterator>

									<s:if test="pageNum==maxPage">
										<li class="disabled"><span aria-hidden="true">&raquo;</span>
										</li>
									</s:if>
									<s:else>
										<li><a
											href="<s:url action="UserItemListAction"><s:param name="pageNum" value="%{maxPage}"/><s:param name="category" value="%{category}"/></s:url>"
											aria-label="1ページへ"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</s:else>
								</ul>
							</nav>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>


	<footer>
		<s:include value="footerload.jsp" />
	</footer>
</body>
</html>