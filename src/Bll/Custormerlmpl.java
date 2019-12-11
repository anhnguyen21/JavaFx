package Bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import Model.ManagerPitch;
import Model.ManagerProduct;
import Model.Pitch;
import Model.Product;
import PersonDto.CustomerDto;
import Productdao.ProductDao;
import Productdao.ProductImlp;
import Productdto.ManagerPitchdto;
import Productdto.ManagerProductsdto;
import Productdto.Pitchdto;
import Productdto.Productsdto;
import dao.CustomerDao;
import dao.CustormerImpl;

public class Custormerlmpl implements ICustomer {
	public List<Customer> getAllCustomer()
	{
		CustomerDao customerDao=new CustormerImpl() ;
		List<CustomerDto> customer = customerDao.getAllCustomer();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		List<Customer> list = new ArrayList<>();
		for (CustomerDto cus : customer) {
			Customer customer1 = new Customer();
			customer1.setId(cus.getId());
			customer1.setAccount(cus.getAccount());
			customer1.setPass(cus.getPassword());
			customer1.setName(cus.getName());
			customer1.setAddress(cus.getAddress());
			customer1.setGender(cus.getGender());
			customer1.setBirthday(dateFormat.format(cus.getBirthday()));
			customer1.setPhone(cus.getPhone());
			
			list.add(customer1);
		}
		return list;
	}
	
	public List<Customer> getAllCustomer(CustomerDto customer2) {
		CustomerDao customerDao = new CustormerImpl();
		List<CustomerDto> customer = customerDao.searchCus(customer2);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		List<Customer> list = new ArrayList<>();
		for (CustomerDto cus : customer) {
			Customer customer1 = new Customer();
			customer1.setId(cus.getId());
			customer1.setAccount(cus.getAccount());
			customer1.setPass(cus.getPassword());
			customer1.setName(cus.getName());
			customer1.setAddress(cus.getAddress());
			customer1.setGender(cus.getGender());
			customer1.setBirthday(dateFormat.format(cus.getBirthday()));
			customer1.setPhone(cus.getPhone());

			list.add(customer1);
		}
		return list;
	}

	public List<Product> getAllProduct(int i) {
		ProductDao productdao=new ProductImlp();
		List<Productsdto> product= productdao.getAllDrink(i);
		
		List<Product> list=new ArrayList<>();
		for(Productsdto pro: product)
		{
			Product pro1=new Product();
			pro1.setId(pro.getId());
			pro1.setName(pro.getName());
			pro1.setPrice(pro.getPrice());
			pro1.setQuantity(pro.getQuantity());
			pro1.setTotal(pro.getTotal());
			
			list.add(pro1);
		}
		return list;
	}
	public List<ManagerProduct> getAllProduct()
	{
		ProductDao productdao=new ProductImlp();
		List<ManagerProductsdto> product= productdao.getManagerAllDrink();
		int i=1;
		List<ManagerProduct> list3=new ArrayList<>();
		for(ManagerProductsdto pro: product)
		{
			//C.NAME, C.PHONE, C.ADDRESS, P.NAME_PRO,P.PRICE,O.QUANTITY, (P.PRICE*O.QUANTITY) AS 'TOTAL'
			ManagerProduct pro1=new ManagerProduct();
			pro1.setId(pro.getId());
			pro1.setNameCus(pro.getNameCus());
			pro1.setPhone(pro.getPhone());
			pro1.setAddress(pro.getAddress());
			pro1.setNamePro(pro.getName());
			pro1.setPrice(pro.getPrice());
			pro1.setQuantity(pro.getQuantity());
			pro1.setTotal(pro.getTotal());
			
			list3.add(pro1);
		}
		return list3;
	}

	@Override
	public List<Pitch> getAllPitch(int i) {
		ProductDao productdao=new ProductImlp();
		List<Pitchdto> pitch= productdao.getAllPitch(i);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat format=new SimpleDateFormat("HH:mm");
		
		List<Pitch> list=new ArrayList<>();
		for(Pitchdto p: pitch)
		{
//			bd.setNamePitch(rs.getString("NAME_P"));
//			bd.setDateStart(rs.getDate("DATE_S"));
//			bd.setTimeStart(rs.getTime("H_S"));
//			bd.setTimeFinish(rs.getTime("H_F"));
//			bd.setQuantity(rs.getInt("PRICE"));
//			bd.setTotal(rs.getDouble("TOTAL"));
			Pitch p1=new Pitch();
			p1.setNamePitch(p.getNamePitch());
			p1.setDateStart(dateFormat.format(p.getDateStart()));
			p1.setTimeStart(format.format(p.getTimeStart()));
			p1.setTimeFinish(format.format(p.getTimeFinish()));
			p1.setQuantity(p.getQuantity());
			p1.setTotal(p.getTotal());
			
			list.add(p1);
		}
		return list;
	}
	public List<ManagerPitch> getAllPitch()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat format=new SimpleDateFormat("HH:mm");
		ProductDao productdao=new ProductImlp();
		List<ManagerPitchdto> product= productdao.getManagerAllPitch();

		List<ManagerPitch> list3=new ArrayList<>();
		for(ManagerPitchdto pro: product)
		{
			//C.NAME, C.PHONE, C.ADDRESS, P.NAME_PRO,P.PRICE,O.QUANTITY, (P.PRICE*O.QUANTITY) AS 'TOTAL'
			ManagerPitch pro1=new ManagerPitch();
			pro1.setId(pro.getId());
			pro1.setNameCus(pro.getNameCus());
			pro1.setPhone(pro.getPhone());
			pro1.setAddress(pro.getAddress());
			pro1.setNamePitch(pro.getNamePitch());
			pro1.setDateStart(dateFormat.format(pro.getDateStart()));
			pro1.setTimeStart(format.format(pro.getTimeStart()));
			pro1.setTimeFinish(format.format(pro.getTimeFinish()));
			pro1.setQuantity(pro.getQuantity());
			pro1.setTotal(pro.getTotal());
			
			list3.add(pro1);
		}
		return list3;
	}

}
