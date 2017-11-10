package similar.webnote.bean;
/**
 * 内容
 * @author Administrator
 *
 */
public class Content extends BaseBean {
	private Integer id;
	private String username;
	private String title;
	private String detail;
	private Integer dirId;// 目录id
	public Content() {
	}
	
	public Content(String username, String title, String detail, Integer dirId) {
		this.username = username;
		this.title = title;
		this.detail = detail;
		this.dirId = dirId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getDirId() {
		return dirId;
	}
	public void setDirId(Integer dirId) {
		this.dirId = dirId;
	}
	
	
}
