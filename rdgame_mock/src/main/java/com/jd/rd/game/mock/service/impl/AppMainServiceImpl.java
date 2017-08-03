package com.jd.rd.game.mock.service.impl;

import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.*;
import com.jd.rd.game.mock.dto.response.*;
import com.jd.rd.game.mock.service.AppMainService;
import com.jd.rd.game.mock.service.ValtionService;
import com.jd.rd.game.mock.util.Const;
import com.jd.rd.game.mock.util.HttpClientUtil;
import com.jd.rd.game.mock.util.TestDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaosiji on 2017/7/11.
 */
@Service
public class AppMainServiceImpl implements AppMainService {
    Logger logger = LoggerFactory.getLogger(AppMainServiceImpl.class);


    @Autowired
    Map<String, ValtionService> valtionServiceMap;

    @Override
    public LoginRes loginRes(String pin) {

        LoginRes res = TestDataUtil.testLoginRes(pin);

        return res;
    }

    @Override
    public GameLogicRes gameLogic(GameLogicReq gameLogicReq, String pin, String systemUrl) {

        GameLogicRes res = new GameLogicRes();

        if (pin == null) {

            res.setReturnCode(0);

            res.setReturnMsg("ok");


            if (!systemUrl.equals("url")) {
                GameSystemLogicReq sysReq = converGameStstemReq(gameLogicReq, pin);
                String msg = JSON.toJSONString(sysReq);
                String responseContent = HttpClientUtil.getInstance()
                        .sendHttpPost(systemUrl, msg);
                GameSystemRes ressys = JSON.parseObject(responseContent, GameSystemRes.class);
                res.setGameResponse(ressys.getGameResponse());
                logger.info("透传发送地址:" + systemUrl + "-透传发送数据:" + msg+"-透传返回数据:" + ressys.getGameResponse());

            }

            return res;
        }


        ValtionService valtion = valtionServiceMap.get("gamelogic");

        //校验失败
        if (!valtion.valtion(gameLogicReq, pin)) {
            //返回错误码
            res.setReturnCode(-1);
            res.setReturnMsg("数据校验问题,请查看");
            return res;
        }

        //系统内部返回
        res = TestDataUtil.testGameLogicRes(gameLogicReq, pin);

        if (!systemUrl.equals("url")) {
            GameSystemLogicReq sysReq = converGameStstemReq(gameLogicReq, pin);
            String msg = JSON.toJSONString(sysReq);
            String responseContent = HttpClientUtil.getInstance()
                    .sendHttpPost(systemUrl, msg);
            GameSystemRes ressys = JSON.parseObject(responseContent, GameSystemRes.class);
            res.setGameResponse(ressys.getGameResponse());
            logger.info("透传发送地址:" + systemUrl + "-透传发送数据:" + msg+"-透传返回数据:" + ressys.getGameResponse());
        }
        return res;
    }

    @Override
    public ReceiveAwardRes receiveAward(ReceiveAwardReq receiveAwardReq, String pin) {

        ReceiveAwardRes res = new ReceiveAwardRes();

        int resultNum = 0;

        try {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("uuid", 50);
            map.put("phone", 13);
            resultNum = Const.baseValition(receiveAwardReq, map);
        } catch (Exception e) {

        }
        if (resultNum > 0) {
            //TODO 可以抛出异常
            res.setReturnCode(-1);
            res.setReturnMsg("失败");
            return res;
        }


        ValtionService valtion = valtionServiceMap.get("receiveAward");

        //校验失败
        if (!valtion.valtion(receiveAwardReq, pin)) {
            //返回错误码
            res.setReturnCode(-1);
            res.setReturnMsg("数据校验问题,请查看");
            return res;
        }

        res = TestDataUtil.testReceiveAwardRes();

        Const.balanceMap.get(pin).setReceived(true);

        return res;

    }

    @Override
    public AwardHistoryRes awards(String gameId, String pin) {
        AwardHistoryRes res = TestDataUtil.testAwardHistoryRes(gameId, pin);
        return res;
    }

    @Override
    public RedBagRainRes complexLevelAward(String pin) {
        RedBagRainRes res = TestDataUtil.testRedBagRainRes();
        return res;
    }

    @Override
    public GameMessageRes gameMessage(GameMessageReq gameMessageReq, String url) {

        GameMessageRes res = new GameMessageRes();

        try {
            if (!url.equals("url")) {
                GameSystemLogicReq sysReq = converGameStstemReq2(gameMessageReq, "");
                String msg = JSON.toJSONString(sysReq);
                String responseContent = HttpClientUtil.getInstance()
                        .sendHttpPost(url, msg);
                GameSystemRes ressys = JSON.parseObject(responseContent, GameSystemRes.class);

                res.setReturnCode(0);

                res.setReturnMsg("ok");

                res.setGameResponse(ressys.getGameResponse());

                logger.info("透传发送地址:" + url);
                logger.info("透传发送数据:" + msg);
                logger.info("透传返回数据:" + ressys.getGameResponse());

                return res;

            } else {
                res=TestDataUtil.testGameMessage();
                return res;
            }
        } catch (Exception e) {
            res.setReturnCode(-1);
            res.setReturnMsg("error");
            return res;
        }

    }

    @Override
    public CouponAwardRes couponAward(CouponAwardReq couponAwardReq,String pin) {

        CouponAwardRes res=new CouponAwardRes();

        res=TestDataUtil.testCouponAwardRes(String.valueOf(couponAwardReq.getGameID()),pin);

        return res;
    }


    private GameSystemLogicReq converGameStstemReq(GameLogicReq gameLogicReq, String userPin) {
        GameSystemLogicReq req = new GameSystemLogicReq();
        req.setGameID(gameLogicReq.getGameID());
        req.setExt(gameLogicReq.getExt());
        req.setTranType(gameLogicReq.getTranType());
        req.setUserPin(userPin);
        req.setFeeType(gameLogicReq.getFeeType());
        req.setGameRequest(gameLogicReq.getGameRequest());
        req.setGameSource(2);
        return req;

    }

    private GameSystemLogicReq converGameStstemReq2(GameMessageReq gameMessageReq, String userPin) {
        GameSystemLogicReq req = new GameSystemLogicReq();
        req.setGameID(gameMessageReq.getGameID());
        req.setExt(gameMessageReq.getExt());
        req.setTranType(gameMessageReq.getTranType());
        req.setUserPin(userPin);
        req.setFeeType(gameMessageReq.getFeeType());
        req.setGameRequest(gameMessageReq.getGameRequest());
        req.setGameSource(2);
        return req;

    }
}
