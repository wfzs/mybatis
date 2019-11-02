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
		List<User> users = session.selectList("test.findUserByUsername", "��");
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
		user.setUsername("��־ΰ");
		user.setBirthday(new Date());
		user.setAddress("sdsd");
		user.setSex("��");
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
		user.setSex("Ů");
		user.setUsername("ɵ��");
		session.insert("test.updateUserById", user);
		session.commit();
	}
}
