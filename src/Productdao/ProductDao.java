package Productdao;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Model.ManagerProduct;
import Productdto.ManagerPitchdto;
import Productdto.ManagerProductsdto;
import Productdto.Pitchdto;
import Productdto.Productsdto;
public interface ProductDao {
	public List<Productsdto> getAllDrink(int i);
	public List<ManagerProductsdto> getManagerAllDrink();
	public List<Pitchdto> getAllPitch(int i);
	public Productsdto getAllPryProduct(int i);
	public Pitchdto getAllPryPitch(int i);
	public List<ManagerPitchdto> getManagerAllPitch();
	public void insertCustomer(Productsdto product);
	public void insertOderProduct(Productsdto product,int i);
	public void insertOderPitch(Pitchdto pitch,int i);
	public Productsdto getSearchProduct(String name);
	public void deleteProduct(int id);
	public void updateProduct(int b,int i);
	public void deletePitch(int id);
	public void updatePitch(Date a,int d);
	}
