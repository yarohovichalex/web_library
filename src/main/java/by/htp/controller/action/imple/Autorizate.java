package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_LOGIN;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_PASSWORD;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.dao.BaseDao;
import by.htp.dao.impl.UserRegistrationImpl;

public class Autorizate extends User implements BaseAction{

	 private User us;
	 public Autorizate(User us) {
		 this.us = us;
	 }
	 
	@Override
	public User todoAction(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
		String login = request.getParameter(REQUEST_LOGIN);
		String pass = request.getParameter(REQUEST_PASSWORD);
		BaseDao dao = new UserRegistrationImpl();
		RequestDispatcher dispatcher = null;
		
		
		us = dao.searchUser(login, pass, us);
		super.setLogin(us.getLogin());
		super.setPassword(us.getPassword());
		super.setRole(us.getRole());
		if(us !=null && us.getRole().equals("user")) {
			System.out.println("us: " + us.getLogin() + ", user: " + user.getLogin());
			dispatcher = request.getRequestDispatcher(PAGE_USER);
			dispatcher.forward(request, response);		
			
		}else if(us !=null && us.getRole().equals("admin")){
			System.out.println("us: " + us.getLogin() + ", user: " );
			System.out.println("admin");
			dispatcher = request.getRequestDispatcher(PAGE_ADMIN);
			dispatcher.forward(request, response);
							
		}else {
			System.out.println("error");
			System.out.println("us: " + us.getLogin() + ", user: " + user.getLogin());
			dispatcher = request.getRequestDispatcher(PAGE_ERROR);
			dispatcher.forward(request, response);
							
		}
		

		return us;
	}
	

	public User getUs() {
		return null;
	}

	public void setUs(User us) {
		
	}
	

	

	

}
