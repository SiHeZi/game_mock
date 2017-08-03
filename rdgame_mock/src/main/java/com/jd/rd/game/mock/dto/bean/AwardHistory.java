package com.jd.rd.game.mock.dto.bean;

/**
 * Created by zhaosiji on 2017/7/11.
 */
public class AwardHistory {

    private String uuid;

    private String received;

    private AwardHistoryData data;

    public String getUuid() {
        return uuid;
    }

    public String getReceived() {
        return received;
    }

    public AwardHistoryData getData() {
        return data;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public void setData(AwardHistoryData data) {
        this.data = data;
    }
}
