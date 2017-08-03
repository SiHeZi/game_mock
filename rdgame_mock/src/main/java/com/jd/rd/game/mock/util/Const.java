package com.jd.rd.game.mock.util;


import com.alibaba.fastjson.JSON;
import com.jd.rd.game.mock.domain.Cache;

import java.io.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.jd.rd.game.mock.dto.response.UnLoginRes;
import org.json.JSONException;
import org.json.JSONObject;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class Const {
    static Logger logger = LoggerFactory.getLogger(Const.class);

    public static String responseUrl="E:\\reponse.txt";

    public static Long gameId = 500L;
    public static String GAME_TYPE_NUMBER = "NUMBER";
    public static String GAME_TYPE_JSON = "JSON";
    public static String GAME_TYPE_STRING = "STRING";
    public static String GAME_TYPE_XML = "XML";
    public static String DATA__FILE = "FILE";
    public static String DATA__TEST = "TEST";


    //游戏系统gameLogic的URL
    public static String GAME_URL="http://localhost:8181/testUrl";
    //游戏系统getMsgUrl
    public static String GAME_MSG_URL="http://localhost:8181/testUrl";

    //TEST(测试页面游戏系统)和GAME(游戏系统)
    public static String SYS_TYPE="TEST";



    public static Map<String, Cache> balanceMap = new HashMap<String, Cache>();

    //初始换存信息
    public static void init(String pin) {
        //缓存信息初始化,按照每一个用户初始化一个缓存信息
        Map<String, Cache> cache = new HashMap<String, Cache>();
        //缓存初始化
        Cache c1 = new Cache();
        c1.setBalance(10000000L);
        cache.put(pin, c1);
        balanceMap = cache;
    }


    public static String getDateStr(Date date) {

        if (date == null) {

            return "";
        }

        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        return df.format(date);

    }

    public static String getAwartName(Integer awardType) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "优惠券");
        map.put(2, "实物");
        map.put(3, "奖励京豆");
        map.put(4, "奖励神豆");
        return map.get(awardType);
    }

    /**
     * 判断为空
     * */
    public static boolean isImety(String str) {

        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 利用反射校验数据长度和数据值得校验
     *
     * @param object 校验对象
     * @param map    特殊化校验比如某些值有特定长度
     *               K:属性值
     *               V:该方法只是用了长度
     *               该方法可扩展:若果是对象类型递归再次解析其中的值
     *               该处可以是一个校验实体类(长度,大小,格式等属性)
     *               当调用时list时候要获取利用泛型转换,在递归调用
     */
    public static int baseValition(Object object, Map<String, Integer> map) throws Exception {

        Class c = object.getClass();
        //得到属性
        Field[] fs = c.getDeclaredFields();

        for (int i = 0; i < fs.length; i++) {

            Field f = fs[i];
            //设置些属性是可以访问的
            f.setAccessible(true);
            //得到此属性的类型
            String type = f.getType().toString();
            //得到属性名称
            String name = f.getName();
            Object val = new Object();
            //获取属性值
            val = f.get(object);

            if (type.endsWith("String")) {
                //判断长度
                // if(val!=null&&val.toString().length()>30){

                //实际长度大于理论长度的话
                if (map != null && map.get(name) != null && map.get(name) < val.toString().length()) {

                    System.out.println("名称：" + name + "属性值:" + val + "类型:" + type);

                    return 1;
                    //    }
                }
            } else if (type.endsWith("Long")) {

            }

        }

        return 0;
    }


    public static String getType(String string) {
        if (isNumber(string))
            return Const.GAME_TYPE_NUMBER;
        else if (isJson(string))
            return Const.GAME_TYPE_JSON;
        else if (isXML(string))
            return Const.GAME_TYPE_XML;
        else
            return Const.GAME_TYPE_STRING;
    }


    /**
     * 判断字符串是否是数字
     */
    public static boolean isNumber(String value) {
        return isInteger(value) || isDouble(value);
    }

    /**
     * 判断字符串是否是整数
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是浮点数
     */
    public static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            if (value.contains("."))
                return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断是否是json结构
     */
    public static boolean isJson(String value) {
        try {
            new JSONObject(value);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否是xml结构
     */
    public static boolean isXML(String value) {
        try {
            DocumentHelper.parseText(value);
        } catch (DocumentException e) {
            return false;
        }
        return true;
    }


    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static String readTxtFile(String filePath) {
        try {
            StringBuffer str = new StringBuffer();
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    str.append(lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
            return str.toString();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();

        }
        return null;

    }

    /**
     * 读取文件
     */
    public static String readFile(String filePath) {
        String resMsg = "";
        if (filePath != null) {
            resMsg = readTxtFile(filePath);
        } else {
            resMsg = readTxtFile(responseUrl);
        }
        return resMsg;
    }


    //检查压缩方式校验
    public static boolean checkEncoding(String encode) {

        if (encode.contains("gzip")) {
            return true;
        }
        return false;
    }


    public static String resMsg(Object object,String type){
        String  resMsg="";
        if (type.equals(Const.DATA__FILE)) {
             resMsg = Const.readFile(null);
        } else {
             resMsg = JSON.toJSONString(object);
        }
        return resMsg;
    }

    /**
     * 读取数据
     */
    public static  String read(HttpServletRequest request) throws IOException {
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer buffer = new StringBuffer();
            int n;
            while ((n = reader.read()) != -1) {
                buffer.append((char) n);
            }
            return buffer.toString().replaceAll("'", "\"");
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static String checkSessionMsg(){
        logger.info("用户未登录，请登录后测试");
        UnLoginRes res=new UnLoginRes();
        res.setLoginUrl("https://m.jd.com/user/login.action?returnurl=null");
        res.setReturnCode("3");
        res.setReturnMsg("用户未登录");
        return JSON.toJSONString(res);
    }

    public static void main(String[] args) throws Exception {
//        String filePath = "E:\\test.txt";
//        System.out.println(readTxtFile(filePath));
        //  String k=Resources.getClassLoader().getResource("config/response/reponse.txt").toString();

    //    System.out.println(readFile(responseUrl));

}

}
