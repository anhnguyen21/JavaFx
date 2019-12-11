package Bll;

import PersonDto.CustomerDto;
import PersonDto.ManagerDto;
import dao.CustomerDao;
import dao.CustormerImpl;
import dao.ManagerDao;
import dao.ManagerImpl;

public class sign_upCutormer implements Sign_up {
	CustomerDao customerDao=new CustormerImpl() ;
	ManagerDao managerDao=new ManagerImpl() ;
		
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		CustomerDto customer = customerDao.getPersonBySignUp(username, password);
		if (customer != null) {
			return true;
		} else {
			return false;
		}
	}
	public boolean checkLoginManger(String username, String password)
	{
		ManagerDto manager = managerDao.getPersonBySignUp(username, password);
		if (manager !=null) {
			return true;
		} else {
			return false;
		}
	}
 
}

