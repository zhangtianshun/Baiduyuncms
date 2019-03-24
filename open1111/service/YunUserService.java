package yun.open1111.service;

import java.util.List;
import java.util.Map;

import yun.open1111.entity.YunUser;

/**
 * 百度云用户Service接口
 * @author liyingqi
 */
public interface YunUserService {

	/**
	 * 根据条件分页查询百度云用户集合
	 * @param map
	 * @return
	 */
	public List<YunUser> list(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 删除百度云用户
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * 百度云用户修改
	 * @param yunUser
	 * @return
	 */
	public Integer update(YunUser yunUser);
	
	/**
	 * 百度云用户添加
	 * @param yunUser
	 * @return
	 */
	public Integer add(YunUser yunUser);
	
	/**
	 * 查询N个热门百度云用户
	 * @param n
	 * @return
	 */
	public List<YunUser> listHot(Integer n);
	
	/**
	 * 根据Id查询实体
	 * @param id
	 * @return
	 */
	public YunUser findById(String userUk);
}
