package cn.itheima.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.mapper.UserMapper;
import cn.itheima.mybatis.pojo.QueryVo;
import cn.itheima.mybatis.pojo.User;

public class Demo2 {

	@Test
	public void fun1() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.findUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void fun2() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		QueryVo qVo=new QueryVo();
		User user=new User();
		user.setUsername("五");
		qVo.setUser(user);
		List<User> list = mapper.findUserByQueryVo(qVo);
		for (User user2 : list) {
			System.out.println(user2);
		}
	
	}
	@Test
	public void fun3() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer count = mapper.count();
		System.out.println(count);
	
	}
	@Test
	public void fun4() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		user.setSex("1");
//		user.setUsername("张小明");
		List<User> list = mapper.findUserBySexAndName(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	@Test
	public void fun5() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Integer> ids=new ArrayList<>();
		ids.add(16);
		ids.add(22);
		ids.add(24);
		QueryVo vo=new QueryVo();
		vo.setIdslist(ids);
		List<User> list = mapper.selectUserByIds(vo);
//		List<User> list = mapper.selectUserByIds(vo);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
}
