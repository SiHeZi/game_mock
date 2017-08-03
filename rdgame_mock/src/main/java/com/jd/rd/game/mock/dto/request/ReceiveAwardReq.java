package com.jd.rd.game.mock.dto.request;

import com.alibaba.fastjson.JSON;

/**
 * 复奖级领取接口请求参数
 */
public class ReceiveAwardReq {

	/**
	 * 开奖时的唯一id
	 */
	private String uuid;

	/**
	 * 用户地址
	 */
	private String address;

	/**
	 * 用户姓名
	 */
	private String name;
	
	/**
	 * 用户pin
	 */
	private String userPin;

	/**
	 * 用户电话
	 */
	private String phone;

	/**
	 * 平台侧game id 用于不同换肤产品区分
	 */
	private Long gameID;

	public String getUserPin() {
		return userPin;
	}

	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getGameID() {
		return gameID;
	}

	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}



	public static void main(String[] args) {
		ReceiveAwardReq req=new ReceiveAwardReq();
		req.setUuid("333444");
		req.setAddress("");
		req.setGameID(1001L);
		req.setUserPin("testJd");
		req.setPhone("11122334");
		req.setName("test");
		System.out.println(JSON.toJSONString(req).replaceAll("\"","'"));
	}

}
