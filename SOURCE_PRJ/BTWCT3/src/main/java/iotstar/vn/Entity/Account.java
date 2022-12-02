package iotstar.vn.Entity;

public class Account {
	private int id;
	private String user;
	private String pass;
	private String author;
	
	public Account() {
		
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", author=" + author + "]";
	}
	public Account(int id, String user, String pass, String author) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	} 

}
