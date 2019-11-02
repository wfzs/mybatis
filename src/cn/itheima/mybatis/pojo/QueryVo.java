package cn.itheima.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	List<Integer> idslist;
	Integer[] ids;

	public List<Integer> getIdslist() {
		return idslist;
	}

	public void setIdslist(List<Integer> idslist) {
		this.idslist = idslist;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
