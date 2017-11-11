package similar.webnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import similar.webnote.bean.Role;
import similar.webnote.mapper.RoleMapper;

@Service("roleService")
public class RoleService {
	@Resource
	private RoleMapper roleMapper;
	/**
	 * 根据角色ID获得角色
	 * @param roleId
	 * @return
	 */
	public Role getRole(Integer roleId) {
		return roleMapper.getRole(roleId);
	}
	/**
	 * 根据用户账号获得用户角色名
	 * @param username
	 * @return
	 */
	public String getRoleName(String username) {
		return roleMapper.getRoleName(username);
	}
}
