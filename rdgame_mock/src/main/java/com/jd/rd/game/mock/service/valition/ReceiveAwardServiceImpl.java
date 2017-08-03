package com.jd.rd.game.mock.service.valition;

import com.jd.rd.game.mock.dto.request.ReceiveAwardReq;
import com.jd.rd.game.mock.service.ValtionService;
import com.jd.rd.game.mock.util.Const;
import org.springframework.stereotype.Component;

/**
 * Created by zhaosiji on 2017/7/11.
 */
@Component(value = "receiveAward")
public class ReceiveAwardServiceImpl implements ValtionService {

    @Override
    public boolean valtion(Object object,String pin) {

        ReceiveAwardReq req=(ReceiveAwardReq)object;

        if(Const.isImety(req.getUuid())){
            return false;
        }

        //是否是返回的uuid
        if(!req.getUuid().equals(Const.balanceMap.get(pin).getUuid())){
            return false;
        }

        //TODO 特殊字段格式校验
        //1.游戏ID应该是0到9999之间的数值
        if(!(Long.valueOf(req.getGameID())<9999&&Long.valueOf(req.getGameID())>0)){
            return false;
        }

        return true;
    }
}
