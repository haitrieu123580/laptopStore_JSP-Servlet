package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.AdminBO;

@WebServlet("/CheckLoginController")
public class CheckLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckLoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (AdminBO.isExistAccount(username, password)) {
			response.sendRedirect("MainPage.jsp");
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

}
