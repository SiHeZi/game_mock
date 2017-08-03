package com.jd.rd.game.mock.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaosiji on 2017/7/24.
 */
public class JingCaiUtil {


    public static void main(String[] args) {

        double[] max = new double[3];

        double[] min = new double[3];

        //胜平负
        Map<String, Double> spfMap = new HashMap<String, Double>();
        spfMap.put("0", 2.03);
        spfMap.put("1", 4.34);
        spfMap.put("3", 6.03);


        //让球
        Map<String, Double> rqMap = new HashMap<String, Double>();
        spfMap.put("0", 2.03);
        spfMap.put("1", 4.34);
        spfMap.put("3", 6.03);


        //比分
        Map<String, Double> bfMap = new HashMap<String, Double>();
        bfMap.put("1:2", 2.01);


        //上半全场
        Map<String, Double> bqcMap = new HashMap<String, Double>();
        bfMap.put("01", 2.01);


        //进球数
        Map<String, Double> jqsMap = new HashMap<String, Double>();
        bfMap.put("1", 2.01);

    }

       public static double min() {
         return 0;
     }
}
