package Productdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Productdto.ManagerPitchdto;
import Productdto.ManagerProductsdto;
import Productdto.Pitchdto;
import Productdto.Productsdto;
import dao.ConnectionPerson;

public class ProductImlp implements ProductDao {
	List<Productsdto> list = new ArrayList<>();

	@Override
	public List<Productsdto> getAllDrink(int i) {
		List<Productsdto> list1 = new ArrayList<>();
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"SELECT P.ID_PRO,P.NAME_PRO,P.PRICE,O.QUANTITY, (P.PRICE*O.QUANTITY) AS 'TOTAL' FROM CUSTOMER AS C,PRODUCT AS P,ORDER_PRODUCT AS O WHERE C.ID="
							+ i + " AND C.ID=O.ID AND P.ID_PRO=O.ID_PRO");
			while (rs.next()) {
				Productsdto bd = new Productsdto();
				bd.setId(rs.getInt("ID_PRO"));
				bd.setName(rs.getString("NAME_PRO"));
				bd.setPrice(rs.getDouble("PRICE"));
				bd.setQuantity(rs.getInt("QUANTITY"));
				bd.setTotal(rs.getDouble("TOTAL"));

				list1.add(bd);
			}
			return list1;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public Productsdto getAllPryProduct(int i) {
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();

			ResultSet rs = stm.executeQuery(
					"  SELECT SUM(PR.PRICE*OP.QUANTITY) AS 'TOTAL' FROM CUSTOMER AS C, PRODUCT AS PR, ORDER_PRODUCT AS OP WHERE C.ID="
							+ i + " AND C.ID=OP.ID AND PR.ID_PRO=OP.ID_PRO");
			if (rs.next()) {
				Productsdto bd = new Productsdto();
				bd.setTotal(rs.getDouble("TOTAL"));
				return bd;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public Pitchdto getAllPryPitch(int i) {
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();

			ResultSet rs = stm.executeQuery(
					"   SELECT C.NAME, (HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60) AS 'HOUR', SUM( (T.PRICE*(HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60))) AS 'TOTAL'  FROM CUSTOMER AS C,PITCH AS P,ORDER_PITCH AS O,TIME_SLOT AS T\r\n"
							+ " WHERE C.ID=" + i + " AND C.ID=O.ID AND P.ID_P=O.ID_P AND T.ID_H=O.ID_H");
			if (rs.next()) {
				Pitchdto bd = new Pitchdto();
				bd.setTotal(rs.getDouble("TOTAL"));
				return bd;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<ManagerProductsdto> getManagerAllDrink() {
		List<ManagerProductsdto> list1 = new ArrayList<>();
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"SELECT O.ID_O, C.NAME, C.PHONE, C.ADDRESS, P.NAME_PRO,P.PRICE,O.QUANTITY, (P.PRICE*O.QUANTITY) AS 'TOTAL' FROM CUSTOMER AS C,PRODUCT AS P,ORDER_PRODUCT AS O WHERE C.ID=O.ID AND P.ID_PRO=O.ID_PRO");
			while (rs.next()) {
				ManagerProductsdto bd = new ManagerProductsdto();
				bd.setId(rs.getInt("ID_O"));
				bd.setNameCus(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setName(rs.getString("NAME_PRO"));
				bd.setPrice(rs.getDouble("PRICE"));
				bd.setQuantity(rs.getInt("QUANTITY"));
				bd.setTotal(rs.getDouble("TOTAL"));

				list1.add(bd);
			}
			return list1;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

//	SELECT P.NAME_P,O.H_S,O.H_F,T.PRICE, (HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60) AS 'HOUR',( (T.PRICE*(HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60))) AS 'TOTAL'  FROM CUSTOMER AS C,PITCH AS P,ORDER_PITCH AS O,TIME_SLOT AS T
//	 WHERE C.ID='1' AND C.ID=O.ID AND P.ID_P=O.ID_P AND T.ID_H=O.ID_H;
	public List<Pitchdto> getAllPitch(int i) {
		List<Pitchdto> list1 = new ArrayList<>();
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"	SELECT P.NAME_P,O.DATE_S,O.H_S,O.H_F,T.PRICE, (HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60) AS 'HOUR',( (T.PRICE*(HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60))) AS 'TOTAL'  FROM CUSTOMER AS C,PITCH AS P,ORDER_PITCH AS O,TIME_SLOT AS T\r\n"
							+ "	 WHERE C.ID=" + i + " AND C.ID=O.ID AND P.ID_P=O.ID_P AND T.ID_H=O.ID_H;");
			while (rs.next()) {
				Pitchdto bd = new Pitchdto();
				bd.setNamePitch(rs.getString("NAME_P"));
				bd.setDateStart(rs.getDate("DATE_S"));
				bd.setTimeStart(rs.getTime("H_S"));
				bd.setTimeFinish(rs.getTime("H_F"));
				bd.setQuantity(rs.getInt("PRICE"));
				bd.setTotal(rs.getDouble("TOTAL"));

				list1.add(bd);
			}
			return list1;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<ManagerPitchdto> getManagerAllPitch() {
		List<ManagerPitchdto> list1 = new ArrayList<>();
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"  SELECT O.ID_O,C.NAME, C.PHONE, C.ADDRESS,P.NAME_P,O.DATE_S,O.H_S,O.H_F,T.PRICE, (HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60) AS 'HOUR',( (T.PRICE*(HOUR(O.H_S-O.H_F)+(MINUTE(O.H_S-O.H_F))/60))) AS 'TOTAL'  FROM CUSTOMER AS C,PITCH AS P,ORDER_PITCH AS O,TIME_SLOT AS T\r\n"
							+ " WHERE C.ID=O.ID AND P.ID_P=O.ID_P AND T.ID_H=O.ID_H;");
			while (rs.next()) {
				ManagerPitchdto bd = new ManagerPitchdto();
				bd.setId(rs.getInt("ID_O"));
				bd.setNameCus(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setNamePitch(rs.getString("NAME_P"));
				bd.setDateStart(rs.getDate("DATE_S"));
				bd.setTimeStart(rs.getTime("H_S"));
				bd.setTimeFinish(rs.getTime("H_F"));
				bd.setQuantity(rs.getInt("PRICE"));
				bd.setTotal(rs.getDouble("TOTAL"));

				list1.add(bd);
			}
			return list1;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void insertCustomer(Productsdto product) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "INSERT INTO PRODUCT VALUES(NULL, ?, ?)";
			ps = connection.prepareStatement(queryString);

			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());

			ps.executeUpdate();
			list.add(product);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void insertOderProduct(Productsdto product, int i) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "INSERT INTO ORDER_PRODUCT VALUES(NULL,?, ?, ?)";
			ps = connection.prepareStatement(queryString);

			ps.setInt(1, i);
			ps.setInt(2, product.getId());
			ps.setInt(3, product.getQuantity());

			ps.executeUpdate();
			list.add(product);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void insertOderPitch(Pitchdto pitch, int i) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
//			ID_O INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
//			ID INT(4) NOT NULL,
//			ID_P INT(4) NOT NULL,
//			ID_H INT(1),
//			DATE_S DATE,
//			H_S TIME,
//			H_F TIME,
			connection = ConnectionPerson.getConnection();
			String queryString = "INSERT INTO ORDER_PITCH VALUES(NULL,?, ?, ?,?,?,?)";
			ps = connection.prepareStatement(queryString);

			ps.setInt(1, i);
			ps.setInt(2, pitch.getId());
			ps.setInt(3, 1);
			ps.setDate(4, pitch.getDateStart());
			ps.setTime(5, pitch.getTimeStart());
			ps.setTime(6, pitch.getTimeFinish());

			ps.executeUpdate();
			// list.add(product);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Productsdto getSearchProduct(String name) {
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT P.NAME_PRO,P.PRICE FROM PRODUCT AS P WHERE P.NAME_PRO='"+name+"'");
			if(rs.next()) {
				Productsdto bd = new Productsdto();
				bd.setName(rs.getString("NAME_PRO"));
				bd.setPrice(rs.getDouble("PRICE"));
//				bd.setQuantity(rs.getInt("QUANTITY"));
//				bd.setTotal(rs.getDouble("TOTAL"));

				return bd;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "DELETE FROM ORDER_PRODUCT WHERE ID_O = '"+id+"'";
			ps = connection.prepareStatement(queryString);

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deletePitch(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "DELETE FROM ORDER_PITCH WHERE ID_O = '"+id+"'";
			ps = connection.prepareStatement(queryString);

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void updateProduct(int b,int i) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "UPDATE ORDER_PRODUCT SET QUANTITY = ? WHERE ID_O = ?";
			ps = connection.prepareStatement(queryString);
			ps.setInt(1, b);
			ps.setInt(2, i);
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void updatePitch(Date a,int d) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			
			connection = ConnectionPerson.getConnection();
			String queryString = "UPDATE ORDER_PITCH SET DATE_S = ? WHERE ID_O = ?";
			
			ps = connection.prepareStatement(queryString);

			ps.setDate(1, a);
			ps.setInt(2, d);
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
