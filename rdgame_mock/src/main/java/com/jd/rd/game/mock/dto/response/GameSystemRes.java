package com.jd.rd.game.mock.dto.response;

/**
 * Created by zhaosiji on 2017/7/13.
 * 游戏系统
 */
public class GameSystemRes {

    private int returnCode;
    private String returnMsg;
    private String gameResponse;

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

    public String getGameResponse() {
        return gameResponse;
    }

    public void setGameResponse(String gameResponse) {
        this.gameResponse = gameResponse;
    }
}
