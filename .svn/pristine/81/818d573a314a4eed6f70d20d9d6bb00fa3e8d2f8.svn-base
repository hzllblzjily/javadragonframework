<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.hongbao.boapp.complextype.*" %>

<%!
	List<DragonAuthenticationConstMgrComplexType> authList = new ArrayList<DragonAuthenticationConstMgrComplexType>();

%>
<% 
	authList = (List<DragonAuthenticationConstMgrComplexType>)request.getAttribute("authList");
	
	

%>


<%!
	public boolean hasAuthorize(DragonAuthenticationConstMgrComplexType mgr){
		
		if(authList.contains(mgr)){
			return true;
		}else{
			return false;
		}
	}

%>

<!--LAYOUT CSS-->
<link rel="stylesheet" href="/public/css/layout/header.css" />

<header id="header" class="bb">
<div class="container p0_32">
	<div class="row clearfix">
			<!--logo-->
		<div class="column third logo text-align-left">
			<a href="/">
				<div class="logo-img bg-dark-green inline-block"></div>
				<h1 class="logo-name dark-green inline-block p0_15">蛋壳</h1>
			</a>
		</div>
			<!--searchBox-->
		<div class="column third searchBox">
			<form action="/screenshots/searchscreenshot" id="search" class="clearfix">
				<div class="column inline-block">
					<input type="text" placeholder="搜索关键词、App名称" class="search-area border" id="search-area" name="search" />
					<i class="iconfont search-icon bg-dark-green p6_11" id="search-icon">&#xe600;</i>
				</div>
			</form>
		</div>
		
			<!--login-->
		<ul class="column third login text-align-right">
			<li class="fr">
				<!--logout-->
				<h5 class="logout-area dark-gray">
					<a href="/users/enterlogin">登录/注册</a>
				</h5>
				<!--login-->
				<div class="login-area is-hidden">
					<img src=""/>
				</div>
				
				<!--Menu-->
					<ul class="main-menu border text-align-left is-hidden">
						<li class="bb"><a href="/screenshots/listlikescreenshot">我喜欢的截图</a></li>
						<li class="bb"><a href="/applications/listsubscribeapp">我订阅的APP</a></li>
						<li class="bb"><a href="/users/entersetcurrentuser">个人设置</a></li>
						<li><a href="/users/logout">退出登录</a></li>
					</ul>
				</li>
				<li class="fr">
					<h4 class="faq dark-gray">
						<a href="/public/about.html" target="_blank">关于</a>
					</h4>
				</li>
			</ul>
		</div>
	</div>
</header>
<!-- COMMON JS -->
<script src="/public/js/jquery.min.js"></script>
<script type="text/javascript" src='/public/js/common/common.js'></script>
<!-- PAGE JS -->	
<script type="text/javascript">
	var authList_array=[];
	/* 遍历权限List，数据存储到JSON数组  */
	<%
		if(authList!=null){
			for(int i=0;i<authList.size();i++){
				DragonAuthenticationConstMgrComplexType authentication=authList.get(i);
	%>
					authList_array.push({
						'module':'<%=authentication.getModule()%>',
						'controller':'<%=authentication.getController()%>',
						'action':'<%=authentication.getAction()%>',
						'method':'<%=authentication.getMethod()%>',
						'interfaceDescription':'<%=authentication.getInterfaceDescription()%>',
						'isPublic':'<%=authentication.isPublic()%>',
						'hasAuth':'<%=authentication.isHasAuth()%>'
					});
	<%
			}
		}	
	%>
	console.log(authList_array);
	
	/* 获取当前登录用户信息  */
	var currentUserInfo={};
	<%
		CurrentUserInfo currentUserInfo=(CurrentUserInfo)request.getSession().getAttribute("currentUserSessionKey");
		if(currentUserInfo!=null){
	%>
			currentUserInfo={
				'Id':'<%=currentUserInfo.getId()%>',
				'Email':'<%=currentUserInfo.getEmail()%>',
				'UserName':'<%=currentUserInfo.getUserName()%>',
				'Avator':'<%=currentUserInfo.getAvatar()==null?currentUserInfo.getDefaultAvatarString():currentUserInfo.getAvatar().getThumbFileUrl()%>'
				
			};
	<%
		}
	%>

	/* 更改NAVBAR登录状态,默认未登录 */
	if(!$.isEmptyObject(currentUserInfo)){
		console.log(currentUserInfo);
		$('.login-area img').attr('src',currentUserInfo.Avator);
		centerCropImg(currentUserInfo.Avator,$('.login-area'));
		$('.logout-area').addClass('is-hidden');
		$('.login-area').removeClass('is-hidden');
	}
	
	/* DropDown_Array */
	var DropDown_Array=[{
							'module':'default',
							'controller':'markcategorys',
							'action':'entermarkcategorylist',
							'method':'GET',
							'menuItem':'标签类别管理'
						},
	                    {
							'module':'default',
							'controller':'marks',
							'action':'entermarklist',
							'method':'GET',
							'menuItem':'标签管理'
						},
						{
							'module':'default',
							'controller':'applications',
							'action':'list',
							'method':'GET',
							'menuItem':'APP截图管理'
						},
						{
							'module':'default',
							'controller':'users',
							'action':'searchuser',
							'method':'GET',
							'menuItem':'用户管理'
						},
						{
							'module':'default',
							'controller':'authentications',
							'action':'enterrolelist',
							'method':'GET',
							'menuItem':'权限管理'
						}];
	
	/* 根据权限显示DropDownMenu */
	if(authList_array.length>=1){
		var returnValue=hasAuth(DropDown_Array,authList_array);
		for(var i=0;i<returnValue.length;i++){
			$('<li class="bb">'+
					'<a href="'+returnValue[i].link+'">'+returnValue[i].menuItem+'</a>'+
				'</li>').insertBefore('.main-menu li:last');
		}
	}
	
	/* search */
	$('#search-icon').click(function(){
		var v = document.getElementById("search-area").value;
		window.location.href = "/screenshots/searchscreenshot?search=" + v;
	});
</script>
		



