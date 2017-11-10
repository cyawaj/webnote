package similar.webnote.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import similar.webnote.bean.Result;
import similar.webnote.common.CommonUtil;
import similar.webnote.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private UserService userService;
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response,
			String username, String password) {
		Result result = userService.checkLogin(username, password);
		if(result != null) {
			CommonUtil.reply(response, result);
			return;
		}
		result = userService.login(username, password);
		CommonUtil.reply(response, result);
	}
	/**
	 * 注销
	 * @param request
	 * @param response
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		Subject currentUser = SecurityUtils.getSubject();
		Result result = new Result();
		try {
			currentUser.logout();
			result.setErrcode(0);
		} catch (Exception e) {
			result.setErrcode(-1);
		}
		CommonUtil.reply(response, result);
	}
}
