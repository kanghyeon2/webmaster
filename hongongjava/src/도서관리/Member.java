package 도서관리;

//oracle sql 두단어 조합 member_id /자바에서는 memberId(카멜)
public class Member {
	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private String creationDate;
	
	public Member(String memberId, String password, String memberName, String phone, String responsibility, String creationDate) {
	this.memberId = memberId;
	this.password = password;
	this.memberName = memberName;
	this.phone = phone;
	this.responsibility = responsibility;
	this.creationDate = creationDate;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {		
		return  memberId + "\t" + password + "\t" + memberName + "\t" + phone + "\t" + responsibility + "\t" + creationDate ; 
	}
	
}
