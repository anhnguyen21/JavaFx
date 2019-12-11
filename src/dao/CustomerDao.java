package dao;

import java.util.List;

import Model.Customer;
import PersonDto.CustomerDto;

public interface CustomerDao {
	public CustomerDto getPersonBySignUp(String username, String pass);

	public List<CustomerDto> getAllCustomer();

	public void insertCustomer(CustomerDto person);

	public void updateUser(CustomerDto user);

	public CustomerDto getCustomerByUserName(String UserName);

	public CustomerDto getCustomerById(int i);

	public List<CustomerDto> search(CustomerDto person);

	public void deleteCustomer(int id);

	public List<CustomerDto> getCustomerbyID(int i);

	public CustomerDto getIDBySignUp(int id);

	public List<CustomerDto> searchPass(CustomerDto person);

	public void updatePass(CustomerDto user);

	public List<CustomerDto> getAllCustomers();

	public List<CustomerDto> searchCus(CustomerDto customer);
	
	public void updateCustomer(Customer person);
	
	public void insertAddCustomer(CustomerDto customer);
	
}
