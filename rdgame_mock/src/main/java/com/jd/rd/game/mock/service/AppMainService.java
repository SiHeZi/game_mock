package com.jd.rd.game.mock.service;

import com.jd.rd.game.mock.dto.request.CouponAwardReq;
import com.jd.rd.game.mock.dto.request.GameLogicReq;
import com.jd.rd.game.mock.dto.request.GameMessageReq;
import com.jd.rd.game.mock.dto.request.ReceiveAwardReq;
import com.jd.rd.game.mock.dto.response.*;

/**
 * Created by zhaosiji on 2017/7/11.
 */
public interface AppMainService {


    //余额查询
    public LoginRes loginRes(String pin);

    //游戏逻辑
    public GameLogicRes gameLogic(GameLogicReq gameLogicReq,String pin,String systemUrl);


    //复奖级实物领取
    public ReceiveAwardRes receiveAward(ReceiveAwardReq receiveAwardReq,String pin);

    //复奖级历史查询
    public AwardHistoryRes awards(String gameId,String pin);

    //红包雨
    public RedBagRainRes complexLevelAward(String pin);


    //消息
    public GameMessageRes gameMessage(GameMessageReq gameMessageReq,String url);


    //消息2
    public CouponAwardRes couponAward(CouponAwardReq couponAwardReq,String pin);

}
