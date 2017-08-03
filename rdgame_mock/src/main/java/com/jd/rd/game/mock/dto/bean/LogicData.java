package com.jd.rd.game.mock.dto.bean;

/**
 * Created by zhaosiji on 2017/7/11.
 */
public class LogicData {

    /**
     * 复奖uuid
     */
    private Long gameId=null;

    /**
     * 游戏id
     */
    private String uuid=null;
    /**
     * 中奖ID ,id为0或者空表示未中奖
     */
    private String awardId;

    /**
     * 奖品类型1:优惠券,2：实物 ，3：奖励京豆，4奖励神豆
     */
    private String awardType;
    /**
     * 奖品价格
     */
    private String awardPrice;
    /**
     *
     * */
    private String awardName;
    /**
     * 图片
     */
    private String awardImage;
    /**
     * 有效期
     */
    private String startTime;
    /**
     * 有效期
     */
    private String endTime;
    /**
     * 若为实物奖励 领取人名
     */
    private String userName;
    /**
     * 领取人联系方式
     */
    private String mobile;
    /**
     * 领取人地址
     */
    private String address;
    /**
     * 中奖日期
     */
    private String awardDate;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(String awardDate) {
        this.awardDate = awardDate;
    }
}
