package similar.webnote.bean;
/**
 * 公共bean
 * @author Administrator
 *
 */
public class BaseBean {
	// 创建时间
	private String createTime;
	// 更新时间
	private String updateTime;
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
