package com.wbgl.entity;

import java.util.Date;

public class CashFlow {
	
	private String id;
	
	private String identityId;	//���֤��
	
	private String loggedTime;	//��¼ʱ��
	
	private String logoutTime;	//�ǳ�ʱ��
	
	private String cashType;	//��¼���ͣ�1���ѣ�2��ֵ
	
	private double cash;		//���

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getLoggedTime() {
		return loggedTime;
	}

	public void setLoggedTime(String loggedTime) {
		this.loggedTime = loggedTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

}
