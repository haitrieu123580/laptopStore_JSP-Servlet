package Model.BO;

import java.util.ArrayList;

import Model.Bean.CardBean;
import Model.DAO.CardDAO;

public class CardBO {
	CardDAO cardDAO = new CardDAO();
	public ArrayList<CardBean> getAllCard() {
		return cardDAO.getAllCard();
	}
	

}
