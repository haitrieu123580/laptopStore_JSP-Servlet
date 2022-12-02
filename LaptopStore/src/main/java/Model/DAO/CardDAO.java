package Model.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Bean.CardBean;

public class CardDAO {
	public ArrayList<CardBean> getAllCard(){
		ArrayList<CardBean> result = new ArrayList<CardBean>();
	
		//Connect to database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/laptopstore";
			Connection con = DriverManager.getConnection(url,"root", "");
			Statement stmt =con.createStatement();
			
			String sql = "Select * from graphic_card";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	String cardId = rs.getString("cardId");
            	String cardName = rs.getString("cardName");
            	String detail = rs.getString("detail");
   
            	CardBean card = new CardBean();
            	card.setCardId(cardId);
            	card.setCardName(cardName);
            	card.setDetail(detail);
        		result.add(card);
            }
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error:  " + e);
		}
		
		
		return result;
	}
}
