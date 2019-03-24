package yun.open1111.service;

import java.util.List;
import java.util.Map;

import yun.open1111.entity.YunUser;

/**
 * �ٶ����û�Service�ӿ�
 * @author liyingqi
 */
public interface YunUserService {

	/**
	 * ����������ҳ��ѯ�ٶ����û�����
	 * @param map
	 * @return
	 */
	public List<YunUser> list(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * ɾ���ٶ����û�
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * �ٶ����û��޸�
	 * @param yunUser
	 * @return
	 */
	public Integer update(YunUser yunUser);
	
	/**
	 * �ٶ����û�����
	 * @param yunUser
	 * @return
	 */
	public Integer add(YunUser yunUser);
	
	/**
	 * ��ѯN�����Űٶ����û�
	 * @param n
	 * @return
	 */
	public List<YunUser> listHot(Integer n);
	
	/**
	 * ����Id��ѯʵ��
	 * @param id
	 * @return
	 */
	public YunUser findById(String userUk);
}