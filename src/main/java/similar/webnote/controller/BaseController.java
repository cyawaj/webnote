package similar.webnote.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 基础控制类(包含异常处理)
 * @author Administrator
 *
 */
public abstract class BaseController {
	private Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		if(ex instanceof UnauthenticatedException) {
			logger.error("无此权限！");
			request.setAttribute("exMsg", "403,无此权限！");
		}else {
			logger.error("系统异常！");
			request.setAttribute("exMsg", ex.getMessage());
		}
		return "/WEB-INF/jsp/403.jsp";
	}
}
