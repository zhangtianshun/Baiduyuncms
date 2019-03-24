package yun.open1111.entity;

import java.util.Date;

/**
 * 百度云资源实体
 * @author user
 *
 */
public class Resources {

	private Integer id; // 编号
	private String name; // 资源名称
	private Date publishDate; // 发布日期
	private YunUser yunUser; // 用户
	private Integer hits; // 浏览次数
	private Integer downloads; // 下载次数
	private Date shareDate; // 分享日期
	private String shareUrl; // 资源分享地址
	
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
