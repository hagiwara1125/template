<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><s:text name="lang.itemlist.tab" /></title>
<link rel="stylesheet" type="text/css" href="./css/dropmenu.css">
</head>
<body>

	<ul id="dropmenu">
		<li><a href="#">当サイトについて</a>
			<ul>
				<li><a href="#">ヘルプ</a></li>
				<li><a href="#">お問い合わせ</a></li>
			</ul></li>
		<li><a href="<s:url action="ItemListAstion"><s:param name="item_category" value="0" /></s:url>">商品一覧</a>
				<ul>
					<li><a href="<s:url action="ItemListAction"><s:param name="item_user" value="1" /></s:url>">愛猫家さんへ</a>
						<ul>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="1" /></s:url>">キッチン用品</a></li>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="2" /></s:url>">インテリア</a></li>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="3" /></s:url>">文房具</a></li>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="4" /></s:url>">ファッション小物</a></li>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="5" /></s:url>">アクセサリー</a></li>
						</ul>
					</li>
					<li><a href="<s:url action="ItemListAction"><s:param name="item_user" value="2" /></s:url>">ねこちゃんへ</a>
						<ul>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="6" /></s:url>">ごはん</a></li>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="7" /></s:url>">おやつ</a></li>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="8" /></s:url>">おもちゃ</a></li>
							<li><a href="<s:url action="ItemListAction"><s:param name="item_category" value="9" /></s:url>">日用品</a>
						</ul>
					</li>
				</ul>
		</li>
		<li><a href="#">アカウントサービス</a>
			<ul>
				<li><a href="#">マイページ</a></li>
				<li><a href="#">カート</a></li>
			</ul>
		</li>
		<li><a href="<s:url action="LogoutAction"><s:param name="item_category" value="1" /></s:url>">ログアウト</a></li>
	</ul>

</body>
</html>