package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.CouponAwardReq;
import com.jd.rd.game.mock.dto.request.GameLogicReq;
import com.jd.rd.game.mock.dto.request.ReceiveAwardReq;
import com.jd.rd.game.mock.dto.response.*;
import com.jd.rd.game.mock.service.AppMainService;
import com.jd.rd.game.mock.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by zhaosiji on 2017/7/11.
 * 接口-游戏逻辑
 */
@Controller
public class GameLogicController {


    Logger logger = LoggerFactory.getLogger(GameLogicController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;

    @RequestMapping(value = "/gameLogic", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String gameLogic(HttpServletRequest request, HttpServletResponse response) {

        logger.info("interface gameLogic is start");

        String resMsg="";

        response.setHeader("Accept-Encoding", "gzip");
        if (request.getSession().getAttribute("pin") == null) {
            resMsg=Const.checkSessionMsg();
            return resMsg;
        }

        GameLogicRes res = new GameLogicRes();

        String pin = request.getSession().getAttribute("pin").toString();

        try {

            String sysType = Const.SYS_TYPE;

            String gameUrl = Const.GAME_URL;

            GameLogicReq gameLogicReq = new GameLogicReq();

            logger.info("interface gameLogic is get Param is start,type:"+sysType);

            if (sysType.equals(Const.DATA__TEST)) {
                //测试页面以流的方式读取
                String requsetStr = Const.read(request);
                gameLogicReq = JSON.parseObject(requsetStr.split("-")[0], GameLogicReq.class);
                gameUrl = requsetStr.split("-")[1];

            } else {
                //游戏系统以表单参数方式读取
                gameLogicReq.setGameID(Long.valueOf(request.getParameter("gameID")));
                gameLogicReq.setFeeType(Integer.valueOf(request.getParameter("feeType")));
                gameLogicReq.setTranType(Integer.valueOf(request.getParameter("tranType")));
                gameLogicReq.setExt(request.getParameter("ext"));
                gameLogicReq.setGameRequest(request.getParameter("gameRequest"));
            }

            logger.info("interface gameLogic is get Param is end,start call game system,url is:"+gameUrl);

            res = appMainService.gameLogic(gameLogicReq, pin, gameUrl);

            logger.info("interface gameLogic call game system end");

            //响应是文件输出还是测试数据
            resMsg = Const.resMsg(res,dataType);

            response.setHeader("Accept-Encoding", "gzip");

            logger.info("interface gameLogic,userPin:"+pin+"-gameLogicUrl:"+gameUrl+"-responseMsg:" + resMsg);

            return resMsg;

        } catch (Exception e) {
            logger.info("interface gameLogic is have a error"+e);
            //返回错误码
            e.printStackTrace();
            res.setReturnCode(-1);
            res.setReturnMsg("出现异常请查看控制台日志");
            return JSON.toJSONString(res);
        }
    }


}
