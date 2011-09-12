<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" >
			function validateAndSave(){
				var identityId = $("#identityId").val();
				var oldPwd = $("#oldPwd").val();
				var newPwd = $("#newPwd").val();
				var againPwd = $("#againPwd").val();
				if(oldPwd=='' || newPwd=='' || againPwd==''){
					alert('请填写完整');
				}else if(newPwd != againPwd){
					alert('密码确认不正确，请重新填写');
				}else{
					$.ajax({ 
				            async:false,
				            type:"post", 
				            contentType:"application/json", 
				            url:"pwdUpdate.htm?identityId="+identityId+"&oldPwd="+oldPwd+"&newPwd="+newPwd, 
				            data:"{}", 
				            dataType:"json", 
				            success:function(data){
				            	if(data == true){
				            		alert('密码修改成功');
				            	}else{
				            		alert('原密码不正确');
				            	}       	
				            }
				        }); 
				}
			}
		</script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<br><br>
		<form action="">
		<table align="center">
			<tr>
				<td>管理员密码修改</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td>身份证ID：</td>
				<td><input type="text" id="identityId" value="${user.identityId}" readonly="readonly"/>
			</tr>
			<tr>
				<td>原密码：</td>
				<td><input type="password" id="oldPwd" name="oldPwd"/>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" id="newPwd" name="newPwd"/>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" id="againPwd" name="againPwd"/>
			</tr>
			<tr>
				<td><input type="button" value="修改" onclick="validateAndSave()"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
		</table>
		</form>
	</body>
</html>