package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.LaptopBO;
import Model.Bean.LaptopView;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("modDeleteLaptop") != null) {
			ArrayList<LaptopView> lapViewList = new ArrayList<LaptopView>();
			LaptopBO lapBO = new LaptopBO();
			lapViewList = lapBO.getAllLaptopView();
			request.setAttribute("lapViewList", lapViewList);
			request.getRequestDispatcher("DeleteLaptopView.jsp").forward(request, response);
		}
		if (request.getParameter("deletelapId") != null) {
			String lapId = request.getParameter("deletelapId");
			LaptopBO.deleteLaptop(lapId);
			ArrayList<LaptopView> lapViewList = new ArrayList<LaptopView>();
			LaptopBO lapBO = new LaptopBO();
			lapViewList = lapBO.getAllLaptopView();
			request.setAttribute("lapViewList", lapViewList);
			request.getRequestDispatcher("DeleteLaptopView.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
