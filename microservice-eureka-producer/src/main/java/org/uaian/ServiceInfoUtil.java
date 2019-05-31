package org.uaian;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/5/30.
 */
@Configuration
public class ServiceInfoUtil
        implements ApplicationListener<WebServerInitializedEvent> {

    private static WebServerInitializedEvent webServerInitializedEvent;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        ServiceInfoUtil.webServerInitializedEvent = webServerInitializedEvent;
    }

    /**
     * 获取端口号
     */
    public static int getPort(){
        int port = webServerInitializedEvent.getWebServer().getPort();
        return port;
    }
}
