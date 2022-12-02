package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.CardBO;
import Model.BO.CompanyBO;
import Model.Bean.CardBean;
import Model.Bean.CompanyBean;
import Model.DAO.LaptopDAO;

@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<CompanyBean> compList = null;
		ArrayList<CardBean> cardList = null;
		CompanyBO compBO = new CompanyBO();
		CardBO cardBO = new CardBO();
		compList = compBO.getAllCompany();
		request.setAttribute("compList", compList);
		cardList = cardBO.getAllCard();
		request.setAttribute("cardList", cardList);
		request.getRequestDispatcher("AddLaptopForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lapId = request.getParameter("lapId");
		String lapName = request.getParameter("lapName");
		String companyId = request.getParameter("companyId");
		String cardId = request.getParameter("cardId");
		String price = request.getParameter("price");
		String amount = request.getParameter("amount");

		LaptopDAO.addLaptop(lapId, lapName, companyId, cardId, price, amount);
		doGet(request, response);
	}

}
