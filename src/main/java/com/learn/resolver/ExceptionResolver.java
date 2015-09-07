package com.learn.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/7 17:55
 * @since jdk1.6.0_27
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger("ExceptionResolver");

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        StringBuffer sb = new StringBuffer();

        Map<String,String[]> paramsMap = request.getParameterMap();
        if(paramsMap != null && !paramsMap.isEmpty()){
            for(String key:paramsMap.keySet()){
                sb.append("&");
                sb.append(key);
                sb.append("=");
                String [] values = paramsMap.get(key);
                if(values != null && values.length > 0){
                    for(String v:values){
                        sb.append(v);
                    }
                }
            }
        }
        sb.append("&exception==**==");
        sb.append(ex.getMessage());

        logger.error(sb.toString());

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("msg",sb.toString());
        ModelAndView modelAndView = new ModelAndView("exception",model);
        return modelAndView;
    }

}

