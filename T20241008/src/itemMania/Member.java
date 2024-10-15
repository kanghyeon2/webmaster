package itemMania;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String residentnumber;
	private String ano;
	private int mileage;


	public Member(String id, String pwd, String name, String phone, String residentnumber, String ano, int mileage) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.residentnumber = residentnumber;
		this.ano = ano;
		this.mileage = mileage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResidentnumber() {
		return residentnumber;
	}

	public void setResidentnumber(String residentnumber) {
		this.residentnumber = residentnumber;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	
}
