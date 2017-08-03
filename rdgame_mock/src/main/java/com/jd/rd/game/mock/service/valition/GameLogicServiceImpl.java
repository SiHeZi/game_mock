package com.jd.rd.game.mock.service.valition;

import com.jd.rd.game.mock.dto.request.GameLogicReq;
import com.jd.rd.game.mock.service.ValtionService;
import com.jd.rd.game.mock.util.Const;
import com.jd.rd.game.mock.util.Constant;
import org.springframework.stereotype.Component;

/**
 * Created by zhaosiji on 2017/7/11.
 */
@Component(value = "gamelogic")
public class GameLogicServiceImpl implements ValtionService {


    @Override
    public boolean valtion(Object object,String pin) {

        GameLogicReq req=(GameLogicReq)object;
        if(req.getFeeType()!= Constant.GameLogic.feeType_jd.getCode()
                &&req.getFeeType()!= Constant.GameLogic.feeType_sd.getCode()){
            return false;
        }

        if(req.getTranType()!= Constant.GameLogic.tranType_bet.getCode()
                &&req.getTranType()!= Constant.GameLogic.tranType_nobet.getCode()){
            return false;
        }

        //TODO 特殊字段格式校验
        //1.游戏ID应该是0到9999之间的数值
       if(!(Long.valueOf(req.getGameID())<9999&&Long.valueOf(req.getGameID())>0)){
           return false;
       }


       //2.验证透传字段
//        if(!Const.getType(req.getGameRequest()).equals(Const.GAME_TYPE_STRING)){
//            return false;
//        }


        return true;
    }
}
