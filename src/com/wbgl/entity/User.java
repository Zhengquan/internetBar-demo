package com.wbgl.entity;

import java.util.Date;

public class User {

	private String identityId;	//���֤��
	private String password;	//����
	private String isVip;		//�Ƿ�VIP
	private String vipCard;		//VIP�˺�
	private Double remain;		//���
	private String logged;		//�Ƿ��¼
	private String loggedTime;	//��¼ʱ��
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsVip() {
		return isVip;
	}
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}
	public String getVipCard() {
		return vipCard;
	}
	public void setVipCard(String vipCard) {
		this.vipCard = vipCard;
	}
	public Double getRemain() {
		return remain;
	}
	public void setRemain(Double remain) {
		this.remain = remain;
	}
	public String getLogged() {
		return logged;
	}
	public void setLogged(String logged) {
		this.logged = logged;
	}
	public String getLoggedTime() {
		return loggedTime;
	}
	public void setLoggedTime(String loggedTime) {
		this.loggedTime = loggedTime;
	}
	
	
}
