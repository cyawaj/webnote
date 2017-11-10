package similar.webnote.service;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;

import similar.webnote.bean.User;

public class UserServiceTest {
	private static ApplicationContext ctx;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testListUserByPage() {
		UserService userService = (UserService) ctx.getBean("userService");
		PageInfo<User> info = userService.listUserByPage(2, 3);
		if(info != null) {
			List<User> users = info.getList();
			if(users != null) {
				for(User user:users) {
					System.out.println(user);
				}
			}	
			System.out.println("总记录数:"+info.getTotal());
			System.out.println("总页数:"+info.getPages());
		}
	}

}
