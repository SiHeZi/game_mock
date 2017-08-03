package com.jd.rd.game.mock.dto.bean;

/**
 * Created by zhaosiji on 2017/7/11.
 */
public class ComplexResponse {

    /**
     * uuid
     * */
    private  String uuid;

    /**
     * 数据Data
     * */
    private LogicData data;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LogicData getData() {
        return data;
    }

    public void setData(LogicData data) {
        this.data = data;
    }
}
