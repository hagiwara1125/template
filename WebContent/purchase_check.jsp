<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" type="text/css" href="css/purchase_check.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><s:text name="lang.cartcheck.title" /></title>
<script type="text/javascript" src="./js/cart_check.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div id="pagecover">
    <header>
      <s:include value="header.jsp"></s:include>
    </header>
	<div class="container-fluid">
	<div class="row">
	<div class="col-sm-12">
    <div class="mainbox">
      <h4 style="text-decoration: underline;">
        <s:text name="lang.cartcheck.text" />
        &nbsp;
        <s:text name="lang.cartcheck.text2" />
      </h4>
      <br>
      <div class="container-fluid">
        <div class="table-responsive">
          <h2>
            <s:text name="lang.cartcheck.Itemsinabasket" />
          </h2>
          <table class="table table borderd">
            <tr>
              <th class="col-md-5"><s:text
                  name="lang.cartcheck.item" /></th>
              <th class="col-md-2"><s:text
                  name="lang.cartcheck.price" /></th>
              <th class="col-md-2"><s:text
                  name="lang.cartcheck.quantity" /></th>
              <th class="col-md-3"><s:text
                  name="lang.cartcheck.subtotal" /></th>
            </tr>

            <s:iterator value="cartList">
              <tr>
                <td class="col-md-5"><s:property value="item_name" /></td>
                <td class="col-md-2">&yen;<script
                    type="text/javascript">
                                  decimal_floor(<s:property value="price" />);
                                </script></td>
                <td class="col-md-2"><s:property
                    value="order_count" /></td>
                <td class="col-md-3">&yen;<script
                    type="text/javascript">
                                  multiply(<s:property value="price" />,
                                      <s:property value="order_count" />);
                                </script></td>
              </tr>
            </s:iterator>
          </table>

          <h2>
            <s:text name="lang.cartcheck.breakdown" />
          </h2>
          <table class="table">
            <tr>
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.Producttotal" /></th>
              <td class="col-md-3">&yen;<script
                  type="text/javascript">
                              decimal_floor(<s:property value="total" />);
                            </script></td>
            </tr>

            <tr>
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.Shippingtaxexclusion" /></th>
              <td class="col-md-3">&yen;<s:text
                  name="constant.postage" /></td>
            </tr>

            <tr>
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.subtotal" /></th>
              <td class="col-md-3">&yen;<script
                  type="text/javascript">
                              add(<s:property value="total" />,
                                  <s:text name="constant.postage"/>);
                            </script></td>
            </tr>

            <tr>
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.consumptiontax" /></th>
              <td class="col-md-3">&yen;<script
                  type="text/javascript">
                              cal_tax(<s:text name="constant.rate"/>);
                            </script></td>
            </tr>

            <tr>
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.ordertotal" /></th>
              <td class="col-md-3">&yen;<script
                  type="text/javascript">
                              cal_total();
                            </script></td>
            </tr>

            <tr>
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.usingpoint" /></th>
              <td class="col-md-3" style="color: red;">- &yen;<s:property
                  value="use_point" /></td>
            </tr>

            <tr class="ordertotal">
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.Totalpayment" /></th>
              <td class="col-md-3" style="font-weight: bold;">&yen;<script
                  type="text/javascript">
                              cal_totalAll(<s:property value="use_point" />);
                            </script></td>
            </tr>

            <tr class="get_point">
              <th class="col-md-9"><s:text
                  name="lang.cartcheck.getpoint" /></th>
              <td class="col-md-3" style="font-weight: bold;"><s:property
                  value="get_point" />
                <s:text name="lang.cartcheck.points" /></td>
            </tr>
          </table>

          <h2>
            <s:text name="lang.cartcheck.methodofpayment" />
          </h2>
          <table class="table table borderd">
            <tr>
              <th class="col-md-4"><s:text
                  name="lang.cartcheck.methodofpayment" /></th>
              <td class="col-md-8"><s:text
                  name="lang.cartcheck.credit" /><br></td>
            </tr>
          </table>

          <h2>
            <s:text name="lang.cartcheck.addressee" />
          </h2>
          <s:iterator value="userList">
            <table class="table table borderd">
              <tr>
                <th class="col-md-4"><s:text
                    name="lang.cartcheck.name" /></th>
                <td class="col-md-8"><s:property value="name" /></td>
              </tr>
              <tr>
                <th class="col-md-4"><s:text
                    name="lang.cartcheck.adress" /></th>
                <td class="col-md-8">〒<script
                    type="text/javascript">
                                  postal_hyphen(<s:property value="postal" />)
                                </script>
                  <br>
                <s:property value="address" /></td>
              </tr>
              <tr>
                <th class="col-md-4"><s:text
                    name="lang.cartcheck.phonenumber" /></th>
                <td class="col-md-8"><s:property
                    value="phoneNumber" /></td>
              </tr>
              <tr>
                <th class="col-md-4"><s:text
                    name="lang.cartcheck.phone" /></th>
                <td class="col-md-8"><s:property value="phoneemail" /></td>
              </tr>
            </table>
          </s:iterator>

        </div>
      </div>
    </div>
    <br>
    <div class="orderbuttom">
    <div class="row">
    <div class="col-xs-12 col-sm-6" style="text-align:center;">
      <a href="GoPaymentAction" class="backlink"><s:text
          name="lang.cartcheck.text3" /></a>
          </div>
          <div class="col-xs-12 col-sm-6 style="text-align:center;">
          <form action="GoCartDoneAction" method="post">
			<s:hidden name="use_point" value="%{use_point}"/>
			<s:hidden name="get_point" value="%{get_point}"/>
			<button class="nextlink" type="submit"><s:text name="lang.cartcheck.text4" /></button>
      <s:token/>
          </form>
        </div>
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
