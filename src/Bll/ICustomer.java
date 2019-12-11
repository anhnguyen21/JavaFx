package Bll;

import java.util.List;

import Model.Customer;
import Model.ManagerPitch;
import Model.ManagerProduct;
import Model.Pitch;
import Model.Product;
import PersonDto.CustomerDto;

public interface ICustomer {
	
	public List<Customer> getAllCustomer();
	public List<Customer> getAllCustomer(CustomerDto customer2);
	
	public List<Product> getAllProduct(int i);
	
	public List<ManagerProduct> getAllProduct();
	
	public List<Pitch> getAllPitch(int i);
	
	public List<ManagerPitch> getAllPitch();

}
