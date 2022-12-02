package Model.BO;

import java.util.ArrayList;

import Model.Bean.CompanyBean;
import Model.DAO.CompanyDAO;

public class CompanyBO {
	CompanyDAO companyDAO = new CompanyDAO();
	public ArrayList<CompanyBean> getAllCompany() {
		return companyDAO.getAllCompany();
	}
	public String getCompNameById(String id)
	{
		ArrayList<CompanyBean> temp = this.getAllCompany();
		for(int i = 0; i<temp.size();i++)
		{
			if(temp.get(i).getCompanyId().equals(id))
			{
				return temp.get(i).getCompanyName();
			}
		}
		
		return null;
	}
}
