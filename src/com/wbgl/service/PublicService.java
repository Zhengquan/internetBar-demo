package com.wbgl.service;

import java.util.List;
import java.util.Map;

import com.wbgl.entity.Admin;
import com.wbgl.entity.User;
import com.wbgl.entity.CashFlow;

public interface PublicService {

	public boolean userValidate(String identityId,String password,String type);
	
	public User getUserInfo(String identityId,String type);
	
	public void updateUserLoginTime(String identityId,String type);
	
	public Admin getAdminInfo(String identityId);
	
	public boolean updatePwd(Map<String, String> map);
	
	public boolean updateCash(Map<String, String> map);
	
	public boolean updateLogoutCash(Map<String,String> map);
	
	public boolean updateLogoutStatus(Map<String,String> map);
	
	public boolean insertUser(Map<String,String> map);
	
	public boolean resetVipCash(Map<String, String> map);
	
	public boolean deleteTempUser(Map<String, String> map);
	
	public List<User> getOnlineTempUser();
	
	public List<User> getOnlineVipUser();
	
	public List<CashFlow> getCashFlow();
}
