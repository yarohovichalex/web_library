package by.htp.dao;

//import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.bean.Book;
import by.htp.bean.User;


public class BaseDaoImpl implements BaseDao{
	//private Book book = new Book();
	private List<Book> list = new ArrayList<>();
	
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	
	public User searchUser(String login, String password) {
		User us = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			
			while(rs.next()) {
//				books.add(new Book(rs.getInt("id"), rs.getString("brief"), new Author(rs.getString("author"), new Date(1994,06,13))));
				//System.out.println(rs.getString("login"));
				if (rs.getString("login").equals(login) && rs.getString("login").equals(password)) {
					us = new User();
					us.setLogin(rs.getString("login"));
					us.setPassword(rs.getString("password"));
					us.setRole(rs.getString("role"));
	                System.out.println("успешно нашел, роль:" + rs.getString("role") + " имя: " + rs.getString("login"));
	            }
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		 
		
		return us;		
	}
	
//	public int methodSetId() {
//		List<Integer> idList = new ArrayList<>();
//		int num = 0;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");			
//		} catch (ClassNotFoundException e1) {			
//			e1.printStackTrace();
//		}
//		
//		try(Connection cn = DriverManager.getConnection(url,"root","root")){
//			Statement st = cn.createStatement();
//			ResultSet rs = st.executeQuery("select id from book;");
//			
//			while(rs.next()) {
//				idList.add(rs.getInt("id"));				
//			}
//			for(int i = 0; i < idList.size(); i++) {
//				if(idList.get(i)==0) {
//					return i;
//				}else {
//					
//				}
//			
//			}
//			return idList.size();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}	
//		return 0;
//	}
	
	public List<Book> searchBook(String bookName) {
		list.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from book;");
			

//			while(rs.next()) {
//				String nameBook = rs.getString("nameBook");
//				String nameAuthor = rs.getString("nameAuthor");
//				Calendar calendar = Calendar.getInstance();
//				calendar.setTime(rs.getDate("publishDate"));
//				int id  = rs.getInt("id");
//				list.add(new Book(nameBook, nameAuthor, calendar, id));				
//				System.out.println(rs.getString("nameBook"));
//			}
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	public List<String> search(String bookName) {
		list.clear();
		List<String> bookNameList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from book;");
			

			while(rs.next()) {				
				String string = rs.getString("nameBook");
				if(string.contains(bookName)) {
					System.out.println(rs.getString("nameBook"));
					bookNameList.add(string);
				}
				
			}
			for(Book book: list) {
				if(bookName.contains(book.getTittle())) {					
					bookNameList.add(book.getTittle());
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return bookNameList;
	}
	
//public void criate(Book entity) {		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");			
//		} catch (ClassNotFoundException e1) {			
//			e1.printStackTrace();
//		}		
//		try(Connection cn = DriverManager.getConnection(url,"root","root")){
//			String sql = "INSERT INTO book(id, nameBook, nameAuthor, publishYear) VALUES (?, ?, ?, ?)";
//			PreparedStatement ps = cn.prepareStatement(sql);
//			ps.setInt(1, entity.getId());
//			ps.setString(2, entity.getTittle());
//			ps.setString(3, entity.getAuthorName());
//			ps.setInt(4,entity.getYear());
//			ps.executeUpdate();
//
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}		
//	}
	public void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
		
			PreparedStatement ps = cn.prepareStatement("delete from book where id = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
}

	@Override
	public List<Book> searchBookDao(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> outputBook() {
		// TODO Auto-generated method stub
		return null;
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
