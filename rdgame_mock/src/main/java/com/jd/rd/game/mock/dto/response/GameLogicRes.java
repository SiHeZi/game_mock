package com.jd.rd.game.mock.dto.response;

import com.jd.rd.game.mock.dto.bean.ComplexResponse;

/**
 * Created by zhaosiji on 2017/7/11.
 */
public class GameLogicRes {


    //账户余额
    private Long balance;
    //返回码0 为成功 否则失败
    private int returnCode;
    //返回描述
    private String returnMsg;
    //复奖信息:这是一个对象 只有交易类型为1 （即下注）时 才会返回复奖信息
    private String gameResponse;

    private ComplexResponse complexResponse;

    public ComplexResponse getComplexResponse() {
        return complexResponse;
    }

    public void setComplexResponse(ComplexResponse complexResponse) {
        this.complexResponse = complexResponse;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

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
