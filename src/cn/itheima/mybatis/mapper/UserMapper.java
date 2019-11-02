package cn.itheima.mybatis.mapper;

import java.util.List;

import cn.itheima.mybatis.pojo.QueryVo;
import cn.itheima.mybatis.pojo.User;

public interface UserMapper {

	public User findUserById(Integer id);
	public List<User> findUserByQueryVo(QueryVo vo);
	public Integer count();
	public List<User> findUserBySexAndName(User user);
//	public List<User> selectUserByIds(Integer[] ids);
//	public List<User> selectUserByIds(List<Integer> ids);
	public List<User> selectUserByIds(QueryVo vo);
}
