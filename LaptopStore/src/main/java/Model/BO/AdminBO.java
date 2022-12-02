package Model.BO;

import Model.DAO.AdminDAO;

public class AdminBO {
	public static boolean isExistAccount(String username, String password) {
		return AdminDAO.isExistAccount(username, password);
	}
}
