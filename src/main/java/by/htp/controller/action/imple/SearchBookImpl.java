package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.dao.BaseDao;
import by.htp.dao.impl.SearchBookDaoImpl;

public class SearchBookImpl implements BaseAction{
	List<Book> list1 = new ArrayList<>();
	BaseDao dao = new SearchBookDaoImpl();
	private User us;
	
	public SearchBookImpl(User us) {
		if(us != null) {
			this.us = us;
		}
	}
	 


	@Override
	public User todoAction(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
		System.out.println("search!!!");
		String name = request.getParameter("search");
		list1 = dao.searchBookDao(name);
		RequestDispatcher dispatcher = null;
		
		System.out.println("razmer: " + list1.size());		
		request.setAttribute("listbook", list1);
		dispatcher = request.getRequestDispatcher(PAGE_ADMIN);
		dispatcher.forward(request, response);
		
		return us;
	}
	
}
