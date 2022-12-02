package Model.BO;

import java.util.ArrayList;

import Model.Bean.*;
import Model.DAO.*;


public class LaptopBO {
	LaptopDAO laptopDAO= new LaptopDAO();
	CardDAO cardDAO = new CardDAO();
	CompanyDAO comDAO = new CompanyDAO();
	public void updateLaptop(String lapId, String lapName, String companyId, String cardId, int price, int amount ) {
		laptopDAO.updateLaptop(lapId, lapName, companyId, cardId, price, amount);
	}
	public LaptopBean getLaptopById(String lapId) {
		return laptopDAO.getLaptopById(lapId);
	}
	
	public ArrayList<LaptopBean> getAllLaptop() {
		return laptopDAO.getAllLaptop();
	}
	public ArrayList<LaptopView> getAllLaptopView() {
		
		ArrayList<LaptopBean> listLap = laptopDAO.getAllLaptop();
		ArrayList<LaptopView> listLapView = new ArrayList<LaptopView>() ;
		ArrayList<CardBean> listCard = cardDAO.getAllCard();
		ArrayList<CompanyBean> listCom = comDAO.getAllCompany();
		for (int i = 0; i<listLap.size();i++) {
			
			listLapView.add(this.convertLapbeanToLapView(listLap.get(i)));
		}
		return listLapView;
	}
	public LaptopView convertLapbeanToLapView(LaptopBean lapBean) {
		ArrayList<CardBean> listCard = cardDAO.getAllCard();
		ArrayList<CompanyBean> listCom = comDAO.getAllCompany();
		LaptopView lapView = new LaptopView();
		
		lapView.setLapId(lapBean.getLapID());
		lapView.setLapName(lapBean.getLapName());
		lapView.setAmount(lapBean.getAmount());
		lapView.setPrice(lapBean.getPrice());
		for (int j = 0; j<listCard.size();j++)
		{
			if(lapBean.getCardId().equals(listCard.get(j).getCardId()))
			{
				lapView.setCardName(listCard.get(j).getCardName());				
			}
		}
		for (int k = 0; k<listCom.size();k++)
		{
			if(lapBean.getCompanyId().equals(listCom.get(k).getCompanyId()))
			{
				lapView.setCompanyName(listCom.get(k).getCompanyName());	
			}
		}
		return lapView;
	}
	public ArrayList<LaptopView> searchLaptop(String name){
		ArrayList<LaptopBean> listLap = laptopDAO.searchLaptopByName(name);
		ArrayList<LaptopView> listLapView = new ArrayList<LaptopView>() ;
		ArrayList<CardBean> listCard = cardDAO.getAllCard();
		ArrayList<CompanyBean> listCom = comDAO.getAllCompany();
		for (int i = 0; i<listLap.size();i++) {
			LaptopView temp = new LaptopView();
			temp.setLapName(listLap.get(i).getLapName());
			temp.setAmount(listLap.get(i).getAmount());
			temp.setPrice(listLap.get(i).getPrice());
			for (int j = 0; j<listCard.size();j++)
			{
				
				if(listLap.get(i).getCardId().equals(listCard.get(j).getCardId()))
				{

					temp.setCardName(listCard.get(j).getCardName());
					
				}
			}
			for (int k = 0; k<listCom.size();k++)
			{
				if(listLap.get(i).getCompanyId().equals(listCom.get(k).getCompanyId()))
				{
					temp.setCompanyName(listCom.get(k).getCompanyName());
					
				}
			}
			listLapView.add(temp);
		}
        return listLapView;
    }
	public ArrayList<LaptopView> searchLaptopByCompanyID(String compID)
	{
		ArrayList<LaptopView> listLapView = this.getAllLaptopView() ;
		ArrayList<LaptopView> listLapViewSearch = new ArrayList<LaptopView>() ;
		CompanyBO comBO = new CompanyBO();
		
		for (int i = 0; i<listLapView.size();i++) {
			if(listLapView.get(i).getCompanyName().equals(comBO.getCompNameById(compID)))
			{
				LaptopView temp = new LaptopView();
				temp.setLapName(listLapView.get(i).getLapName());
				temp.setAmount(listLapView.get(i).getAmount());
				temp.setPrice(listLapView.get(i).getPrice());
				temp.setCardName(listLapView.get(i).getCardName());
				temp.setCompanyName(listLapView.get(i).getCompanyName());
				
				listLapViewSearch.add(temp);
			}
		}
		return listLapViewSearch;
	}
	public static void addLaptop(String lapId, String lapName, String companyId, String cardId, String price,
			String amount) {
		LaptopDAO.addLaptop(lapId, lapName, companyId, cardId, price, amount);
	}

	public static void deleteLaptop(String lapId) {
		LaptopDAO.deleteLaptop(lapId);
	}
}
