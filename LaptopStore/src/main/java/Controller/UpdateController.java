package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.CardBO;
import Model.BO.CompanyBO;
import Model.BO.LaptopBO;
import Model.Bean.*;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("modUpdateLaptop")!= null) {
			ArrayList<LaptopView> lapViewList = new ArrayList<LaptopView>(); 	
			  LaptopBO lapBO = new LaptopBO();
			  lapViewList = lapBO.getAllLaptopView(); 
			  request.setAttribute("lapViewList", lapViewList);  
			  String destination = "/UpdateView.jsp"; 
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination); 
			  rd.forward(request, response); 
		}
		if(request.getParameter("updatelapId")!= null) {
			LaptopBO lapBO = new LaptopBO();
			String lapId = request.getParameter("updatelapId");
			
			LaptopBean lap = lapBO.getLaptopById(lapId);
			 request.setAttribute("lapUpdate", lap);  
			 CompanyBO compBO = new CompanyBO();
			  CardBO cardBO= new CardBO();
			  ArrayList<CompanyBean> compList = new ArrayList<CompanyBean>() ; 
			  ArrayList<CardBean> cardList = new ArrayList<CardBean>(); 
			  compList = compBO.getAllCompany(); request.setAttribute("compList", compList);
			  cardList = cardBO.getAllCard(); request.setAttribute("cardList", cardList);
			  String destination = "/UpdateForm.jsp"; 
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination); 
			  rd.forward(request, response); 
		}
		if(request.getParameter("btnUpdateLaptop")!= null) {
			String lapId = request.getParameter("lapId");
			String lapName = request.getParameter("lapName");
			String companyId = request.getParameter("companyId");
			String cardId = request.getParameter("cardId");
			int price = Integer.parseInt(request.getParameter("price"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			LaptopBO lapBO = new LaptopBO();
			lapBO.updateLaptop(lapId, lapName, companyId, cardId, price, amount);
			ArrayList<LaptopView> lapViewList = new ArrayList<LaptopView>(); 	
			lapViewList = lapBO.getAllLaptopView();
			 request.setAttribute("lapViewList", lapViewList);  
			  String destination = "/UpdateView.jsp"; 
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination); 
			  rd.forward(request, response); 
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
