package javadb;

import java.sql.Date;

public class Board {
	
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdates;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBdates() {
		return bdates;
	}
	public void setBdates(Date bdates) {
		this.bdates = bdates;
	}
	@Override
	public String toString() {
		return bno + " " + btitle + " " + bcontent + " " + bwriter;
	}
	
	
	
}
