package com.wbgl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.wbgl.entity.Admin;
import com.wbgl.entity.CashFlow;
import com.wbgl.entity.User;
import com.wbgl.service.PublicService;

public class PublicServiceImpl extends SqlMapClientDaoSupport implements PublicService {

	public boolean userValidate(String identityId, String password, String type) {

		Map<String,String> map = new HashMap<String, String>();
		map.put("identityId", identityId);
		map.put("password", password);
		if("1".equals(type)){
			map.put("tableName", "tempuser");
		}else if("2".equals(type)){
			map.put("tableName", "vipuser");
		}else{
			map.put("tableName", "sysadmin");
		}
		int i = (Integer) getSqlMapClientTemplate().queryForObject("User.loginCheck",map);
		if(i>0)
			return true;
		return false;
	}

	public User getUserInfo(String identityId, String type) {
		if("1".equals(type)){
			return (User) getSqlMapClientTemplate().queryForObject("User.getTempUser",identityId);
		}
		return (User) getSqlMapClientTemplate().queryForObject("User.getVipUser",identityId);
	}

	public void updateUserLoginTime(String identityId, String type) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("identityId", identityId);
		if("1".equals(type)){
			map.put("tableName", "tempuser");
		}else if("2".equals(type)){
			map.put("tableName", "vipuser");
		}
		getSqlMapClientTemplate().update("User.updateLoginTime", map);
	}

	public Admin getAdminInfo(String identityId) {
		return (Admin) getSqlMapClientTemplate().queryForObject("User.getAdmin", identityId);
		
	}

	public boolean updatePwd(Map<String, String> map) {
		int i = getSqlMapClientTemplate().update("User.updatePwd", map);
		if(i>0)
			return true;
		return false;
	}

	//要是充值成功，记录写
	public boolean updateCash(Map<String, String> map) {
		String type = map.get("type");
		if("1".equals(type)){
			map.put("tableName", "tempuser");
		}else if("2".equals(type)){
			map.put("tableName", "vipuser");
		}
		int i = getSqlMapClientTemplate().update("User.updateCash", map);
		if(i>0){
			getSqlMapClientTemplate().update("User.insertCashFlow", map);
			return true;
		}
		return false;
	}

	public boolean updateLogoutCash(Map<String, String> map) {
		String type = map.get("type");
		if("1".equals(type)){
			map.put("tableName", "tempuser");
		}else if("2".equals(type)){
			map.put("tableName", "vipuser");
		}
		int i = getSqlMapClientTemplate().update("User.updateCash", map);
		if(i>0){
			getSqlMapClientTemplate().update("User.insertCustomCashFlow", map);
			return true;
		}
		return false;
	}
	public boolean insertUser(Map<String, String> map) {
		int i = 0;
		String type = map.get("type");
		if("1".equals(type)){
			i = getSqlMapClientTemplate().update("User.insertTempuser", map);
		}else if("2".equals(type)){
			i = getSqlMapClientTemplate().update("User.insertVipuser", map);
		}
		if(i>0){
			getSqlMapClientTemplate().update("User.insertCashFlow", map);
			return true;
		}
		return false;
	}
	
	//online Users
	public List<User> getOnlineTempUser() {
		List list = getSqlMapClientTemplate().queryForList("User.getOnlineTempUser");
		List<User> result = new ArrayList<User>();
		if (list.size() == 0) return null;
		for(int i = 0; i < list.size();i++){
			result.add((User)list.get(i));
		}
		return result;
	}

	public List<User> getOnlineVipUser() {
		List list = getSqlMapClientTemplate().queryForList("User.getOnlineVipUser");
		List<User> result = new ArrayList<User>();
		if (list.size() == 0) return null;
		for(int i = 0; i < list.size();i++){
			result.add((User)list.get(i));
		}
		return result;
	}

	public List<CashFlow> getCashFlow() {
		List list = getSqlMapClientTemplate().queryForList("User.getCashFlow");
		List<CashFlow> result = new ArrayList<CashFlow>();
		if (list.size() == 0) return null;
		for(int i = 0; i < list.size();i++){
			result.add((CashFlow)list.get(i));
		}
		return result;
	}

	//注销用户，设置登录状态为0
	public boolean updateLogoutStatus(Map<String, String> map) {
		String type = map.get("type");
		if("1".equals(type)){
			map.put("tableName", "tempuser");
		}else if("2".equals(type)){
			map.put("tableName", "vipuser");
		}
		int i = getSqlMapClientTemplate().update("User.updateLogoutStatus",map);
		if(i>0)
			return true;
		return false;
	}

	//删除临时用户
	public boolean deleteTempUser(Map<String, String> map) {
		if(map.get("identityId") == null){
			return false;
		}
		int i = getSqlMapClientTemplate().delete("User.deleteTempUser", map);
		if(i>0) return true;
		return false;
	}

	//充值vip用户账户余额
	public boolean resetVipCash(Map<String, String> map) {
		if(map.get("identityId") == null){
			return false;
		}
		int i = getSqlMapClientTemplate().update("User.resetVipCash", map);
		if(i>0) return true;
		return false;
	}

}
