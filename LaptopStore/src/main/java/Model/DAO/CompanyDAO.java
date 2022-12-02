package Model.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Bean.CompanyBean;

public class CompanyDAO {
	public ArrayList<CompanyBean> getAllCompany(){
		ArrayList<CompanyBean> result = new ArrayList<CompanyBean>();
	
		//Connect to database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/laptopstore";
			Connection con = DriverManager.getConnection(url,"root", "");
			Statement stmt =con.createStatement();
			
			String sql = "Select * from company";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	String corpId = rs.getString("companyId");
            	String corpName = rs.getString("companyName");
//            	String detail = rs.getString("detail");
   
            	CompanyBean corp = new CompanyBean();
            	corp.setCompanyId(corpId);
            	corp.setCompanyName(corpName);
//            	corp.setDetail(detail);
        		result.add(corp);
            }
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error:  " + e);
		}
		
		
		return result;
	}
}
