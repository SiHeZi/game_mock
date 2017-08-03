package com.jd.rd.game.mock;


import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.GameLogicReq;
import com.jd.rd.game.mock.util.HttpClientUtil;
import org.junit.Test;


public class HttpClientUtilTest {

    @Test
    public void testSendHttpPost2() {

        GameLogicReq logicReq = new GameLogicReq();
        logicReq.setTranType(0);
        logicReq.setFeeType(4);
        logicReq.setExt("xxx");
        logicReq.setGameID(1001L);
        logicReq.setGameRequest("游戏侧自定义");

        String param1 = JSON.toJSONString(logicReq);
        System.out.println(param1.replaceAll("\"","'"));

        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://localhost:8080/gameLogic",param1);
        System.out.println("reponse content:" + responseContent);
    }


    //@Test
    public void testSendHttpsGet() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpsGet("http://localhost:8080/login");
        System.out.println("reponse content:" + responseContent);
    }

}

