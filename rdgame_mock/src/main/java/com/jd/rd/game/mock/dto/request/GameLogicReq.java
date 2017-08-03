package com.jd.rd.game.mock.dto.request;

/**
 * Created by zhaosiji on 2017/7/11.
 * 游戏逻辑请求接口
 */
public class GameLogicReq {

    /**
      * 游戏平台侧游戏id（京东内部约束ID）
      */
    private Long gameID;
    /**
     * 代币类型1 京豆 4 神豆
     * */
    private Integer feeType;
    /**
     * 交易类型0 非下注接口 1 下注接口
     * */
    private Integer tranType;
    /**
     * 游戏请求信息，游戏系统提供（透传）
     * */
    private String gameRequest;
    /**
     * 京东端扩展字段
     * */
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
