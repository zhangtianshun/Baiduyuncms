package yun.open1111.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yun.open1111.dao.YunUserDao;
import yun.open1111.entity.YunUser;
import yun.open1111.service.YunUserService;

/**
 * 百度云用户Service实现类
 * @author liyingqi
 *
 */
@Service("yunUserService")
public class YunUserServiceImpl implements YunUserService{

	@Resource
	private YunUserDao yunUserDao;
	
	public List<YunUser> list(Map<String, Object> map) {
		return yunUserDao.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return yunUserDao.getTotal(map);
	}

	public Integer delete(Integer id) {
		return yunUserDao.delete(id);
	}

	public Integer update(YunUser yunUser) {
		return yunUserDao.update(yunUser);
	}

	public Integer add(YunUser yunUser) {
		return yunUserDao.add(yunUser);
	}

	public List<YunUser> listHot(Integer n) {
		return yunUserDao.listHot(n);
	}

	public YunUser findById(String userUk) {
		return yunUserDao.findById(userUk);
	}

}
