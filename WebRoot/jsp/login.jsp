<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<link rel="stylesheet" href="../css/main.css" type="text/css">
		<link rel="stylesheet" href="../css/tabs-no-images.css"
			type="text/css">
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<br><br>
		<form action="login.htm">
			<table align="center" bgColor="#ffffff">
				<tr>
					<td>身份证号：</td>
					<td><input type="text" name="identityId" style="width:120px"/></td>
				</tr>
				<tr>
					<td>密    码：</td>
					<td><input type="password" name="password" style="width:120px"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="radio" name="type" checked="checked" value="1"/>临时用户&nbsp;&nbsp;&nbsp;
						<input type="radio" name="type" value="2"/>会员用户&nbsp;&nbsp;&nbsp;
						<input type="radio" name="type" value="3"/>管理员
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>