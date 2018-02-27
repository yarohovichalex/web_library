package by.htp.controller.action.imple;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.controller.action.ForUser;
import by.htp.dao.BaseDao;
import by.htp.dao.impl.AddBookDaoImpl;

public class AddBookImpl extends ForUser implements BaseAction {
	private User us;
	 
	public AddBookImpl(User us) {
		if(us != null) {
			this.us = us;
		}
	}
	@Override
	public User todoAction(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
		BaseDao dao = new AddBookDaoImpl();
		System.out.println("add!!!"/* + us.getRole()*/);
		if(/*us.getRole().equals("admin")*/ true) {
			String nameBook = request.getParameter("addName");
			String nameAuthor = request.getParameter("addAuthor");
			String stringDate = request.getParameter("publishDate");
			System.out.println(stringDate);
			SimpleDateFormat format = new SimpleDateFormat();
			format.applyPattern("yyyy-MM-dd");
			Date date;
				try {
					date = format.parse(stringDate);
					dao.criate(new Book(nameBook, nameAuthor, date));
				} catch (ParseException e) {
					e.printStackTrace();
				}			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_ADMIN);
		dispatcher.forward(request, response);
		
	
		return user;
	}

	

}
