package yun.open1111.service;

import java.util.List;
import java.util.Map;

import yun.open1111.entity.Resources;

/**
 * 百度云资源Service接口
 * @author liyingqi
 */
public interface ResourcesService {

	/**
	 * 根据条件分页查询百度云资源集合
	 * @param map
	 * @return
	 */
	public List<Resources> list(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 删除百度云资源
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * 百度云资源修改
	 * @param yunUser
	 * @return
	 */
	public Integer update(Resources resources);
	
	/**
	 * 查询最新的N条数据
	 * @param n
	 * @return
	 */
	public List<Resources> listNewest(Integer n);
	
	/**
	 * 通过id查询资源详细信息
	 * @param id
	 * @return
	 */
	public Resources findById(Integer id);
	
	/**
	 * 随机获取n个资源
	 * @param n
	 * @return
	 */
	public List<Resources> randomList(Integer n);
}
