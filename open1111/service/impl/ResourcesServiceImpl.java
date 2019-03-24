package yun.open1111.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yun.open1111.dao.ResourcesDao;
import yun.open1111.entity.Resources;
import yun.open1111.service.ResourcesService;

/**
 * 百度云资源Service实现类
 * @author liyingqi
 *
 */
@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService{

	@Resource
	private ResourcesDao resourcesDao;
	
	public List<Resources> list(Map<String, Object> map) {
		return resourcesDao.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return resourcesDao.getTotal(map);
	}

	public Integer delete(Integer id) {
		return resourcesDao.delete(id);
	}

	public Integer update(Resources resources) {
		return resourcesDao.update(resources);
	}

	public List<Resources> listNewest(Integer n) {
		return resourcesDao.listNewest(n);
	}

	public Resources findById(Integer id) {
		return resourcesDao.findById(id);
	}

	public List<Resources> randomList(Integer n) {
		return resourcesDao.randomList(n);
	}

}
