package yun.open1111.entity;

/**
 * �ٶ����û�ʵ��
 * @author liyingqi
 *
 */
public class YunUser {

	private String userUk; // �û�ID
	private String userName; // �û���
	private String imageUrl; // ͷ���ַ
	private Integer shareNum; // ������Դ����
	private String note; // �û�˵��
	
	public String getUserUk() {
		return userUk;
	}
	public void setUserUk(String userUk) {
		this.userUk = userUk;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getShareNum() {
		return shareNum;
	}
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
