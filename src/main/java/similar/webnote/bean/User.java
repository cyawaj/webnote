package similar.webnote.bean;
/**
 * 普通用户
 * @author Administrator
 *
 */
public class User extends BaseBean {
	// 用户账号
	private String username;
	// 密码
	private String password;
	// 昵称
	private String nickname;
	// 用户类别:0=普通用户,1=会员
	private Integer userType;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nickname=" + nickname + ", userType="
				+ userType + "]";
	}
	
}
