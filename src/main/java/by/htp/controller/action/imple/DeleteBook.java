package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.dao.BaseDao;
import by.htp.dao.impl.DeleteBookDaoImpl;

public class DeleteBook implements BaseAction  {
	BaseDao dao = new DeleteBookDaoImpl();
	 private User us;
	 public DeleteBook(User us) {
		 this.us = us;
	 }
	
	@Override
	public User todoAction(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
		System.out.println("delete!!!");
		int f= Integer.parseInt(request.getParameter("book_id"));
		 
		dao.delete(f);
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_ADMIN);
		dispatcher.forward(request, response);
		return us;
	}
	
}
