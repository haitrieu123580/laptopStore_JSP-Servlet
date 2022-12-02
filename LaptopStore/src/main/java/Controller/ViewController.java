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
import Model.Bean.CardBean;
import Model.Bean.CompanyBean;
import Model.Bean.LaptopView;

@WebServlet("/ViewController")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("modViewLaptop")!= null) {
			
			ArrayList<LaptopView> lapViewList = null; 	
			  LaptopBO lapBO = new LaptopBO();
			  lapViewList = lapBO.getAllLaptopView(); 
			  request.setAttribute("lapViewList", lapViewList);  
			  String destination = "/LaptopList.jsp"; 
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination); 
			  rd.forward(request, response); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
