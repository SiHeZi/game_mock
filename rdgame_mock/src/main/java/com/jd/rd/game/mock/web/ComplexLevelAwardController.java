package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
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
 * 接口-红包雨
 */
@Controller
public class ComplexLevelAwardController {


    Logger logger = LoggerFactory.getLogger(ComplexLevelAwardController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;

    //
    @RequestMapping(value = "/complexLevelAward", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String complexLevelAward(HttpServletRequest request, HttpServletResponse response) {

        logger.info("interface complexLevelAward is start");

        String resMsg="";
        response.setHeader("Accept-Encoding", "gzip");
        if (request.getSession().getAttribute("pin") == null) {
            resMsg=Const.checkSessionMsg();
            return resMsg;
        }

        RedBagRainRes res = new RedBagRainRes();
        String pin = request.getSession().getAttribute("pin").toString();

        try {

            logger.info("interface complexLevelAward call appMainService.awards start");
            res = appMainService.complexLevelAward(pin);
            resMsg=JSON.toJSONString(res);
            logger.info("interface complexLevelAward,responseMsg:" + resMsg);

            return resMsg;
        } catch (Exception e) {
            logger.info("interface complexLevelAward is have a error"+e);
            e.printStackTrace();
            res.setReturnCode(-1);
            res.setReturnMsg("出现异常请查看控制台日志");
            return JSON.toJSONString(res);
        }

    }





}
