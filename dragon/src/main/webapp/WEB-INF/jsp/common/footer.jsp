<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.hongbao.boapp.complextype.*" %>

<!--LAYOUT CSS-->
<link rel="stylesheet" href="/public/css/layout/footer.css" />

<footer class="footer p50_0">
	<div class="container p0_32">
		<div class="subscribe-btn-container row text-align-center">
			<h5 class="white">您也可以通过电子邮件订阅每周的更新，不错过任何一个好APP</h5>
			<h6 class="light-gray subtitle">我们不会公开您的邮箱，您可以随时取消订阅</h6>
			<form action="" id="form-footer-subscribe" class="clearfix" method="post">
				<input type="text" class="search-area-sm border" id="search-area" name="email" placeholder="「订阅周报」的功能即将开放" disabled="disabled"/>
				<input class="subscribe-input-btn bg-dark-green white" type="submit" value="订阅" />
			</form>
		</div>
		<div class="row clearfix footer-detail-info">
			<div class="copyright fl">
				<h6 class="mb10">上蛋壳，刷新你的APP颜值。</h6>
				<h6 class="light-gray">© 2015 蛋壳. All Rights Reserved. A product of <a class="footer-highlight" href="http://www.imnow.cn" target="_blank">now</a>.</h6>
			</div>
			<div class="footer-info fr light-gray text-align-right">
				<h6 class="mb10"><span id="footer-total-count" class="white"></span> 个伟大的截图</h6>
				<h6>在这里聚集</h6>
			</div>
		</div>
	</div>
</footer>
<div class="back-btn bg-dark-green is-hidden">
	<i class="iconfont back_to_top">&#xe608;</i>
</div>
<script>
	/* 滚动监测 */
	$(window).scroll(function(){
		var top=$(window).scrollTop(),
		clientHeight=document.documentElement.clientHeight;
		if(top>clientHeight){
			$('.back-btn').fadeIn(500);
		}
		else{
			$('.back-btn').stop().fadeOut(500);
		}
		lazyload();
	})
	$('.back-btn').click(function(){
		$("html,body").animate({scrollTop:"0px"},500);
	})
</script>