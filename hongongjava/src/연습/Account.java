package 연습;

public class Account {
	// 필드
	private String ano;
	private String owner;
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;

	// 생성자
	Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	// 메소드
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return ano + "\t" + owner + "\t" + balance + "\t" ;
	}

//	@Override
//	public int hashCode() {
//		return Integer.parseInt(ano);
//		
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Account))
//			return false;
//		Account account = (Account) obj;
//		if (Integer.parseInt(ano) != Integer.parseInt(account.ano))
//			return false;
//		return true;
//	}
//	public boolean equals(Object obj) {
//		if ((obj instanceof Account)) {
//			Account account = (Account) obj;
//			return Integer.parseInt(ano) == Integer.parseInt(account.ano);
//		}else {
//			return false;
//		}
//	}
}

