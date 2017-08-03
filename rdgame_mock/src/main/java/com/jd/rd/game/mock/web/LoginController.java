package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.CouponAwardReq;
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

/**
 * Created by zhaosiji on 2017/7/11.
 * 接口-余额查询
 */
@Controller
public class LoginController {


    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;

    @RequestMapping(value = "/login", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {

        logger.info("interface login start");

        String resMsg="";
        response.setHeader("Accept-Encoding", "gzip");
        if (request.getSession().getAttribute("pin") == null) {
            resMsg=Const.checkSessionMsg();
            return resMsg;
        }

        LoginRes res = new LoginRes();
        String pin = request.getSession().getAttribute("pin").toString();
        res = appMainService.loginRes(pin);
        res.setAccountId(pin);
        resMsg = JSON.toJSONString(res);

        logger.info("interface login,responseMsg:" + resMsg+"-userPin:"+pin);

        return resMsg;
    }

}
