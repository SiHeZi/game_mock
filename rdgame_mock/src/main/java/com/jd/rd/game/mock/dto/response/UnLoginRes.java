package com.jd.rd.game.mock.dto.response;

/**
 * Created by zhaosiji on 2017/8/3.
 */
public class UnLoginRes {

    private String returnCode;
    private String returnMsg;
    private String loginUrl;

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public String getLoginUrl() {
        return loginUrl;
    }
}
