package yun.open1111.service;

import yun.open1111.entity.Manager;

/**
 * ����ԱService�ӿ�
 * @author liyingqi
 *
 */
public interface ManagerService {

	/**
	 * ͨ���û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Manager getByUserName(String userName);
	
	/**
	 * ���¹���Ա
	 * @param manager
	 * @return
	 */
	public Integer update(Manager manager);
}
