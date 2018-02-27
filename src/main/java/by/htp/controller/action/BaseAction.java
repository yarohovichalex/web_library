package by.htp.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.User;

public interface BaseAction {
	/**
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	User todoAction(HttpServletRequest request, HttpServletResponse response, User us) throws ServletException, IOException ;
}

	