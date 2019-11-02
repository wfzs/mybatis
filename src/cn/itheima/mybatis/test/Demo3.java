package cn.itheima.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.mapper.OrderMapper;
import cn.itheima.mybatis.mapper.UserMapper;
import cn.itheima.mybatis.pojo.Orders;
import cn.itheima.mybatis.pojo.QueryVo;
import cn.itheima.mybatis.pojo.User;

public class Demo3 {

	@Test
	public void fun1() throws IOException{
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		List<Orders> list = mapper.selectOrdersList();
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
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
		user.setUsername("Îå");
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
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		List<Orders> list = mapper.selectOrder();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	
	}
}
