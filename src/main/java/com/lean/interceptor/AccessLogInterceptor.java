package com.lean.interceptor;

import com.learn.util.URLUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/7 16:57
 * @since jdk1.6.0_27
 */
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger("AccessLogInterceptor");


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuilder sbRecord = new StringBuilder();
        long startTime = System.currentTimeMillis();

        StringBuilder requestParams = new StringBuilder();
        Map<String, String> params = new HashMap<String, String>();
        Enumeration<String> keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            params.put(key, request.getParameter(key).toString());

            requestParams.append(key);
            requestParams.append("=");
            requestParams.append(request.getParameter(key).toString());
            requestParams.append("&");
        }


        //组装访问地址和远程的ip和请求信息
        sbRecord.append("URL:");
        sbRecord.append(URLUtil.getRemoteHost(request));
        sbRecord.append(" PATH:");
        sbRecord.append(request.getPathInfo());
        sbRecord.append(" PARAM:");
        sbRecord.append(requestParams.toString());

        sbRecord.append(" TimeUsed:");
        sbRecord.append(System.currentTimeMillis() - startTime);
        sbRecord.append("ms");
        logger.info(sbRecord.toString());
        return true;
    }
}
