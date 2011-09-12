<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>充值</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" >
		
			function setType(value){
				$("#type").val(value);
				if(value == '1') {
					setCheckedValue("vipUser",false);
				}
				if(value == '2') {
					setCheckedValue("tempUser",false)
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
			function checkAndUpdate(){
				var cash = $("#cash").val();
				var identityId = $("#identityId").val();
				var type = $("#type").val();
				if(identityId=='' || cash == ''){
					alert('请填写完整');
				}else if(isNaN(cash)){
					alert('金额必须为数字');
				}else{
					$.ajax({ 
				            async:false,
				            type:"post", 
				            contentType:"application/json", 
				            url:"cashAdd.htm?identityId="+identityId+"&cash="+cash+"&type="+type, 
				            data:"{}", 
				            dataType:"json", 
				            success:function(data){
				            	if(data == true){
				            		alert('充值成功');
									var cash = $("#cash").val('');
									var identityId = $("#identityId").val('');
				            	}else{
				            		alert('账号不存在');
				            	}       	
				            }
				        });
				
				}
			}
			
		</script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<br><br>
		<table align="center" bgColor="#ffffff">
			<tr>
				<td>身份证ID：</td>
				<td><input type="text" id="identityId" name="identityId"/>
			</tr>
			<tr>
				<td>充值金额：</td>
				<td><input type="text" id="cash" name="cash"/>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" id="type" value="1"/>
					<input type="radio" name="tempUser" checked="checked" onclick="setType('1')"/>临时用户&nbsp;&nbsp;&nbsp;
					<input type="radio" name="vipUser" onclick="setType('2')"/>会员用户
				</td>
			</tr>
			<tr>
				<td><input type="button" value="充值" onclick="checkAndUpdate()"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
		</table>
	</body>
</html>