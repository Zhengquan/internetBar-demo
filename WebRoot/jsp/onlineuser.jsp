<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>在线用户</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	 <center><p>当前在线的临时用户</p></center>
	 <table align="center" border="3px" bgColor="#e7f9fe">
	 <tr>
	 	<td>身份证ID</td>
	 	<td>账户余额</td>
	 	<td>上机时间</td>
	 </tr>
	 <c:forEach var="item" items="${onlineTempUser}">
	 <tr>
	 	<td><c:out value = "${item.identityId}"></c:out></td>
	 	<td><c:out value = "${item.remain}"></c:out></td>
	 	<td><c:out value = "${item.loggedTime}"></c:out></td>
	 </tr>
	 </c:forEach>
	 </table>
	  <center><p>当前在线的VIP用户</p></center>
	   <table align="center" border="3px" bgColor="#edfefc">
	 <tr>
	 	<td>身份证ID</td>
	 	<td>账户余额</td>
	 	<td>上机时间</td>
	 	<td>会员卡号</td>
	 </tr>
	 <c:forEach var="item" items="${onlineVipUser}">
	 <tr>
	 	<td><c:out value = "${item.identityId}"></c:out></td>
	 	<td><c:out value = "${item.remain}"></c:out></td>
	 	<td><c:out value = "${item.loggedTime}"></c:out></td>
	 	<td><c:out value = "${item.vipCard}"></c:out></td>
	 </tr>
	 </c:forEach>
	 </table>
	</body>
</html>