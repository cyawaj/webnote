package similar.webnote.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import similar.webnote.bean.Content;
import similar.webnote.common.CommonUtil;

public class ContentMapperTest {
	private static SqlSessionFactory sf;
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		sf = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
	}

	@Test
	public void testInsertContent() {
		SqlSession session = sf.openSession();
		ContentMapper contentMapper = session.getMapper(ContentMapper.class);
		Content content = new Content("admin", "今天是星期五", "今天是星期五", 0);
		content.setCreateTime(CommonUtil.getCurrentDate());
		content.setUpdateTime(content.getCreateTime());
		contentMapper.insertContent(content);
		session.commit();
	}

}
