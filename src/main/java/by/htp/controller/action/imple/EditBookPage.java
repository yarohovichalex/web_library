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
import by.htp.dao.BaseDao;
import by.htp.dao.impl.EditBookDaoImpl;

public class EditBookPage implements BaseAction{
	private User us;

	public EditBookPage(User us) {
		this.us = us;
	}

	@Override
	public User todoAction(HttpServletRequest request, HttpServletResponse response, User us) throws ServletException, IOException {
		BaseDao dao = new EditBookDaoImpl();
		System.out.println("Edit page!!!");
		String bookid = request.getParameter("edit_book_id");
		int f= Integer.parseInt(bookid);
		String editBookName = request.getParameter("editName");
		String editAuthorName = request.getParameter("editAuthor");
		String editStringDate = request.getParameter("editDate");
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		Date date=null;
			try {
				date = format.parse(editStringDate);
				dao.editBook(f, new Book(editBookName, editAuthorName, date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		System.out.println(editStringDate+" дата");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_ADMIN);
		dispatcher.forward(request, response);
		
		
		return us;
	}
	
}
