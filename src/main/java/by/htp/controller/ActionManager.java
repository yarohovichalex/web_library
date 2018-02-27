package by.htp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.controller.action.imple.AddBookImpl;
import by.htp.controller.action.imple.Autorizate;
import by.htp.controller.action.imple.DeleteBook;
import by.htp.controller.action.imple.EditBookPage;
import by.htp.controller.action.imple.OutputAllBook;
import by.htp.controller.action.imple.SearchBookImpl;
import by.htp.controller.action.imple.ToEditBookPage;

public class ActionManager {
		
	public static BaseAction defineServerAction(String action, HttpServletRequest request, HttpServletResponse response, User us) throws ServletException, IOException {
		BaseAction act = null;
		switch(action) {
			case "action":{				
				act = new Autorizate(us);				
				break;
			}
			case "output":{
				act = new OutputAllBook(us);
				break;
			}
			case "search":{
				act = new SearchBookImpl(us);
				break;
			}
			case "add":{
				act = new AddBookImpl(us);
				break;
			}
			case "ToEdit":{
				act = new ToEditBookPage(us);
				break;
			}
			case "edit":{
				act = new EditBookPage(us);
				break;
			}
			case "delete":{
				act = new DeleteBook(us);
				break;
			}
			default :
				//TODO
				System.out.println("Error"); 
		}
		 return act;
}

}
