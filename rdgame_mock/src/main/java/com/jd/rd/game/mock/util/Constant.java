package com.jd.rd.game.mock.util;


/**
 * Created by zhaosiji on 2017/7/12.
 */
public class Constant {


    public enum GameLogic{
        feeType_jd(1,"京豆"),
        feeType_sd(4,"神豆"),
        tranType_bet(1,"下注"),
        tranType_nobet(0,"非下注");
        private  int code;
        private  String msg;
        private GameLogic(int code, String msg) {
            this.code = code;
            this.msg=msg;
        }
        public int getCode() {
            return this.code;
        }
        public String getMsg(){
            return this.msg;
        }
    }

    public enum Result{
        success(0,"成功"),
        fail(-1,"失败"),
        error(-2,"重新请求");
        private  int code;
        private  String msg;
        private Result(int code, String msg) {
            this.code = code;
            this.msg=msg;
        }
        public int getCode() {
            return this.code;
        }
        public String getMsg(){
            return this.msg;
        }
    }
}
