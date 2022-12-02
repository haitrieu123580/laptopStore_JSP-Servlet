package Model.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.Bean.LaptopBean;

public class LaptopDAO{
	private final ConnectDB connectDB = new ConnectDB();
    private final Connection con = connectDB.getAConnect();
	private final String search = "select * from laptop where lapName like concat('%' , ? ,'%')";
	
	public ArrayList<LaptopBean> getAllLaptop(){
		
		ArrayList<LaptopBean> result = new ArrayList<LaptopBean>();
	
		//Connect to database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/laptopstore";
			Connection con = DriverManager.getConnection(url,"root", "");
			Statement stmt =con.createStatement();
			
			String sql = "Select * from laptop";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	String lapId = rs.getString("lapId");
            	String lapName = rs.getString("lapName");
            	String companyId = rs.getString("companyId");
            	String cardId = rs.getString("cardId");
            	int price = rs.getInt("price");
            	int amount = rs.getInt("amount");
            	LaptopBean lap = new LaptopBean();
            	lap.setCardId(cardId);
            	lap.setLapName(lapName);
            	lap.setCompanyId(companyId);
            	lap.setLapID(lapId);
            	lap.setPrice(price);
            	lap.setAmount(amount);
        		result.add(lap);
            }
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error:  " + e);
		}
		return result;
	}
	public LaptopBean getLaptopById(String lapId) {
		LaptopBean result = new LaptopBean();
		//Connect to database
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/laptopstore";
					Connection con = DriverManager.getConnection(url,"root", "");
					Statement stmt =con.createStatement();
					
					String sql = "Select * from laptop where lapId  = '"+lapId+"'";
				
		            ResultSet rs = stmt.executeQuery(sql);
		            
		            while(rs.next()) {
		            	
		            	String lapName = rs.getString("lapName");
		            	String companyId = rs.getString("companyId");
		            	String cardId = rs.getString("cardId");
		            	int price = rs.getInt("price");
		            	int amount = rs.getInt("amount");
		            	result.setLapID(lapId);
		            	result.setCardId(cardId);
		            	result.setLapName(lapName);
		            	result.setCompanyId(companyId);
		            	result.setLapID(lapId);
		            	result.setPrice(price);
		            	result.setAmount(amount);
		        		;
		            }
					
				} catch (Exception e) {
					// TODO: handle exception
					
					System.out.println("Error:  " + e);
				}
		return result;
	}
	public void updateLaptop(String lapId, String lapName, String companyId, String cardId, int price, int amount ) {
		//Connect to database
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/laptopstore";
					Connection con = DriverManager.getConnection(url,"root", "");
					Statement stmt =con.createStatement();
					
					String sql = "update laptop set lapName = '"+lapName+"', companyId = '" + companyId +"', cardId = '" + cardId+"', price ="
							+ price + ", amount = " + amount +" where lapId = '"+lapId+"'";
					System.out.println(sql);
		            stmt.executeUpdate(sql);
		            stmt.close();		            
					
				} catch (Exception e) {
					// TODO: handle exception
					
					System.out.println("Error:  " + e);
				}
	}
	public ArrayList<LaptopBean> searchLaptopByName(String lapName) {
        ArrayList<LaptopBean> listLaps = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(search);
            preparedStatement.setString(1, lapName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String labId = rs.getString("lapId");
                String labName2 = rs.getString("lapName");
                String companyId = rs.getString("companyId");
                String cardId = rs.getString("cardId");
                int price = Integer.parseInt(rs.getString("price"));
                int amount = Integer.parseInt(rs.getString("amount"));
                
                LaptopBean lap = new LaptopBean();
            	lap.setCardId(cardId);
            	lap.setLapName(labName2);
            	lap.setCompanyId(companyId);
            	lap.setLapID(labId);
            	lap.setPrice(price);
            	lap.setAmount(amount);
                
            	listLaps.add(lap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listLaps;
    }
	public static void addLaptop(String lapId, String lapName, String companyId, String cardId, String price,
			String amount) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/laptopstore";
			Connection con = DriverManager.getConnection(url, "root", "");
			String sql = "INSERT INTO `laptop`(`lapId`, `lapName`, `companyId`, `cardId`, `price`, `amount`) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, lapId);
			stmt.setString(2, lapName);
			stmt.setString(3, companyId);
			stmt.setString(4, cardId);
			stmt.setString(5, price);
			stmt.setString(6, amount);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deleteLaptop(String lapId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/laptopstore";
			Connection con = DriverManager.getConnection(url, "root", "");
			String sql = "DELETE FROM `laptop` WHERE lapId = ?";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, lapId);
			stmt.executeUpdate();
		} catch (Exception e) {
			
		}

	}
}
