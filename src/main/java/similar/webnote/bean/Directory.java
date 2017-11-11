package similar.webnote.bean;
/**
 * 目录
 * @author Administrator
 *
 */
public class Directory extends BaseBean {
	private Integer id;
	private String dirName;
	private Integer parentId;
	private Integer hasChild;
	private String username;
	private Integer isAbandoned;//是否在回收站:1=是,0=否
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getHasChild() {
		return hasChild;
	}
	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getIsAbandoned() {
		return isAbandoned;
	}
	public void setIsAbandoned(Integer isAbandoned) {
		this.isAbandoned = isAbandoned;
	}
	
}
