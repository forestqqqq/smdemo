package com.learn.util;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/7 17:17
 * @since jdk1.6.0_27
 */
public class URLUtil {
    public static String getRemoteHost(javax.servlet.http.HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }

    /**
     * IP地址转换为长整形。
     * @param ipAddress
     * @return 如果ip地址格式不正确，返回null。
     */
    public static Long ip2Long(String ipAddress){
        Long result = null;

        if(ipAddress==null){
            return result;
        }

        String[] posArray = ipAddress.split("\\.");
        if(posArray.length == 4){
            long pos1 = Long.parseLong(posArray[0]);
            long pos2 = Long.parseLong(posArray[1]);
            long pos3 = Long.parseLong(posArray[2]);
            long pos4 = Long.parseLong(posArray[3]);
            result = (pos1<<24)+(pos2<<16)+(pos3<<8)+pos4;
        }

        return result;
    }

    /**
     * 长整形IP地址转换为标准格式的ip地址
     * @param ipAddress
     * @return
     */
    public static String long2Ip(Long ipAddress){
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(ipAddress>>>24));
        sb.append(".");
        sb.append(String.valueOf((ipAddress&0x00FF0000)>>>16));
        sb.append(".");
        sb.append(String.valueOf((ipAddress&0x0000FF00)>>>8));
        sb.append(".");
        sb.append(String.valueOf(ipAddress&0x000000FF));

        return sb.toString();
    }
}
