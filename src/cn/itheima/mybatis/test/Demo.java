package cn.itheima.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.pojo.User;

public class Demo {
	
	@Test
	public void fun1() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", 10);
		System.out.println(user);
	}
	@Test
	public void fun2() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = session.selectList("test.findUserByUsername", "Îå");
		for (User user2 : users) {
			System.out.println(user2);
		}		
	}
	@Test
	public void fun3() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		User user=new User();
		user.setUsername("ÔøÖ¾Î°");
		user.setBirthday(new Date());
		user.setAddress("sdsd");
		user.setSex("ÄÐ");
		session.insert("test.insertUser", user);
		session.commit();
	}
	@Test
	public void fun4() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", 27);
		user.setAddress("sdasfddf");
		user.setSex("Å®");
		user.setUsername("Éµ¹Ï");
		session.insert("test.updateUserById", user);
		session.commit();
	}
}
