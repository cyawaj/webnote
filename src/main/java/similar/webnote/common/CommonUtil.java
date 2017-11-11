package similar.webnote.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 公用的方法
 */
public class CommonUtil {
	public static final String FORMAT_DATE = "yyyyMMdd";
	public static final String FORMAT_DATE_SEP = "yyyy-MM-dd";
	public static final String FORMAT_DATE_AND_TIME = "yyyy-MM-dd HH:mm:ss";

	private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	private static Gson gson = new GsonBuilder().create();
	/**
	 * 返回JSON数据
	 * @param response
	 * @param result
	 */
	public static void reply(ServletResponse response, Object result) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(gson.toJson(result));
			logger.info(gson.toJson(result));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	public static void reply(ServletResponse response, Object result, final String[] exList) {
		try {
			Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
				
				@Override
				public boolean shouldSkipField(FieldAttributes f) {
					if(exList != null) {
						for(String exKey:exList) {
							if(f.getName().equals(exKey)) {
								return true;
							}
						}
					}
					return false;
				}
				
				@Override
				public boolean shouldSkipClass(Class<?> clazz) {
					return false;
				}
			}).create();
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(gson.toJson(result));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	/**
	 * 指定格式获得当前时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(new Date());
	}
	/**
	 * 获得当前日期
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATE_AND_TIME);
		return df.format(new Date());
	}
	/**
	 * 获得当前时间戳
	 * 
	 * @return
	 */
	public static String getCurrentTimestamp() {
		return String.valueOf(new Date().getTime());
	}

	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * UTF-8编码
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = URLEncoder.encode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return source;
		}
		return result;
	}

	/**
	 * UTF-8解码
	 * 
	 * @param url
	 * @return
	 */
	public static String urlDecodeUTF8(String url) {
		String result = url;
		try {
			result = URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return url;
		}
		return result;
	}

    /**      
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /**      
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static String getRequestPostStr(HttpServletRequest request) throws IOException{
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
    
    public static String getRequestWebRootURL(HttpServletRequest request) {
    	return request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
	/**
	 * 工程物理路径
	 * @param request
	 * @return
	 */
    public static String getWebRootRealPath(HttpServletRequest request) {
    	return Thread.currentThread().getContextClassLoader().getResource("../../").getPath();
    }
    /**
     * 获得资源物理路径
     * @param request
     * @param resourceDirName
     * @return
     */
    public static String getResourceRealPath(HttpServletRequest request, String resourceDirName) {
    	String webRootRealPath = getWebRootRealPath(request);
    	if(resourceDirName != null) {
    		return webRootRealPath.replace("webnote", resourceDirName);
    	}
    	return webRootRealPath;
    }
}
