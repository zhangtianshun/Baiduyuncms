package yun.open1111.dao;

import yun.open1111.entity.Manager;

/**
 * ����ԱDao�ӿ�
 * @author user
 *
 */
public interface ManagerDao {

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
