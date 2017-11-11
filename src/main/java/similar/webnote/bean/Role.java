package similar.webnote.bean;

public class Role extends BaseBean {
	// 角色id
	private Integer id;
	// 角色名称
	private Integer roleName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleName() {
		return roleName;
	}
	public void setRoleName(Integer roleName) {
		this.roleName = roleName;
	}
	
}
