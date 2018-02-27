package by.htp.controller.action.imple;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_EDIT;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;

public class ToEditBookPage implements BaseAction{
	private User us;
	
	public ToEditBookPage(User us) {
		this.us = us;
	}
	
	@Override
	public User todoAction(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
		request.setAttribute("user_name", us.getLogin());		
		int f= Integer.parseInt(request.getParameter("book_id2"));		
		
			request.setAttribute("edit_book_id", f);
			request.setAttribute("book_value", "Anna Korenina");
			request.setAttribute("author_value", "Lev Tolstoy");

				
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_EDIT);
		dispatcher.forward(request, response);
		
	
		return us;
	}
	
}
