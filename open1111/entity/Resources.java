package yun.open1111.entity;

import java.util.Date;

/**
 * �ٶ�����Դʵ��
 * @author user
 *
 */
public class Resources {

	private Integer id; // ���
	private String name; // ��Դ����
	private Date publishDate; // ��������
	private YunUser yunUser; // �û�
	private Integer hits; // �������
	private Integer downloads; // ���ش���
	private Date shareDate; // ��������
	private String shareUrl; // ��Դ�����ַ
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public YunUser getYunUser() {
		return yunUser;
	}
	public void setYunUser(YunUser yunUser) {
		this.yunUser = yunUser;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}
	public Date getShareDate() {
		return shareDate;
	}
	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
	public String getShareUrl() {
		return shareUrl;
	}
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	
	
}
