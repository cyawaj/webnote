package similar.webnote.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import similar.webnote.bean.User;

public interface UserMapper {
	/**
	 * 根据用户账号获得用户密码
	 * @param username
	 * @return
	 */
	public String getPassword(@Param("username") String username);
	/**
	 * 获得用户信息
	 * @param username
	 * @return
	 */
	public User getUser(@Param("username") String username);
	/**
	 * 分页查询所有用户
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	public List<User> listUser(Integer startRow, Integer pageSize);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> listAllUser();
}
