package com.jd.rd.game.mock.dto.response;

import java.util.Date;

/**
 * Created by zhaosiji on 2017/7/24.
 */
public class CouponAwardRes {

    private int returnCode;
    private String returnMsg;
    private String gameId;
    private String uuid;
    private Integer complexId;
    private String complexName;
    private Long complexLevelDetailId;
    private String complexLevelDetailName;
    private int comlexAwardLevel;
    private String awardId;
    private String awardType;//  奖品类型1  :优惠券,2：实物，3：奖励京豆，4奖励神豆
    private String awardPrice;//奖品价格
    private String awardName;// 奖品名称
    private String awardImage;//
    private String startTime;//有效期
    private String endTime;
    private String userName;
    private String mobile; //  （若为实物奖励）领取人联系方式
    private String address;//（若为实物奖励）领取人地址
    private Date awardDate;//中奖日期
    private String awardStatus;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getComplexId() {
        return complexId;
    }

    public void setComplexId(Integer complexId) {
        this.complexId = complexId;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public Long getComplexLevelDetailId() {
        return complexLevelDetailId;
    }

    public void setComplexLevelDetailId(Long complexLevelDetailId) {
        this.complexLevelDetailId = complexLevelDetailId;
    }

    public String getComplexLevelDetailName() {
        return complexLevelDetailName;
    }

    public void setComplexLevelDetailName(String complexLevelDetailName) {
        this.complexLevelDetailName = complexLevelDetailName;
    }

    public int getComlexAwardLevel() {
        return comlexAwardLevel;
    }

    public void setComlexAwardLevel(int comlexAwardLevel) {
        this.comlexAwardLevel = comlexAwardLevel;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public String getAwardPrice() {
        return awardPrice;
    }

    public void setAwardPrice(String awardPrice) {
        this.awardPrice = awardPrice;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardImage() {
        return awardImage;
    }

    public void setAwardImage(String awardImage) {
        this.awardImage = awardImage;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(Date awardDate) {
        this.awardDate = awardDate;
    }

    public String getAwardStatus() {
        return awardStatus;
    }

    public void setAwardStatus(String awardStatus) {
        this.awardStatus = awardStatus;
    }
}
