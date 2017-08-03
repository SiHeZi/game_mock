package com.jd.rd.game.mock.dto.request;

/**
 * Created by zhaosiji on 2017/7/13.
 */
public class GameSystemLogicReq {

    private Long gameID;

    private Integer feeType;

    private Integer tranType;

    private Integer gameSource;

    private String userPin;

    private String gameRequest;

    private String ext;

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public Integer getTranType() {
        return tranType;
    }

    public void setTranType(Integer tranType) {
        this.tranType = tranType;
    }

    public Integer getGameSource() {
        return gameSource;
    }

    public void setGameSource(Integer gameSource) {
        this.gameSource = gameSource;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public String getGameRequest() {
        return gameRequest;
    }

    public void setGameRequest(String gameRequest) {
        this.gameRequest = gameRequest;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
