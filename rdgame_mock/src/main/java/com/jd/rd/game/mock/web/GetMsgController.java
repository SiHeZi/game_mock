package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.GameLogicReq;
import com.jd.rd.game.mock.dto.response.GameLogicRes;
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

/**
 * Created by zhaosiji on 2017/7/11.
 * 接口-游戏消息
 */
@Controller
public class GetMsgController {


    Logger logger = LoggerFactory.getLogger(GetMsgController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;

    @RequestMapping(value = "/gameMsg", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String gameMsg(HttpServletRequest request, HttpServletResponse response) {

        logger.info("interface gameMsg is start");

        String resMsg="";

        response.setHeader("Accept-Encoding", "gzip");
        if (request.getSession().getAttribute("pin") == null) {
            resMsg=Const.checkSessionMsg();
            return resMsg;
        }

        GameLogicRes res = new GameLogicRes();

        try {

            GameLogicReq gameLogicReq = new GameLogicReq();

            String sysType = Const.SYS_TYPE;

            String gameMsgUrl = Const.GAME_MSG_URL;

            logger.info("interface gameMsg is get Param is start,type:"+sysType);

            if (sysType.equals(Const.DATA__TEST)) {
                //流的方式读取
                String requsetStr = Const.read(request);
                gameLogicReq = JSON.parseObject(requsetStr.split("-")[0], GameLogicReq.class);
                gameMsgUrl = requsetStr.split("-")[1];
            } else {
                gameLogicReq.setGameID(Long.valueOf(request.getParameter("gameID")));
                gameLogicReq.setFeeType(Integer.valueOf(request.getParameter("feeType")));
                gameLogicReq.setTranType(Integer.valueOf(request.getParameter("tranType")));
                gameLogicReq.setExt(request.getParameter("ext"));
                gameLogicReq.setGameRequest(request.getParameter("gameRequest"));
            }

            logger.info("interface gameMsg is start,start call game system,url is:"+gameMsgUrl);

            res = appMainService.gameLogic(gameLogicReq, null, gameMsgUrl);

            logger.info("interface gameMsg call game system end");

            //响应是文件输出还是测试数据
            resMsg = Const.resMsg(res,dataType);

            response.setHeader("Accept-Encoding", "gzip");

            logger.info("interface gameMsg gameMsgUrl:"+gameMsgUrl+"-responseMsg:" + resMsg);

            return resMsg;

        } catch (Exception e) {
            logger.info("interface gameMsg is have a error"+e);
            e.printStackTrace();
            res.setReturnCode(-1);
            res.setReturnMsg("出现异常请查看控制台日志");
            return JSON.toJSONString(res);
        }
    }

}
