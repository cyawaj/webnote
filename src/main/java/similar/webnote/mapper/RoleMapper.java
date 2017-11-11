package similar.webnote.mapper;

import org.apache.ibatis.annotations.Param;

import similar.webnote.bean.Role;

public interface RoleMapper {
	/**
	 * 根据角色ID获得角色
	 * @param roleId
	 * @return
	 */
	Role getRole(@Param("roleId") Integer roleId);
	/**
	 * 根据用户账号获得角色名
	 * @param username
	 * @return
	 */
	String getRoleName(String username);
}
