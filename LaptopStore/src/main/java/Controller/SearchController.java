package Controller;

import Model.BO.*;
import Model.Bean.CompanyBean;
import Model.Bean.LaptopBean;
import Model.Bean.LaptopView;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("modSearchLaptop") != null) {
			response.setContentType("text/html; charset=ISO-8859-1");
			// search all
			LaptopBO laptopBO = new LaptopBO();
			ArrayList<LaptopView> lapViewList = laptopBO.getAllLaptopView();
			request.setAttribute("lapViewList", lapViewList);

			// search name
			String lapName = request.getParameter("lapName");
			if (lapName != null) {
				request.setAttribute("lapName", lapName);
				lapViewList = laptopBO.searchLaptop(lapName);
				request.setAttribute("lapViewList", lapViewList);
				// request.setAttribute("employees", employees);

			}
			CompanyBO compBO = new CompanyBO();
			ArrayList<CompanyBean> compList = compBO.getAllCompany(); 
			request.setAttribute("compList", compList);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
		}
		if (request.getParameter("modSearchCompany") != null)
			{
			
				response.setContentType("text/html; charset=ISO-8859-1");
				CompanyBO compBO = new CompanyBO();
				ArrayList<CompanyBean> compList = compBO.getAllCompany(); 
				request.setAttribute("compList", compList);
				
				
				LaptopBO laptopBO = new LaptopBO();
				String companyId = request.getParameter("companyId");
				ArrayList<LaptopView> lapViewList = laptopBO.searchLaptopByCompanyID(companyId);
				//System.out.println(lapViewList.get(0).getCompanyName());
				request.setAttribute("lapViewList", lapViewList);
				request.getRequestDispatcher("Search.jsp").forward(request, response);
			}

//        String lapName = request.getParameter("lapName");
//		LaptopBO laptopBO = new LaptopBO();
//		ArrayList<LaptopView> LaptopList = null;
//		LaptopList = laptopBO.searchLaptop(lapName);
//		request.setAttribute("lapViewList", LaptopList);
//		String destination = "Search.jsp"; 
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination); 
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);

	}

}
