package similar.webnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import similar.webnote.bean.Result;
import similar.webnote.bean.User;
import similar.webnote.mapper.UserMapper;

@Service("userService")
public class UserService {
	@Resource
	private UserMapper userMapper;
	/**
	 * 根据用户账号获得密码
	 * @param username
	 * @return
	 */
	public String getPassword(String username) {
		return userMapper.getPassword(username);
	}
	/**
	 * 分页查询
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	public List<User> listUser(Integer startRow, Integer pageSize){
		return userMapper.listUser(startRow, pageSize);
	}
	/**
	 * 分页插件的分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<User> listUserByPage(Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userMapper.listAllUser();
		PageInfo<User> info = new PageInfo<>(users);
		return info;
	}
	private User getUser(String username) {
		return userMapper.getUser(username);
	}
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Result login(String username, String password) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Result result = new Result();
		try {
			currentUser.login(token);
			// 记录用户登录信息
			User user = getUser(username);
			if(user != null && !user.getPassword().equals(new Md5Hash(password, username).toString())){
				result.setErrcode(-1);
				result.setErrmsg("用户名或密码错误!");
				return result;
			}
			Session session = currentUser.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userType", user!=null?user.getUserType():null);
			session.setAttribute("nickname", user!=null?user.getNickname():null);
			result.setErrcode(0);
		} catch(Exception e) {
			result.setErrcode(-1);
			result.setErrmsg("系统异常！");
		}
		return result;
	}
	public Result checkLogin(String username, String password) {
		Result result = new Result();
		if(username == null || username.isEmpty()) {
			result.setErrcode(-1);
			result.setErrmsg("用户账号不能为空!");
			return result;
		}
		if(password == null || password.isEmpty()) {
			result.setErrcode(-1);
			result.setErrmsg("用户密码不能为空！");
			return result;
		}
		return null;
	}
}
