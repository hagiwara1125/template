<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Calendar"%>
<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int[] yearList = new int[10];
	for (int i = 0; i < 10; i++) {
		yearList[i] = year;
		year++;
	}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><s:text name="lang.purchase.title" /></title>

<link rel="stylesheet" type="text/css" href="css/purchase.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/payment.js"></script>
<script type="text/javascript" src="js/cart_check.js"></script>

</head>

<body style="margin:0 auto;">
	<div id="pagecover">
		<!-- ヘッダーここから -->

		<header>
			<s:include value="header.jsp"></s:include>
		</header>

		<!-- ここまで -->

		<script>
			jQuery(function() {
				jQuery(document).trigger("enhance");
			});

			$(function() {
				$("#expirationYear").ymdpulldown({

				});

			});
			$(function() {

				$('#insertButton').click(function(e) {
					var num1 = $('#num1').val();
					var num2 = $('#num2').val();
					var num3 = $('#num3').val();
					var num4 = $('#num4').val();

					var creditNumber = num1 + num2 + num3 + num4;
					$('#creditNumber').attr({
						'value' : creditNumber,
					});

				});

				$("#nameE").on("invalid", function(e) {
					if (e.currentTarget.validity.patternMismatch) {
						this.setCustomValidity("※半角英字のみ入力可能です");
					}
				}).on("input", function() {
					this.setCustomValidity("");
				});

				$("#securityCode").on("invalid", function(e) {
					if (e.currentTarget.validity.patternMismatch) {
						this.setCustomValidity("※3~4桁の半角数字のみ入力可能です");
					}
				}).on("input", function() {
					this.setCustomValidity("");
				});

				$("#num1").on("invalid", function(e) {
					if (e.currentTarget.validity.patternMismatch) {
						this.setCustomValidity("※4桁の半角数字のみ入力可能です");
					}
				}).on("input", function() {
					this.setCustomValidity("");
				});

				$("#num2").on("invalid", function(e) {
					if (e.currentTarget.validity.patternMismatch) {
						this.setCustomValidity("※4桁の半角数字のみ入力可能です");
					}
				}).on("input", function() {
					this.setCustomValidity("");
				});

				$("#num3").on("invalid", function(e) {
					if (e.currentTarget.validity.patternMismatch) {
						this.setCustomValidity("※4桁の半角数字のみ入力可能です");
					}
				}).on("input", function() {
					this.setCustomValidity("");
				});

				$("#num4").on("invalid", function(e) {
					if (e.currentTarget.validity.patternMismatch) {
						this.setCustomValidity("※3~4桁の半角数字のみ入力可能です");
					}
				}).on("input", function() {
					this.setCustomValidity("");
				});

				$("#usepointform").on("invalid", function(e) {
					if (e.currentTarget.validity.patternMismatch) {
						this.setCustomValidity("※半角数値のみ入力可能です");
					}
				}).on("input", function() {
					this.setCustomValidity("");
				});

			});
		</script>
		<script>
			function nextField(i, n, m) {
				if (i.value.length >= m) {
					i.form.elements[n].focus();
				}
			}

			function checkPoint(total, point) {
				if (document.paymentForm.use_point.value >= total
						|| document.paymentForm.use_point.value >= point) {
					if (point < total) {
						document.paymentForm.use_point.value = point;
					} else {
						document.paymentForm.use_point.value = total;
					}
				}
			}
		</script>

		<!-- クレジットカード情報入力フォーム -->


		<!-- ログイン時 -->
		<s:if test="%{cartList!=null && #session.user_id != null}">
			<s:form action="CheckCreditAction" name="paymentForm" theme="simple">
				<div id="container" style="margin-top: 40px;">
					<div class="panel-title">
						<span class="glyphicon glyphicon-pencil"></span>&nbsp;
						<s:text name="lang.user_pay.fillin" />
					</div>
					<div id="freme">
						<div class="row" id="pricearea">
						</div>
						<div class="row">
							<div class="col-sm-4" id="formtitle">
								<h2>
									<s:text name="lang.user_pay.creditcardnumber" />
									<font color="red">*</font>
								</h2>
							</div>
							<div id="textform" class="col-sm-8 form-inline">
								<input type="hidden" name="creditNumber" id="creditNumber" /> <input
									type="text" id="num1" pattern="[0-9]{4}" required maxlength="4"
									size="2" onKeyUp="nextField(this, 'num2', 4)"
									class="form-control">- <input type="text" id="num2"
									pattern="[0-9]{4}" required maxlength="4" size="4"
									onKeyUp="nextField(this, 'num3', 4)" class="form-control">-
								<input type="text" id="num3" pattern="[0-9]{4}" required
									maxlength="4" size="4" onKeyUp="nextField(this, 'num4', 4)"
									class="form-control">- <input type="text" id="num4"
									pattern="[0-9]{3,4}" maxlength="4" size="4" required
									class="form-control"><br>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4" id="formtitle">
								<h2>
									<s:text name="lang.user_pay.name" />
									<font color="red">*</font>
								</h2>
							</div>
							<div id="textform" class="col-sm-8">
								<input name="nameE" class="form-control" type="text" size="15"
									maxlength="40" placeholder="TARO TANAKA" required
									pattern="[a-z\s]+$" id="nameE">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4" id="formtitle">
								<h2>
									<s:text name="lang.user_pay.securitycode" />
									<font color="red">*</font>
								</h2>
							</div>
							<div id="textform" class="col-sm-8">
								<input  name="securityCode" type="password" class="form-control"
									size="5" maxlength="4" placeholder="123" pattern="[0-9]{3,4}"
									required id="securityCode">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4" id="formtitle">
								<h2>
									<s:text name="lang.user_pay.cardexpiration" />
									<font color="red">*</font>
								</h2>
							</div>
							<div id="textform" class="col-sm-8 form-inline">
								<select name="expirationMonth" class="form-control" id="eMonth">
									<option value="1" selected="selected">01</option>
									<option value="2">02</option>
									<option value="3">03</option>
									<option value="4">04</option>
									<option value="5">05</option>
									<option value="6">06</option>
									<option value="7">07</option>
									<option value="8">08</option>
									<option value="9">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>&nbsp;
								<s:text name="lang.user_pay.month" />
								&emsp;/&nbsp; <select class="form-control" id="se1"
									name="expirationYear">
									<%
										for (int y : yearList) {
									%>
									<option value="<%=y%>"><%=y%></option>
									<%
										}
									%>
								</select>&nbsp;
								<s:text name="lang.user_pay.year" />
							</div>
						</div>


					</div>

					<!-- カートの中身画面へ遷移 -->
					<div class="buttonfreme">
						<span class="back"><a href="SelectCartAction" class="backlink"><s:text
									name="lang.user_pay.back" /></a></span>
						<!-- 購入確認画面へ遷移 -->
						<input type="submit" value="<s:text name="lang.user_pay.next"/>"
							id="insertButton" class="nextlink" />
					</div>
				</div>
			</s:form>

		</s:if>
		<!-- 未ログイン時 -->
		<s:else>
			<h2 style="text-align: center; margin-top: 200px;">
				<s:text name="lang.user_pay.error" />
			</h2>
		</s:else>
	</div>
	<footer style="text-align: center;">
		<c:import url="http://www.internousdev.com/openconnect/footer.jsp" />
	</footer>
</body>
</html>