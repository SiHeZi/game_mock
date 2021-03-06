<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>接口测试页面</title>
</head>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">


    var code = "http://localhost:8181/";
    var codeurl = "http://localhost:8181/";
    var url = "http://localhost:8181/"

    var i = 1;

    if (i == 1) {
        url = "http://localhost:8181/"
        code = "http://localhost:8181/";
        codeurl = "http://localhost:8181/";
        callbackurl="http://localhost:8181/testurl"
    } else {
        code = "http://localhost:8181/";
        codeurl = "http://zsjtest.tunnel.qydev.com/";
        url = "http://zsjtest.tunnel.qydev.com/";
        callbackurl="http://zsjtest.tunnel.qydev.com/testurl"

    }

    function createLottery() {
        var mydata = $("#mydata").val();
        var urlstr = $("#url").val();
        var method = $("#method").val();
        var callurl = $("#callurl").val();

        var myselect = document.getElementById("interface");
        var index = myselect.selectedIndex;
        var s = myselect.options[index].value;
        var logic=0;
        if (s == 2||s==6||s==7) {
            logic=1;
            if ((callurl == '' || callurl == null)) {
                mydata = mydata + "-url";
            } else {
                mydata = mydata + "-" + callurl;
            }
        }
        //alert("数据：" + mydata + " 方法名：" + method + " 地址：" + urlstr)
        $.ajax({
            type: method,
            contentType: 'application/json',
            url: urlstr,
            processData: false,
            dataType: 'json',
            headers: {'Accept-Encoding': 'gzip'},
            data: mydata,
            success: function (data) {

                if(logic==1){
                    mydata=mydata.split("-")[0];
                }
                //session判断
                // alert(JSON.stringify(data));
                // alert(JSON.stringify(data).indexOf(code) >= 0)
                if (JSON.stringify(data).indexOf(code) >= 0) {
                    window.location = codeurl+"index.jsp";
                }
                $("#request").html(
                    "<h4 style='word-wrap:break-word;'>请求地址: " + urlstr + "</h4><br/><h4>请求数据:"
                    + mydata + "</h4>");
                $("#result").html(
                    "<h4 style='word-wrap:break-word;'>响应数据: " + JSON.stringify(data) + "</h4>")

            },
            error: function () {

            }
        });
    }


    function setlectinterface(i) {

        var k = i;
        if (k == 1) {
            document.getElementById("mydata").value = "";
            document.getElementById("url").value = url + "login?feeType=4";
            document.getElementById("method").value = "GET";
            document.getElementById("callurl").style.display = "none";
            document.getElementById("callurl").style.width = "900px";
        }
        if (k == 2) {
            var data = "{'ext':'xxx','feeType':4,'gameID':1001,'gameRequest':'游戏侧自定义','tranType':0}"
            document.getElementById("mydata").value = data;
            document.getElementById("url").value = url + "gameLogic";
            document.getElementById("method").value = "POST";
            document.getElementById("callurl").style.display = "inline";
            document.getElementById("callurl").style.width = "900px";
            document.getElementById("callurl").value= callbackurl;
        }
        if (k == 3) {
            var data = "{'address':'','gameId':1001,'name':'test','phone':'11122334','userPin':'testJd','uuid':'333444'}";
            document.getElementById("mydata").value = data;
            document.getElementById("url").value = url + "receiveAward";
            document.getElementById("method").value = "POST";
            document.getElementById("callurl").style.display = "none";
            document.getElementById("callurl").style.width = "900px";
        }
        if (k == 4) {
            document.getElementById("mydata").value = "";
            document.getElementById("url").value = url + "awards?gameID=1001";
            document.getElementById("method").value = "GET";
            document.getElementById("callurl").style.display = "none";
            document.getElementById("callurl").style.width = "900px";
        }
        if (k == 5) {
            document.getElementById("mydata").value = "";
            document.getElementById("url").value = url + "complexLevelAward";
            document.getElementById("method").value = "GET";
            document.getElementById("callurl").style.display = "none";
            document.getElementById("callurl").style.width = "900px";
        }
        if (k == 6) {
            var data = "{'ext':'xxx','feeType':4,'gameID':1001,'gameRequest':'游戏侧自定义','tranType':0}"
            document.getElementById("mydata").value = data;
            document.getElementById("url").value = url + "gameMsg";
            document.getElementById("method").value = "POST";
            document.getElementById("callurl").style.display = "inline";
            document.getElementById("callurl").style.width = "900px";
            document.getElementById("callurl").value= callbackurl;
        }
        if (k == 7) {
            var data = "{'ext':'xxx','feeType':4,'gameID':1001,'gameRequest':'游戏侧自定义','tranType':0}"
            document.getElementById("mydata").value = data;
            document.getElementById("url").value = url + "gameMessage";
            document.getElementById("method").value = "POST";
            document.getElementById("callurl").style.display = "inline";
            document.getElementById("callurl").style.width = "900px";
            document.getElementById("callurl").value= callbackurl;
        }
        if (k == 8) {
            var data = "{'key':'key333****','gameID':1001}";
            document.getElementById("mydata").value = data;
            document.getElementById("url").value = url + "couponAward";
            document.getElementById("method").value = "POST";
            document.getElementById("callurl").style.display = "none";
            document.getElementById("callurl").style.width = "900px";
        }

    }

</script>

<body>

<h1>游戏接口测试页接口测试页</h1>
接口选择:
<select name="interface" id="interface" onchange="setlectinterface(this.value)">
    <option selected="selected">选择接口</option>
    <option value="1">接口-余额查询</option>
    <option value="2">接口-游戏逻辑</option>
    <option value="3">接口-复奖级实物领取</option>
    <option value="4">接口-复奖级历史查询</option>
    <option value="5">接口-红包雨</option>
    <option value="6">接口-游戏消息</option>
    <option value="7">接口-游戏消息2</option>
    <option value="8">接口-优惠券复奖级</option>
</select>

请求类型:
<input id="method" name="method" type="text" value=""/>
<br/>
请求地址:
<input style="width:900px" id="url" name="url" type="text" value=""/>
<br/>
<td>请求参数:</td>
<td><input style="width:900px" id="mydata" name="mydata" type="text" value=""/></td>
<br/>

<td>游戏系统:</td>
<td><input style="width:900px;display:none ;" id="callurl" name="callurl" type="text" value=""/>
</td>
<input type="button" id="ok" onclick="createLottery()" value="确定"/>

<br/>
</table>
<hr/>
<table style="width:500px">
    <div id="request" style="width:1200px;overflow: hidden;"></div>
    <br/>
    <div id="result" style="width:1200px;overflow: hidden;"></div>
</table>
</body>
</html>