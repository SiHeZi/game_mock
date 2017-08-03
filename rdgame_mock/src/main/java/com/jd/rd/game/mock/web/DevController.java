package com.jd.rd.game.mock.web;

import com.alibaba.fastjson.JSON;
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
import javax.servlet.http.HttpSession;

/**
 * Created by zhaosiji on 2017/7/11.
 */
@Controller
public class DevController {


    Logger logger = LoggerFactory.getLogger(DevController.class);

    @Autowired
    AppMainService appMainService;

    @Value("${dataType}")
    private String dataType;

    /**登录保存session*/
    @RequestMapping(value = "/devLogin", method = RequestMethod.GET)
    public String jdLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        logger.info("devLogin is start");

        String pin = request.getParameter("username");

        String code = request.getParameter("password");

        session.setAttribute("pin", pin);
        //把userPin放入缓存中

        Const.init(pin);

        logger.info("devLogin success,user is" + pin + " password is:" + code);

        return "dev/success";

    }

    //测试页面
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "dev/test";
    }



    //游戏测试地址页面
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String gameUrl(HttpServletRequest request, HttpServletResponse response) {

        String gameUrl = request.getParameter("gameUrl");
        String gameLogicUrl = request.getParameter("gameLogicUrl");
        String getMsgUrl = request.getParameter("getMsgUrl");
        String sysType=request.getParameter("sysType");

        if (gameUrl == null || gameUrl.equals("")) {
            gameUrl = "/test";
        }

        if (!(gameLogicUrl == null || gameLogicUrl.equals(""))) {
            Const.GAME_URL=gameLogicUrl;
        }

        if (!(getMsgUrl == null || getMsgUrl.equals(""))) {
            Const.GAME_MSG_URL=getMsgUrl;
        }

        if (!(sysType == null || sysType.equals(""))) {
            Const.SYS_TYPE=sysType;
        }

        return "redirect:" +gameUrl;
    }

    //接口-通知渠道
    @RequestMapping(value = "/testUrl", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String testurl(HttpServletRequest request, HttpServletResponse response) {
        GameSystemRes res = new GameSystemRes();
        try {
            //返回错误码
            res.setReturnCode(0);
            res.setReturnMsg("ok");
            res.setGameResponse("游戏系统透传内容，游戏方自己定义");
            return JSON.toJSONString(res);
        } catch (Exception e) {
            //返回错误码
            e.printStackTrace();
            res.setReturnCode(-1);
            res.setReturnMsg("出现异常");
            return JSON.toJSONString(res);
        }
    }


}
