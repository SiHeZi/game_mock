package com.jd.rd.game.mock.dto.request;

/**
 * Created by zhaosiji on 2017/7/24.
 */
public class CouponAwardReq {

    //游戏id
    private Long gameID;
    //唯一验证信息
    private String key;

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
