package yun.open1111.service;

import java.util.List;
import java.util.Map;

import yun.open1111.entity.Resources;

/**
 * �ٶ�����ԴService�ӿ�
 * @author liyingqi
 */
public interface ResourcesService {

	/**
	 * ����������ҳ��ѯ�ٶ�����Դ����
	 * @param map
	 * @return
	 */
	public List<Resources> list(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * ɾ���ٶ�����Դ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * �ٶ�����Դ�޸�
	 * @param yunUser
	 * @return
	 */
	public Integer update(Resources resources);
	
	/**
	 * ��ѯ���µ�N������
	 * @param n
	 * @return
	 */
	public List<Resources> listNewest(Integer n);
	
	/**
	 * ͨ��id��ѯ��Դ��ϸ��Ϣ
	 * @param id
	 * @return
	 */
	public Resources findById(Integer id);
	
	/**
	 * �����ȡn����Դ
	 * @param n
	 * @return
	 */
	public List<Resources> randomList(Integer n);
}
