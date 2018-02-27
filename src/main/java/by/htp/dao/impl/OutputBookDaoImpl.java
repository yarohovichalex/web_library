package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.dao.BaseDao;

public class OutputBookDaoImpl implements BaseDao{
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	List<Book> list = new ArrayList<>();
	private User us;
	
	public OutputBookDaoImpl(User us) {
		if(us != null) {
			this.us = us;
		}		
	}
	
	public List<Book> outputBook() {
	list.clear();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");			
	} catch (ClassNotFoundException e1) {			
		e1.printStackTrace();
	}	
	try(Connection cn = DriverManager.getConnection(url,"root","root")){
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("select * from book;");
		
		while(rs.next()) {
			String nameBook = rs.getString("nameBook");
			String nameAuthor = rs.getString("nameAuthor");
			Date date = rs.getDate("publishDate");
			int id  = rs.getInt("id");
			list.add(new Book(nameBook, nameAuthor, date, id));				
			System.out.println(nameBook);			
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}	
	return list;
}

	

	@Override
	public List<Book> searchBookDao(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criate(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBook(int id, Book book) {
		// TODO Auto-generated method stub
		
	}
	
}
