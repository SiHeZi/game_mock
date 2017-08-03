package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.CouponAwardReq;
import com.jd.rd.game.mock.dto.request.ReceiveAwardReq;
import com.jd.rd.game.mock.dto.response.AwardHistoryRes;
import com.jd.rd.game.mock.dto.response.CouponAwardRes;
import com.jd.rd.game.mock.dto.response.ReceiveAwardRes;
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
 * 接口-复奖级实物领取
 */
@Controller
public class ReceiveAwardController {


    Logger logger = LoggerFactory.getLogger(ReceiveAwardController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;

    @RequestMapping(value = "/receiveAward", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String receiveAward(HttpServletRequest request, HttpServletResponse response) {

        logger.info("interface receiveAward is start");

        String resMsg="";
        response.setHeader("Accept-Encoding", "gzip");
        if (request.getSession().getAttribute("pin") == null) {
            resMsg=Const.checkSessionMsg();
            return resMsg;
        }

        ReceiveAwardReq receiveAwardReq = new ReceiveAwardReq();
        ReceiveAwardRes res = new ReceiveAwardRes();
        String pin = request.getSession().getAttribute("pin").toString();
        String sysType = Const.SYS_TYPE;

        try {

            logger.info("interface receiveAward is get param start:"+pin);

            String reqStr = Const.read(request);
            if (sysType.equals(Const.DATA__TEST)) {
                receiveAwardReq = JSON.parseObject(reqStr, ReceiveAwardReq.class);
            } else {
                receiveAwardReq.setGameID(Long.valueOf(request.getParameter("gameID")));
                receiveAwardReq.setAddress(request.getParameter("address"));
                receiveAwardReq.setName(request.getParameter("name"));
                receiveAwardReq.setPhone(request.getParameter("phone"));
                receiveAwardReq.setUserPin(request.getParameter("userPin"));
                receiveAwardReq.setUuid(request.getParameter("uuid"));
            }

            logger.info("interface receiveAward is get param end:"+pin);


            res = appMainService.receiveAward(receiveAwardReq, pin);

            resMsg = JSON.toJSONString(res);

            logger.info("interface receiveAward,responseMsg:" + resMsg);
            return resMsg;
        } catch (Exception e) {
            logger.info("interface receiveAward is have a error"+e);
            e.printStackTrace();
            res.setReturnCode(-1);
            res.setReturnMsg("出现异常请查看控制台日志");
            return JSON.toJSONString(res);
        }
    }


}
