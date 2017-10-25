<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title><s:text name="lang.cart_done.tab" /></title>
<link rel="stylesheet" type="text/css" href="css/cart_done.css">
<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
  type="text/javascript"></script>
  <script src="./bootstrap/js/bootstrap.min.js"></script>
  <style>
#categorylist<s:property value="category"/>{
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
 <script type="text/javascript">
 $(function() {
   $('.pointbox').hide().fadeIn(1500);
 });
 </script>
  <script type="text/javascript">
      window.onunload = function() {
      };//Firefoxにも適用する場合には記述する
      history.forward();
    </script>
    <div id="top_visual">
    <img class="pc" src="./img/bg.jpg" alt="パソコン用トップ画像">
    <img class="sp" src="./img/sp-cartdone.jpg" alt="スマホ用トップ画像">
  </div>
  <div id="pagecover">
<header>
			<!-- ログインの場合 -->
	<s:if test="session.get(\"user\").equals(\"success\")">
				<nav class="navbar navbar-default">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#gnavi">
								<span class="sr-only">ナビゲーション</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a href="GoTopAction" class="navbar-brand">BentoPad</a>
						</div>
						<div class="collapse navbar-collapse" id="gnavi">
							<ul class="navbar-right nav navbar-nav">
								<li>
									<a href="GoTopAction"><span class="glyphicon glyphicon-home"></span>Top</a>
								</li>
								<li>
									<a href="GoRecipeListAction"><span class="glyphicon glyphicon-cutlery"></span>Recipes</a>
								</li>
								<li>
									<a href="UserItemListAction"><span class="glyphicon glyphicon-briefcase"></span>Products</a>
								</li>
								<li>
									<a href="GoMypageAction"><span class="glyphicon glyphicon-th-list"></span>Mypage</a>
								</li>
								<li>
									<a href="GoCartAction"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a>
								</li>
								<li>
									<a href="GoContactAction"><span class="glyphicon glyphicon-earphone"></span>Contact</a>
								</li>
								<li>
									<a href="LogoutAction"><span class="glyphicon glyphicon-leaf"></span>Logout</a>
								</li>
							</ul>
		      			 </div>
				</nav>
		</s:if>
		<!-- 未ログインの場合 -->
		<s:else>
				<nav class="navbar navbar-default">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#gnavi">
								<span class="sr-only">ナビゲーション</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a href="GoTopAction" class="navbar-brand">BentoPad</a>
						</div>
						<div class="collapse navbar-collapse" id="gnavi">
							<ul class="navbar-right nav navbar-nav">
								<li>
									<a href="index.jsp"><span class="glyphicon glyphicon-home"></span>Top</a>
								</li>
								<li>
									<a href="GoRecipeListAction"><span class="glyphicon glyphicon-cutlery"></span>Recipes</a>
								</li>
								<li>
									<a href="UserItemListAction"><span class="glyphicon glyphicon-briefcase"></span>Products</a>
								</li>
                <li>
                  <a href="about.jsp"><span class="glyphicon glyphicon-th-list"></span>About</a>
                </li>
								<li>
									<a href="contact.jsp"><span class="glyphicon glyphicon-earphone"></span>Contact</a>
								</li>
								<li>
									<a href="login.jsp"><span class="glyphicon glyphicon-leaf"></span>Login</a>
								</li>
							</ul>
						</div>
				</nav>
		</s:else>
	</header>
    <div class="main">
      <br>
      <h1>
        <span class="maintext"><s:text
            name="lang.cart_done.text1" /></span>
      </h1>
      <h2>
        <s:text name="lang.cart_done.text2" />
      </h2>
      <br>
      <h4>
        <s:text name="lang.cart_done.text3" />
        &nbsp;：&nbsp;<span class="pointbox">&nbsp;<s:property
            value="get_point" /> <s:text name="lang.cartcheck.points" /></span>
      </h4>
      <h4>
        (※
        <s:text name="lang.cart_done.text4" />
        &nbsp;<a href="GoMypageAction"><s:text
            name="lang.cart_done.text5" /></a>&nbsp;
        <s:text name="lang.cart_done.text6" />
        )
      </h4>
    </div>
    <script type="text/javascript">
          //History API が使えるブラウザかどうかをチェック
          if (window.history && window.history.pushState) {
            //. ブラウザ履歴に１つ追加
            history.pushState("nohb", null, "");
            $(window).on("popstate", function(event) {
              //. このページで「戻る」を実行
              if (!event.originalEvent.state) {
                //. もう一度履歴を操作して終了
                history.pushState("nohb", null, "");
                window.alert("ブラウザバックは無効です。");
                return;
              }
            });
          }
        </script>
  </div>
  <footer>
    <s:include value="footerload.jsp" />
  </footer>
</body>
</html>