<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户结账</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
			
		<script type="text/javascript">
			function showVip(value){
				$("#type").val(value);
				if(value == '1'){
					setCheckedValue("vipRadio",false);
				}else{
					setCheckedValue("tempRadio",false);
				}
			}
			
			function setCheckedValue(radioName, newValue) {
				if(!radioName) return;
				   var radios = document.getElementsByName(radioName);   
	  			 for(var i=0; i<radios.length; i++) {
	    		  	radios[i].checked = false;
	     			 if(radios[i].value == newValue.toString()) {
	      				radios[i].checked = true;
	   				}
      			  }
			}
			
			function checkOut(){
				var identityId = $("#identityId").val();
				var type = $("#type").val();
				if(identityId=='' ){
					alert('请填写完整');
				}else{
					$.ajax({ 
				            async:false,
				            type:"post", 
				            contentType:"application/json", 
				            url:"checkout.htm?identityId="+identityId+"&type="+type, 
				            data:"{}", 
				            dataType:"json", 
				            success:function(data){      
				            	var remain= data[0];
				            if(remain != 'false'){
				            	alert('结账成功，找零 :' + remain + '!');
				            }else{
				            	alert('用户未注销或者用户不存在！')
				            }
				            }
				        });
				}
			}
		</script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<center>
		<p>用户结账</p>
	</center>
	<form action="checkout.htm" onsubmit="return checkOut()">
		<table align="center">
			<tr>
				<td>身份证ID：</td>
				<td><input type="text" id="identityId" name="identityId"/>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" id="type" value="1"/>
					<input type="radio" name="tempRadio" checked="checked" value="1" onclick="showVip('1')"/>临时用户&nbsp;&nbsp;&nbsp;
					<input type="radio" name="vipRadio" value="2" onclick="showVip('2')"/>会员用户
				</td>
			</tr>
			<tr>
				<td><input type="button" value="结账" onclick="checkOut()"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
		</table>
		</form>
	</body>
</html>