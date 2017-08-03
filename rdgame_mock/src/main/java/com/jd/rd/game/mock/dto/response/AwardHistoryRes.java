package com.jd.rd.game.mock.dto.response;

import com.jd.rd.game.mock.dto.bean.AwardHistory;

import java.util.List;

/**
 * Created by zhaosiji on 2017/7/11.
 */
public class AwardHistoryRes {

    private int returnCode;

    private String returnMsg;

    private List<AwardHistory> awardList;

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

    public List<AwardHistory> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<AwardHistory> awardList) {
        this.awardList = awardList;
    }
}
