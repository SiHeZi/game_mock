package com.jd.rd.game.mock.util;

import com.jd.rd.game.mock.dto.bean.AwardHistory;
import com.jd.rd.game.mock.dto.bean.AwardHistoryData;
import com.jd.rd.game.mock.dto.bean.ComplexResponse;
import com.jd.rd.game.mock.dto.bean.LogicData;
import com.jd.rd.game.mock.dto.request.GameLogicReq;
import com.jd.rd.game.mock.dto.response.*;

import java.util.*;

/**
 * Created by zhaosiji on 2017/7/11.
 */
public class TestDataUtil {

    public static GameLogicRes testGameLogicRes(GameLogicReq gameLogicReq,String pin) {

        GameLogicRes res = new GameLogicRes();

        String uuid=String.valueOf(new Date().getTime());
        Const.balanceMap.get(pin).setUuid(uuid);
        Const.balanceMap.get(pin).setGameId(gameLogicReq.getGameID());

        //状态码设置
        res.setReturnMsg(Constant.Result.success.getMsg());
        res.setReturnCode(Constant.Result.success.getCode());

        //账户余额
        res.setBalance(Const.balanceMap.get(pin).getBalance());
        res.setGameResponse("游戏自己定义");

        //非下注接口时直接返回
        if(gameLogicReq.getTranType()==0){
            ComplexResponse c = new ComplexResponse();
            LogicData d = new LogicData();
            c.setUuid("null");
            d.setGameId(Const.balanceMap.get(pin).getGameId());
            d.setUuid("null");
            //中奖ID ,id为0或者空表示未中奖
            d.setAwardId("null");
            //奖品类型1:优惠券,2：实物 ，3：奖励京豆，4奖励神豆
            d.setAwardType("null");
            //奖品价格
            d.setAwardPrice("null");
            //奖品名称
            d.setAwardName("null");
            d.setAwardImage("null");
            d.setStartTime("null");
            d.setEndTime("null");
            d.setUserName(pin);
            d.setMobile("13400000000");
            d.setAddress("null");
            d.setAwardDate("null");
            c.setData(d);
            res.setComplexResponse(c);
            return res;
        }
        ComplexResponse c = new ComplexResponse();
        LogicData d = new LogicData();
        c.setUuid(Const.balanceMap.get(pin).getUuid());
        d.setGameId(Const.balanceMap.get(pin).getGameId());
        d.setUuid(Const.balanceMap.get(pin).getUuid());
        //中奖ID ,id为0或者空表示未中奖
        d.setAwardId("0");
        //奖品类型1:优惠券,2：实物 ，3：奖励京豆，4奖励神豆
        Random random=new java.util.Random();// 定义随机类
        int result=random.nextInt(4)+1;// 返回[0,5)集合中的整数，注意不包括10
        d.setAwardType(String.valueOf(result));
        //奖品价格
        d.setAwardPrice("100");
        //奖品名称
        d.setAwardName(Const.getAwartName(result));
        d.setAwardImage("图片地址");
        d.setStartTime(Const.getDateStr(new Date()));
        d.setEndTime(Const.getDateStr(new Date()));
        d.setUserName(pin);
        d.setMobile("13400000000");
        d.setAddress("null");
        d.setAwardDate(Const.getDateStr(new Date()));
        c.setData(d);
        res.setComplexResponse(c);
        return res;
    }


    public static LoginRes testLoginRes(String pin) {

        LoginRes login = new LoginRes();

        login.setAccountId(pin);

        login.setReturnCode("0");
        //用户账户数据
        login.setBalance(Const.balanceMap.get(pin).getBalance());
        login.setReturnMsg("响应成功");
        login.setUserPhoto("null");
        return login;
    }


    public static ReceiveAwardRes testReceiveAwardRes() {
        ReceiveAwardRes res = new ReceiveAwardRes();
        res.setReturnCode(0);
        res.setReturnMsg("响应成功");
        return res;
    }

