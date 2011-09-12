<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户信息</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" >
			$(function(){
				setOnlineTime();
			});
		
			function setOnlineTime(){
				var onlineTime;
				$.ajax({ 
			            async:false,
			            type:"post", 
			            contentType:"application/json", 
			            url:"timeAjax.htm", 
			            data:"{}", 
			            dataType:"json", 
			            success:function(data){
			            	onlineTime = data[0];   
			            }
			        }); 
			    $("#onlineTime").val(onlineTime);
			    setTimeout("setOnlineTime();", 60000);
			}
			
		</script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<div id='logout' style="float:right">
		<c:if test="${user.isVip=='0'}">
			<a href="logout.htm?type=1">注销</a>
		</c:if>
		<c:if test="${user.isVip=='1'}">
			<a href="logout.htm?type=2">注销</a>
		</c:if>
	</div>
		<br><br>
		<c:if test="${user.isVip=='1'}">
			<center>
				<h2>尊敬的会员用户${user.vipCard}，</h2>
			</center>
		</c:if>
		<c:if test="${user.isVip=='0'}">
			<center><h2>普通用户${user.identityId}，您好！</h2></center>
		</c:if>
		<center>
			<h3>结账前请先注销！</h3>
		</center>
		<br><br>
		<table align="center">
			<tr>
				<td>身份证ID：</td>
				<td><input type="text" value="${user.identityId}" readonly="readonly"/>
			</tr>
			<tr>
				<td>剩余金额：</td>
				<td><input id='now_remain' type="text" value="${user.remain}" readonly="readonly"/>元
			</tr>
			<tr>
				<td>登陆时间：</td>
				<td><input type="text" value="${user.loggedTime}"/>
			</tr>
			<tr>
				<td>在线时间：</td>
				<td><input id="onlineTime" type="text"/>
			</tr>
		</table>
	</body>
</html>