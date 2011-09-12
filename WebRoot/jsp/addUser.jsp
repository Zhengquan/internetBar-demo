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
		
			function showVip(value){
				$("#type").val(value);
				if(value == '1'){
					document.getElementById("div_aa").style.display='none';
					document.getElementById("div_bb").style.display='none';
					setCheckedValue("vipRadio",false);
				}else{
					document.getElementById("div_aa").style.display='block';
					document.getElementById("div_bb").style.display='block';
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
			function checkAndSave(){
				var identityId = $("#identityId").val();
				var pwd = $("#pwd").val();
				var againPwd = $("#againPwd").val();
				var cash = $("#cash").val();
				var type = $("#type").val();
				var vipCard = $("#vipCard").val();
				if(identityId=='' || cash == '' || pwd == '' || againPwd == ''){
					alert('请填写完整');
				}else if(type=='2' && vipCard ==''){
					alert('请填写完整');
				}else if(pwd != againPwd){
					alert('密码确认不正确');
				}else if(isNaN(cash)){
					alert('金额必须为数字');
				}else{
					$.ajax({ 
				            async:false,
				            type:"post", 
				            contentType:"application/json", 
				            url:"addUser.htm?identityId="+identityId+"&cash="+cash+"&type="+type+"&pwd="+pwd+"&vipCard="+vipCard, 
				            data:"{}", 
				            dataType:"json", 
				            success:function(data){
				            	if(data == true){
				            		alert('添加成功');
				            	}else{
				            		alert('账号已存在');
				            	}       	
				            }
				        });
				}
			}
			
		</script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<br><br>
		<form action="addUser.htm" onsubmit="return checkAndSave()">
		<center><p>新建用户</p></center>
		<table align="center">
			<tr>
				<td>身份证ID：</td>
				<td><input type="text" id="identityId" name="identityId"/>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="pwd" name="pwd"/>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" id="againPwd" name="againPwd"/>
			</tr>
			<tr>
				<td>金额：</td>
				<td><input type="text" id="cash" name="cash"/>
			</tr>
			
				<tr>
					<td><div id="div_aa" style="display:none">会员卡号：</div></td>
					<td><div id="div_bb" style="display:none"><input type="text" id="vipCard" name="vipCard"/></div>
				</tr>
			
			<tr>
				<td colspan="2">
					<input type="hidden" id="type" value="1"/>
					<input type="radio" name="tempRadio" checked="checked" value="1" onclick="showVip('1')"/>临时用户&nbsp;&nbsp;&nbsp;
					<input type="radio" name="vipRadio" value="2" onclick="showVip('2')"/>会员用户
				</td>
			</tr>
			<tr>
				<td><input type="button" value="充值" onclick="checkAndSave()"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
		</table>
		</form>
	</body>
</html>