    public static AwardHistoryRes testAwardHistoryRes(String gameId, String pin) {
        AwardHistoryRes res = new AwardHistoryRes();
        res.setReturnMsg(Constant.Result.success.getMsg());
        res.setReturnCode(Constant.Result.success.getCode());

        List<AwardHistory> list = new ArrayList<AwardHistory>();

        AwardHistory h1 = new AwardHistory();

        AwardHistoryData d1 = new AwardHistoryData();

        h1.setUuid(Const.balanceMap.get(pin).getUuid());

        h1.setReceived(String.valueOf(Const.balanceMap.get(pin).isReceived()));


        d1.setAddress("北京市东城区****");
        d1.setGameId(Long.valueOf(gameId));
        d1.setAwardDate(Const.getDateStr(new Date()));
        d1.setAwardName("test");
        d1.setMobile("13400000000");
        d1.setEndTime(Const.getDateStr(new Date()));
        d1.setAwardId("test01");
        //奖品类型1:优惠券,2：实物 ，3：奖励京豆，4奖励神豆
        Random random=new java.util.Random();// 定义随机类
        int result=random.nextInt(4)+1;// 返回[0,5)集合中的整数，注意不包括10
        d1.setAwardType(String.valueOf(result));
        d1.setUserName("中文");
        d1.setStartTime(Const.getDateStr(new Date()));
        d1.setAwardPrice("300");
        d1.setUuid(Const.balanceMap.get(pin).getUuid());
        d1.setAwardImage("图片地址");

        h1.setData(d1);
        list.add(h1);

        AwardHistory h2 = new AwardHistory();
        AwardHistoryData d2 = new AwardHistoryData();

        h2.setUuid("11112222333");
        h2.setReceived("true");

        d2.setAddress("1");
        d2.setGameId(1001L);
        d2.setAwardDate(Const.getDateStr(new Date()));
        d2.setAwardName("test");
        d2.setMobile("12344556677");
        d2.setEndTime(Const.getDateStr(new Date()));
        d2.setAwardId("1111");
        Random random1=new java.util.Random();// 定义随机类
        int result1=random.nextInt(4)+1;// 返回[0,5)集合中的整数，注意不包括10
        d1.setAwardType(String.valueOf(result1));
        d2.setUserName("test");
        d2.setStartTime(Const.getDateStr(new Date()));
        d2.setAwardPrice("300");
        d2.setUuid("11112222333");
        d2.setAwardImage("2223");

        h2.setData(d2);
        list.add(h2);

        res.setAwardList(list);
        return res;
    }


    public static RedBagRainRes testRedBagRainRes() {

        RedBagRainRes res = new RedBagRainRes();
        res.setAddress("北京市东城区***");
        res.setAwardDate(new Date());
        res.setAwardId("test02");
        res.setAwardImage("");
        res.setAwardName("红包雨");
        res.setAwardPrice("3000");
        Random random=new Random();// 定义随机类
        int aid=random.nextInt(2);// 返回[0,5)集合中的整数，注意不包括10

        res.setAwardStatus(String.valueOf(aid));
        if(aid!=0){
            Random random1=new Random();// 定义随机类
            int result=random1.nextInt(4)+1;// 返回[0,5)集合中的整数，注意不包括10
            res.setAwardType(String.valueOf(result));

            res.setComlexAwardLevel(0);
            res.setComplexId(1);
            res.setComplexLevelDetailId(1L);
            res.setComplexLevelDetailName("test");
            res.setComplexName("test");
            res.setEndTime(Const.getDateStr(new Date()));
            res.setGameId(1001L);
            res.setMobile("13400000000");
            res.setPart(true);
            res.setAwardImage("图片地址");
            res.setUserName("testuser");
            res.setUuid("123456789");
            res.setReturnMsg("成功");
            res.setStartTime("110011112233");
        }
        else{
            res.setAwardType(String.valueOf("null"));
            res.setComlexAwardLevel(0);
            res.setComplexId(0);
            res.setComplexLevelDetailId(0L);
            res.setComplexLevelDetailName("null");
            res.setComplexName("null");
            res.setEndTime("null");
            res.setGameId(1001L);
            res.setMobile("null");
            res.setPart(false);
            res.setAwardImage("");
            res.setUserName("null");
            res.setUuid("null");
            res.setReturnMsg("成功");
            res.setStartTime("110011112233");
        }

        return res;
    }


    public static GameMessageRes testGameMessage() {

        GameMessageRes res = new GameMessageRes();

        res.setReturnCode(0);

        res.setReturnMsg("ok");

        res.setGameResponse("游戏方自己透传内容");

        return res;
    }


    public static CouponAwardRes testCouponAwardRes(String gameId,String pin) {

        CouponAwardRes res = new CouponAwardRes();
        //奖品类型1:优惠券,2：实物 ，3：奖励京豆，4奖励神豆
        Random random=new java.util.Random();// 定义随机类
        int result=random.nextInt(4)+1;// 返回[0,5)集合中的整数，注意不包括10
        res.setAddress("北京市东城区****");
        res.setGameId(gameId);
        res.setAwardDate(new Date());
        res.setAwardName("test");
        res.setMobile("13400000000");
        res.setEndTime(Const.getDateStr(new Date()));
        res.setAwardId("test01");
        res.setAwardType(String.valueOf(result));
        res.setUserName("中文");
        res.setStartTime(Const.getDateStr(new Date()));
        res.setAwardPrice("300");
        res.setUuid(Const.balanceMap.get(pin).getUuid());
        res.setAwardImage("图片地址");
        res.setUuid("3333333333331111");
        res.setComlexAwardLevel(0);
        res.setComplexLevelDetailId(1L);
        res.setComplexId(1);
        res.setComplexName("test");
        res.setReturnCode(0);
        res.setReturnMsg("ok");
        res.setAwardStatus("success");

        return res;
    }
    public static void main(String[] args) {

    }

}
