package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Productdto.Productsdto;

public class ProductIplm implements ProductDao{
	static List<Productsdto> list = new ArrayList<>();
	@Override
	public List<Productsdto> getAllCustomer() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM PRODUCT");
			while (rs.next()) {
				Productsdto bd = new Productsdto();
				bd.setId(rs.getInt("ID_PRO"));
				bd.setName(rs.getString("NAME_PRO"));
				bd.setPrice(rs.getDouble("PRICE"));
				bd.setPrice(rs.getDouble("QUANTITY"));
			
				list.add(bd);
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
