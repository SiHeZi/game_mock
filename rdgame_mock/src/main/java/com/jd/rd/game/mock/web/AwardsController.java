package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.CouponAwardReq;
import com.jd.rd.game.mock.dto.response.AwardHistoryRes;
import com.jd.rd.game.mock.dto.response.CouponAwardRes;
import com.jd.rd.game.mock.dto.response.RedBagRainRes;
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
 * 接口-复奖级历史查询
 */
@Controller
public class AwardsController {


    Logger logger = LoggerFactory.getLogger(AwardsController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;


    @RequestMapping(value = "/awards", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String awards(HttpServletRequest request, HttpServletResponse response) throws Exception {

        logger.info("interface awards is start");

        String resMsg="";
        response.setHeader("Accept-Encoding", "gzip");
        if (request.getSession().getAttribute("pin") == null) {
            resMsg=Const.checkSessionMsg();
            return resMsg;
        }

        AwardHistoryRes res = new AwardHistoryRes();

        String pin = request.getSession().getAttribute("pin").toString();

        try {

            String gameId = request.getParameter("gameID");

            logger.info("interface awards call appMainService.awards start");

            res = appMainService.awards(gameId, pin);

            resMsg=Const.resMsg(res,dataType);

            logger.info("interface awards,userPin"+pin+"responseMsg:" + resMsg);

            return resMsg;
        } catch (Exception e) {

            logger.info("interface awards is have a error"+e);
            e.printStackTrace();
            res.setReturnCode(-1);
            res.setReturnMsg("出现异常请查看控制台日志");
            return JSON.toJSONString(res);
        }

    }




}
