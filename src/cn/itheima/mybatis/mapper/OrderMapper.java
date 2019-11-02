package cn.itheima.mybatis.mapper;

import java.util.List;

import cn.itheima.mybatis.pojo.Orders;

public interface OrderMapper {

	public List<Orders> selectOrdersList();
	public List<Orders> selectOrder();
}
