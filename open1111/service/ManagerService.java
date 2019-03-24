package yun.open1111.service;

import yun.open1111.entity.Manager;

/**
 * 管理员Service接口
 * @author liyingqi
 *
 */
public interface ManagerService {

	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public Manager getByUserName(String userName);
	
	/**
	 * 更新管理员
	 * @param manager
	 * @return
	 */
	public Integer update(Manager manager);
}
