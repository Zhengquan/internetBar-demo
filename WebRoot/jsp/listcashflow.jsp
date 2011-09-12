<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>交易记录</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<center><p>交易记录</p></center>
		<table align="center" border="3px" bgColor="#e7f9fe">
			<tr>
	 			<td>身份证ID</td>
	 			<td>交易类型</td>
	 			<td>金额</td>
	 			<td>交易时间</td>
	 		</tr>
	 		<c:forEach var="item" items="${cashFlow}">
	 			<tr>
	 				<td><c:out value = "${item.identityId}"></c:out></td>
	 				<c:if test="${item.cashType == '1'}">
	 					<td>消费</td>
	 				</c:if>
	 				<c:if test="${item.cashType == '2'}">
	 					<td>充值</td>
	 				</c:if>
	 				<td><c:out value = "${item.cash}"></c:out></td>
	 				<c:if test="${item.cashType == '2'}">
	 					<td><c:out value = "${item.loggedTime}"></c:out></td>
	 				</c:if>
	 				<c:if test="${item.cashType == '1'}">
	 					<td><c:out value = "${item.logoutTime}"></c:out></td>
	 				</c:if>
	 			</tr>
	 		</c:forEach>
		</table>
	</body>	
</html>