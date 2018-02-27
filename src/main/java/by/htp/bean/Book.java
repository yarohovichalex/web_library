package by.htp.bean;

import java.util.Date;

public class Book {
	private int id;
	private String tittle;
	private Date date;
	private String authorName;
	
//	public Book() {
//		
//	}
	
	public Book(String tittle) {
		
		this.tittle = tittle;		
	}
	
	public Book(String tittle, String authorName, Date date) {
		
		this.tittle = tittle;
		this.date = date;
		this.authorName = authorName;
	}
public Book(String tittle, String authorName, Date date, int id) {
		
		this.tittle = tittle;
		this.date = date;
		this.authorName = authorName;
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Book [tittle=" + tittle + ", year=" + date + ", authorName=" + authorName + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	


	



	
	
}
