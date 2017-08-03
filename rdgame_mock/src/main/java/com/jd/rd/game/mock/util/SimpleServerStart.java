package com.jd.rd.game.mock.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.xml.sax.SAXException;

public class SimpleServerStart {
    public static void main(String[] args) {
        try {
            int port = 8181;
            if (args != null && args.length > 0) {
                port = Integer.valueOf(args[0]);
            }
            Server server = new Server(port);
            // 关联一个已经存在的上下文
            WebAppContext context = new WebAppContext();
            // 设置描述符位置
            context.setDescriptor("./src/main/webapp/WEB-INF/web.xml");
            // 设置Web内容上下文路径
            context.setResourceBase("./src/main/webapp");

            /**打jar包用*/
           context.setDescriptor("./web.xml");
           context.setResourceBase("./");
            // 设置上下文路径
            context.setContextPath("/");
            context.setParentLoaderPriority(true);
            server.setHandler(context);
            // 启动
            server.start();
            server.join();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
