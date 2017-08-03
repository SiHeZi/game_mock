package com.jd.rd.game.mock.domain;

import java.util.Map;

/**
 * Created by zhaosiji on 2017/7/13.
 */
public class Cache {

    private  Long balance;

    private Long gameId;

    private String uuid;

    //是否领取
    private boolean received;

    private Map<String,Boolean> map;

    public Map<String, Boolean> getMap() {
        return map;
    }

    public void setMap(Map<String, Boolean> map) {
        this.map = map;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
