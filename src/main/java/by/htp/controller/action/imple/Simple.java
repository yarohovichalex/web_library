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
import by.htp.dao.BaseDao;
import by.htp.dao.impl.SearchBookDaoImpl;

public class Simple {
	List<Book> list1 = new ArrayList<>();
	BaseDao dao = new SearchBookDaoImpl();


	
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("search!!!");
		String name = request.getParameter("sfgs");
		list1 = dao.searchBookDao(name);
		RequestDispatcher dispatcher = null;
		
		System.out.println("razmer: " + list1.size());		
		request.setAttribute("listbook", list1);
		dispatcher = request.getRequestDispatcher(PAGE_ADMIN);
		dispatcher.forward(request, response);
		
		return null;
	}
}
