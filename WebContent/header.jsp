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
<fmt:setBundle basename="com.internousdev.template.property.header"
	var="lang" />

<title><s:text name="lang.header.title" /></title>

<link rel="stylesheet" type="text/css" href="./css/header.css">

</head>

<body>

<!-- ログイン時 -->

	<s:if test="#session.user_flg==1">
		<div id="menulist">
			<ul id="dropmenu">
				<li><a href="#">当サイトについて</a>
					<ul>
						<li><a href="#">ヘルプ</a></li>
						<li><a href="#">お問い合わせ</a></li>
					</ul></li>
				<li><a
					href="<s:url action="ItemListAction"><s:param name="item_category" value="0" /></s:url>">商品一覧</a>
					<ul>
						<li><a
							href="<s:url action="ItemListAction"><s:param name="item_user" value="1" /></s:url>">愛猫家さんへ</a>
							<ul>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="1" /></s:url>">キッチン用品</a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="2" /></s:url>">インテリア</a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="3" /></s:url>">文房具</a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="4" /></s:url>">ファッション小物</a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="5" /></s:url>">アクセサリー</a></li>
							</ul></li>
						<li><a
							href="<s:url action="ItemListAction"><s:param name="item_user" value="2" /></s:url>">ねこちゃんへ</a>
							<ul>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="6" /></s:url>">ごはん</a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="7" /></s:url>">おやつ</a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="8" /></s:url>">おもちゃ</a></li>
								<li><a
									href="<s:url action="ItemListAction"><s:param name="item_category" value="9" /></s:url>">日用品</a>
							</ul></li>
					</ul></li>
				<li><a href="#">アカウントサービス</a>
					<ul>
						<li><a href="GoMyPageAction">マイページ</a></li>
						<li><a href="CartSelectAction">カート</a></li>
					</ul></li>
				<li><a href="<s:url action="LogoutAction"></s:url>">ログアウト</a></li>
			</ul>
		</div>
	</s:if>

<!-- 管理者ログイン -->

	<s:elseif test="#session.user_flg==3">
	</s:elseif>

<!-- 未ログイン時 -->

	<s:else>
		<ul id="dropmenu">
			<li><a href="#">当サイトについて</a>
				<ul>
					<li><a href="#">ヘルプ</a></li>
					<li><a href="#">お問い合わせ</a></li>
				</ul></li>
			<li><a
				href="<s:url action="ItemListAction"><s:param name="item_category" value="0" /></s:url>">商品一覧</a>
				<ul>
					<li><a
						href="<s:url action="ItemListAction"><s:param name="item_category" value="0" /></s:url>">愛猫家さんへ</a>
						<ul>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="1" /></s:url>">キッチン用品</a></li>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="2" /></s:url>">インテリア</a></li>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="3" /></s:url>">文房具</a></li>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="4" /></s:url>">ファッション小物</a></li>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="5" /></s:url>">アクセサリー</a></li>
						</ul></li>
					<li><a
						href="<s:url action="ItemListAction"><s:param name="item_category" value="0" /></s:url>">ねこちゃんへ</a>
						<ul>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="6" /></s:url>">ごはん</a></li>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="7" /></s:url>">おやつ</a></li>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="8" /></s:url>">おもちゃ</a></li>
							<li><a
								href="<s:url action="ItemListAction"><s:param name="item_category" value="9" /></s:url>">日用品</a>
						</ul></li>
				</ul></li>
			<li><a href="#">アカウントサービス</a>
				<ul>
					<li><a href="GoMyPageAction">マイページ</a></li>
					<li><a href="CartSelectAction">カート</a></li>
				</ul></li>
			<li><a href="login.jsp">ログイン</a></li>
		</ul>
	</s:else>

</body>
</html>