<%@page import="com.hongbao.boapp.exception.DragonBusinessException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<title>没有权限</title>
		<link rel="icon shortcut" href="/public/img/favicon.ico" type="image/x-icon" />
    <style type="text/css">
      body {
       margin: 0;
       padding: 0;
       font-family: "helvetica neue", helvetica, arial, sans-serif;
       font-size: 13px;
       background: #8dd3d5 url("/public/img/error_bg_2.png") repeat-x 0 0;
      }
      #background { width: 100%; height: 100%; z-index: 1; }
      #content {
        position:absolute;
        text-align:center;
        top:55px;
        width:100%;
        z-index:3;
        text-shadow: 0 1px 1px #FFF;
        min-height: 700px;
        background: url("/public/img/shoes_hanging.png") no-repeat 50% 120px;
      }
      #logo { position: absolute; z-index: 4; left: 22%; top: 12px;}
      h1 { color: #363C44; font-size: 32pt; font-weight: bold; line-height: 25px; margin-bottom: 0;}
      h2, p { color: #64818E; font-size: 15pt; font-weight: normal;}
      p { font-size: 13pt; }
      p a, p a:visited, a img { color: #454545; text-decoration: underline; border: none; outline: 0;}
    </style>
  </head>
  <body>
    <div id="error_page">
      <img id="background" src="/public/img/500background.jpg" alt="clouds" />
      <div id="content">
        <h2>没有权限</h2>
        <p>回到 <a href="/">首页</a>, or <a href="#">联系我们</a> </p>
      </div>
    </div>
  </body>
</html>