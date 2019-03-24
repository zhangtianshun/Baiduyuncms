package yun.open1111.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yun.open1111.dao.ManagerDao;
import yun.open1111.entity.Manager;
import yun.open1111.service.ManagerService;

/**
 * 管理员Service实现类
 * @author liyingqi
 *
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService{

	@Resource
	private ManagerDao managerDao;

	public Manager getByUserName(String userName) {
		return managerDao.getByUserName(userName);
	}

	public Integer update(Manager manager) {
		return managerDao.update(manager);
	}
}
