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

<link rel="stylesheet" href="./css/cart.css" type="text/css">
<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="./js/cart_check.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<style>
#categorylist<s:property value="item_category"/>{
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
.navbar .navbar-brand:hover,
.navbar .navbar-brand:focus {
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
.navbar .navbar-nav .nav-link:not(.disabled):hover,
.navbar .navbar-nav .nav-link:not(.disabled):focus {
  color: #ecdbff;
}
.navbar .navbar-nav .nav-item.active .nav-link,
.navbar .navbar-nav .nav-item.active .nav-link:hover,
.navbar .navbar-nav .nav-item.active .nav-link:focus,
.navbar .navbar-nav .nav-item.show .nav-link,
.navbar .navbar-nav .nav-item.show .nav-link:hover,
.navbar .navbar-nav .nav-item.show .nav-link:focus {
  color: #ecdbff;
  background-color: #ddd;
}
.navbar .navbar-toggle {
  border-color: #ddd;
}
.navbar .navbar-toggle:hover,
.navbar .navbar-toggle:focus {
  background-color: #ddd;
}
.navbar .navbar-toggle .navbar-toggler-icon {
  color: #ecf0f1;
}
.navbar .navbar-collapse,
.navbar .navbar-form {
  border-color: #ecf0f1;
}
.navbar .navbar-link {
  color: #ecf0f1;
}
.navbar .navbar-link:hover {
  color: #ecdbff;
}

@media (max-width: 575px) {
  .navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item {
    color: #ecf0f1;
  }
  .navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:hover,
  .navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:focus {
    color: #ecdbff;
  }
  .navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item.active {
    color: #ecdbff;
    background-color: #8e44ad;
  }
}

@media (max-width: 767px) {
  .navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item {
    color: #ecf0f1;
  }
  .navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:hover,
  .navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:focus {
    color: #ecdbff;
  }
  .navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item.active {
    color: #ecdbff;
    background-color: #8e44ad;
  }
}

@media (max-width: 991px) {
  .navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item {
    color: #ecf0f1;
  }
  .navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:hover,
  .navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:focus {
    color: #ecdbff;
  }
  .navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item.active {
    color: #ecdbff;
    background-color: #8e44ad;
  }
}

@media (max-width: 1199px) {
  .navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item {
    color: #ecf0f1;
  }
  .navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:hover,
  .navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:focus {
    color: #ecdbff;
  }
  .navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item.active {
    color: #ecdbff;
    background-color: #8e44ad;
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
  background-color: #8e44ad;
}
</style>
</head>
<body>
<div id="pagecover">

	<s:if test="%{cartList != null && session,user_id != null}">
		<section class="contents">
			<div class="container">
				<h1><s:text name="lang.cart.cart" /></h1>
					<table class="table table-bordered">

						<thead>
							<tr class="bg-warning">
								<th><s:text name="lang.cart.item" /></th>
								<th><s:text name="lang.cart.price" /></th>
								<th><s:text name="lang.cart.quantity" /></th>
								<th><s:text name="lang.cart.subtotal" /></th>
								<th><s:text name="lang.cart.delete" /></th>
							</tr>
						</thead>

						<tbody class="text-center">
							<s:iterator value="cartList" status="st">
								<tr>
									<th><s:property value="item_name" /></th>
									<th><script>
										decimal_floor(<s:property value="item_price" />);
									</script><s:text name="lang.cart.yen" /><s:text name="lang.cart.excludetax" /></th>
									<th>
										<s:form action="CartUpdateAction">
											<s:select list="{\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\",\"10\",\"11\",\"12\",\"13\",\"14\",\"15\",\"16\",\"17\",\"18\",\"19\",\"20\"}"
 												name="order_count" Value="%{order_count}"
	 											onChange="this.form.submit()" />
	 											<s:hidden name="cart_id" value="%{cart_id}" />
	 									</s:form>
									</th>
									<th><script>
										decimal_floor(<s:property value="sub_total" />);
									</script>
									<s:text name="lang.cart.yen" />
									</th>
									<th>
										<s:form action="CartDeleteAction" theme="simple">
											<button class="btn btn-danger btn-xs" type="submit">
												<s:text name="lang.cart.delete" />
												<s:hidden name="cart_id" value="%{cart_id}" />
											</button>
                      <s:token/>
										</s:form>
									</th>
								</tr>
							</s:iterator>
						</tbody>
				</table>

<div class="container-fluid">
  <div class="row">
<div class="col-xs-8 col-sm-5 col-md-3 pull-right" >
        <ul class="list-group" class="text-right">
  <li class="list-group-item"><h4 class="text-right"><s:text name="lang.cart.totalfee" />&nbsp;<script>decimal_floor(<s:property value="total_price" />);</script>
            &nbsp;<s:text name="lang.cart.yen" /></h4></li>
  <li class="list-group-item"><h4  class="text-right" style="color:red; "> <s:text name="lang.cartcheck.Shippingtaxexclusion" />&nbsp;<s:text name="constant.postage" />&nbsp;<s:text name="lang.cart.yen" /></h4></li>
  <li class="list-group-item"><h4  class="text-right"  style="font-weight:bold; "><s:text name="lang.cart.totalwithpos" />&nbsp;<script type="text/javascript">
                              add(<s:property value="total_price" />,
                                  <s:text name="constant.postage"/>);
                            </script>&nbsp;<s:text name="lang.cart.yen" /></h4></li>
</ul>
</div>
</div>
</div>


      <div class="buttonbox" style="display:inline-flex">
              <div class="row">
              <div class="col-sm-6 col-xs-12">
          	<s:form action="ItemListAction">
							<button class="btn btn-custom"><s:text name="lang.cart.Totheproductlist" /></button>
						</s:form>
			</div>
			<div class="col-sm-6 col-xs-12">
						<s:form action="GoPurchaseAction">
							<button class="btn btn-custom2" id="margin"><s:text name="lang.cart.Toorderprocedure" /></button>
						</s:form>
			</div>
			</div>
       </div>
		</div>
		</section>
	</s:if>
	<s:else>
	<h1 style="text-align:center; padding-top:100px;"><s:text name="lang.cart.Productsinthecartcontents" /><br>
	<s:text name="lang.cart.Thereisnocontentsofthecart" /></h1>

	</s:else>
  </div>
  <footer>
    <s:include value="footerload.jsp" />
  </footer>
</body>
</html>