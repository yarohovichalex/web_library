package by.htp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.dao.BaseDaoImpl;
import by.htp.servis.SearchData;


public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BaseDaoImpl db = new BaseDaoImpl();
    private SearchData servis = new SearchData();
    private String pageUser = "/user.jsp";
	private String pageAdmin = "/admin.jsp";
	private String pageError = "/error.jsp";
	private User us = new User();
    public SimpleServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost");
//		
//		
//		String param = request.getParameter("action");
//		String paramUs = request.getParameter("action");
//		
//		
//		
//		
//		if(param.equals("action")) {
//			us = db.searchUser(request.getParameter("login"), request.getParameter("password"));
//			
//			if(us !=null && us.getRole().equals("user")) {
//				RequestDispatcher dispatcher = request.getRequestDispatcher(pageUser);
//				dispatcher.forward(request, response);
//				System.out.println("Test sucsesful");
//				
//			}else if(us !=null && us.getRole().equals("admin")){
//				System.out.println("admin");
//				RequestDispatcher dispatcher = request.getRequestDispatcher(pageAdmin);
//				dispatcher.forward(request, response);
//				System.out.println("Test sucsesful");				
//			}else {
//				System.out.println("error");
//				RequestDispatcher dispatcher = request.getRequestDispatcher(pageError);
//				dispatcher.forward(request, response);
//				System.out.println("Test sucsesful");				
//			}
//		}else if(param.equals("output")) {
//			System.out.println("output!!!");
//			list = db.searchBook("");
//			
//			System.out.println("razmer: " + list.size());
//			
//			
//			
//			
//				request.setAttribute("listbook", list);
//				//request.setAttribute("book_id");
//				//request.setAttribute("errStr", "hello friends!");
//			
//			if(us.getRole().equals("user")) {
//				RequestDispatcher dispatcher = request.getRequestDispatcher(pageUser);
//				dispatcher.forward(request, response);
//			}else if(us.getRole().equals("admin")) {
//				RequestDispatcher dispatcher = request.getRequestDispatcher(pageAdmin);
//				dispatcher.forward(request, response);
//			}			
//			
//		}else if(param.equals("delete")) {
//			System.out.println("delete!!!");
//			System.out.println();
//			int f= Integer.valueOf(request.getParameter("book_id"));
//			 
//			System.out.println(f);
//			db.delete(f);
//			RequestDispatcher dispatcher = request.getRequestDispatcher(pageAdmin);
//			dispatcher.forward(request, response);
//		}else if(param.equals("search")) {
//			System.out.println("search!!!");
//			String name = request.getParameter("search");
//			valuesList = db.search(name);
//			
//			System.out.println("razmer: " + valuesList.size());
//			request.setAttribute("listbook", valuesList);
//			
//			
//		}
//		else if(param.equals("add")) {
//			System.out.println("add!!!" + us.getRole());
//			if(us.getRole().equals("admin")) {	
//				System.out.println("criate");
//				//db.criate(new Book("asdf","adf",12,12));
//				db.criate(new Book(request.getParameter("addName"),request.getParameter("addAuthor"),Integer.valueOf(request.getParameter("addYear"))));
//			}
//			list = db.searchBook("");
//			
//			
//			for(int i = 0; i<list.size(); i++) {
//				request.setAttribute("user_name", list.get(i).getAuthorName());
//				request.setAttribute("errStr", list.get(i).getTittle());
//			}
//			
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher(pageAdmin);
//			dispatcher.forward(request, response);
//			
//		}
//		
//		else {
//			System.out.println("error");
//			RequestDispatcher dispatcher = request.getRequestDispatcher(pageError);
//			dispatcher.forward(request, response);
//			System.out.println("Test sucsesful");
//			
//			
//			
//			
//		}
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String action = request.getParameter("action");
		BaseAction currentAction = ActionManager.defineServerAction(action, request, response, us);
		us = currentAction.todoAction(request, response, us);
		
	}	
}


