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
import by.htp.dao.impl.OutputBookDaoImpl;

public class OutputAllBook  implements BaseAction{
	private User us;
	public OutputAllBook(User us) {
		if(us != null) {
			this.us = us;
		}		
	}
	
	List<Book> list = new ArrayList<>();
	BaseDao dao = new OutputBookDaoImpl(us);


	@Override
	public User todoAction(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
		System.out.println("output!!!");
		list = dao.outputBook();				
		RequestDispatcher dispatcher = null;
		
		request.setAttribute("user_name", user.getLogin());
		System.out.println("us: " + us.getLogin() + ", user: " + user.getLogin());
		request.setAttribute("listbook", list);
		dispatcher = request.getRequestDispatcher(PAGE_ADMIN);
		dispatcher.forward(request, response);
		
		return us;
	}
	
}
