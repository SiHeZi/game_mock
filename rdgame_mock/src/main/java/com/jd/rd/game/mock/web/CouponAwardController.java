package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.dto.request.CouponAwardReq;
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
 * 接口-优惠券复奖级
 */
@Controller
public class CouponAwardController {


    Logger logger = LoggerFactory.getLogger(CouponAwardController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;

    @RequestMapping(value = "/couponAward", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String couponAward(HttpServletRequest request, HttpServletResponse response) {

        logger.info("interface couponAward is start");

        String resMsg="";
        response.setHeader("Accept-Encoding", "gzip");
        if (request.getSession().getAttribute("pin") == null) {
            resMsg=Const.checkSessionMsg();
            return resMsg;
        }

        CouponAwardRes res = new CouponAwardRes();
        CouponAwardReq req = new CouponAwardReq();
        String pin = request.getSession().getAttribute("pin").toString();

        try {

            String sysType = Const.SYS_TYPE;
            if (sysType.equals(Const.DATA__TEST)) {
                //流的方式读取
                String reqStr = Const.read(request);
                req = JSON.parseObject(reqStr, CouponAwardReq.class);
            } else {
                req.setGameID(Long.valueOf(request.getParameter("gameID")));
                req.setKey(request.getParameter("key"));
            }

            logger.info("interface couponAward call appMainService.awards start");


            res = appMainService.couponAward(req, pin);
            resMsg = Const.resMsg(res, dataType);
            logger.info("interface couponAward,responseMsg:" + resMsg);
            return resMsg;

        } catch (Exception e) {
            logger.info("interface couponAward is have a error"+e);
            //返回错误码
            e.printStackTrace();
            res.setReturnCode(-1);
            res.setReturnMsg("出现异常请查看控制台日志");
            return JSON.toJSONString(res);
        }
    }


}
