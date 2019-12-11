package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import PersonDto.CustomerDto;


public class CustormerImpl implements CustomerDao {
	List<CustomerDto> list1 = new ArrayList<>();

	@Override
	public CustomerDto getPersonBySignUp(String username, String pass) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stm = null;
		try {
			connection = ConnectionPerson.getConnection();
			stm = connection.createStatement();
			ResultSet rs = stm
					.executeQuery("SELECT *FROM CUSTOMER WHERE USERNAME='" + username + "'AND PASS='" + pass + "'");
			if (rs.next()) {
				CustomerDto bd = new CustomerDto();
				bd.setId(rs.getInt("ID"));
				bd.setName(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setGender(rs.getString("GENDER"));
				bd.setBirthday(rs.getDate("DOB"));
				bd.setAccount(rs.getString("USERNAME"));
				bd.setPassword(rs.getString("PASS"));

				return bd;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<CustomerDto> getAllCustomer() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM CUSTOMER");
			while (rs.next()) {
				CustomerDto bd = new CustomerDto();
				bd.setId(rs.getInt("ID"));
				bd.setName(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setGender(rs.getString("GENDER"));
				bd.setBirthday(rs.getDate("DOB"));
				bd.setAccount(rs.getString("USERNAME"));
				bd.setPassword(rs.getString("PASS"));
				list1.add(bd);
			}
			return list1;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustormerImpl();
		List<CustomerDto> list = customerDao.getAllCustomer();
		for (CustomerDto customer : list) {
			CustomerDto cus = new CustomerDto();
			cus.setId(customer.getId());
			cus.setName(customer.getName());
			cus.setAddress(customer.getAddress());
			cus.setPhone(customer.getPhone());
			cus.setGender(customer.getGender());
			cus.setBirthday(customer.getBirthday());
			cus.setAccount(customer.getAccount());
			cus.setPassword(customer.getPassword());
			list1.add(cus);
		}
		return list1;
	}

	public void insertCustomer(CustomerDto customer) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "INSERT INTO CUSTOMER VALUES(NULL, ?, ?, ?, ?, ?,?,?)";
			ps = connection.prepareStatement(queryString);

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getPhone());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getGender());
			ps.setDate(5, customer.getBirthday());
			ps.setString(6, customer.getAccount());
			ps.setString(7, customer.getPassword());

			ps.executeUpdate();
			list1.add(customer);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<CustomerDto> search(CustomerDto person) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();

			StringBuffer query = new StringBuffer("SELECT * FROM CUSTOMER");
			query.append(" WHERE 1 > 0 ");
			if (person.getAccount() != null) {
				query.append(" AND USERNAME LIKE '%" + person.getAccount() + "%'");
			}
			if (person.getPhone() != null) {
				query.append(" AND PHONE = '" + person.getPhone() + "'");
			}
			ResultSet rs = stmt.executeQuery(query.toString());

			List<CustomerDto> list = new ArrayList<>();
			while (rs.next()) {
				CustomerDto userDto = new CustomerDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setAccount(rs.getString("USERNAME"));
				userDto.setPhone(rs.getString("PHONE"));

				list.add(userDto);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDto> searchPass(CustomerDto person) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();

			StringBuffer query = new StringBuffer("SELECT * FROM CUSTOMER");
			query.append(" WHERE 1 > 0 ");
			if (person.getPassword() != null) {
				query.append(" AND PASS = '" + person.getPassword() + "'");
			}
			ResultSet rs = stmt.executeQuery(query.toString());

			List<CustomerDto> list = new ArrayList<>();
			while (rs.next()) {
				CustomerDto userDto = new CustomerDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setPassword(rs.getString("PASS"));

				list.add(userDto);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void updateUser(CustomerDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "UPDATE CUSTOMER SET PASS = ? WHERE USERNAME = ?";
			ps = connection.prepareStatement(queryString);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getAccount());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updatePass(CustomerDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "UPDATE CUSTOMER SET PASS = ? WHERE ID = ?";
			ps = connection.prepareStatement(queryString);
			ps.setString(1, user.getPassword());
			ps.setInt(2, user.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public CustomerDto getCustomerById(int i) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stm = null;
		try {
			connection = ConnectionPerson.getConnection();
			stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM CUSTOMER WHERE ID='" + i + "'");
			if (rs.next()) {
				CustomerDto bd = new CustomerDto();
				bd.setId(rs.getInt("ID"));
				bd.setName(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setAccount(rs.getString("USERNAME"));
				bd.setPassword(rs.getString("PASS"));

				return bd;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CustomerDto getCustomerByUserName(String UserName) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stm = null;
		try {
			connection = ConnectionPerson.getConnection();
			stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM CUSTOMER WHERE USERNAME='" + UserName + "'");
			if (rs.next()) {
				CustomerDto bd = new CustomerDto();
				bd.setName(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setAccount(rs.getString("USERNAME"));
				bd.setPassword(rs.getString("PASS"));

				return bd;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "DELETE FROM CUSTOMER WHERE ID = '" + id + "'";
			ps = connection.prepareStatement(queryString);

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<CustomerDto> getCustomerbyID(int i) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM CUSTOMER WHERE ID = '" + i + "'");
			List<CustomerDto> cus = new ArrayList<CustomerDto>();
			while (rs.next()) {
				CustomerDto bd = new CustomerDto();
				bd.setId(rs.getInt("ID"));
				bd.setName(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setGender(rs.getString("GENDER"));
				bd.setBirthday(rs.getDate("DOB"));
				bd.setAccount(rs.getString("USERNAME"));
				bd.setPassword(rs.getString("PASS"));
				cus.add(bd);
			}
			return cus;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public CustomerDto getIDBySignUp(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stm = null;
		try {
			connection = ConnectionPerson.getConnection();
			stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM CUSTOMER WHERE ID='" + id + "'");
			if (rs.next()) {
				CustomerDto bd = new CustomerDto();
				bd.setId(rs.getInt("ID"));
				bd.setName(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setGender(rs.getString("GENDER"));
				bd.setBirthday(rs.getDate("DOB"));
				bd.setAccount(rs.getString("USERNAME"));
				bd.setPassword(rs.getString("PASS"));

				return bd;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<CustomerDto> searchCus(CustomerDto customer) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();

			StringBuffer query = new StringBuffer("SELECT * FROM CUSTOMER");
			query.append(" WHERE 1 > 0 ");
			if (customer.getAccount() != null) {
				query.append(" AND USERNAME = '" + customer.getAccount() + "'");
			}
			if (customer.getAddress() != null) {
				query.append(" AND ADDRESS LIKE '%" + customer.getAddress() + "%' ");
			}
			if (customer.getBirthday() != null) {
				query.append(" AND DOB = '" + customer.getBirthday() + "'");
			}
			if (customer.getGender() != null) {
				query.append(" AND GENDER = '" + customer.getGender() + "' ");
			}
			if (customer.getPhone() != null) {
				query.append(" AND PHONE = '" + customer.getPhone() + "' ");
			}
			if (customer.getName() != null) {
				query.append(" AND NAME like '%" + customer.getName() + "'");
			}

			ResultSet rs = stmt.executeQuery(query.toString());

			List<CustomerDto> list = new ArrayList<>();
			while (rs.next()) {
				CustomerDto cusDto = new CustomerDto();
				cusDto.setId(rs.getInt("ID"));
				cusDto.setName(rs.getString("NAME"));
				cusDto.setPassword(rs.getString("PASS"));
				cusDto.setBirthday(rs.getDate("DOB"));
				cusDto.setPhone(rs.getString("PHONE"));
				cusDto.setAddress(rs.getString("ADDRESS"));
				cusDto.setAccount(rs.getString("USERNAME"));
				cusDto.setGender(rs.getString("GENDER"));

				list.add(cusDto);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void updateCustomer(Customer person) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			connection = ConnectionPerson.getConnection();
			String queryString = "UPDATE CUSTOMER SET NAME= ?, PHONE = ?, ADDRESS = ?, GENDER = ?, DOB =?  WHERE ID = ?";
			ps = connection.prepareStatement(queryString);
			ps.setString(1, person.getName());
			ps.setString(2, person.getPhone());
			ps.setString(3, person.getAddress());
			ps.setString(4, person.getGender());
			ps.setDate(5, new Date(formatter.parse(person.getBirthday()).getTime()));
			ps.setInt(6, person.getId());

			ps.executeUpdate();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void insertAddCustomer(CustomerDto customer) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "INSERT INTO CUSTOMERMA VALUES(NULL, ?, ?, ?)";
			ps = connection.prepareStatement(queryString);

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getPhone());
			ps.setString(3, customer.getAddress());
		

			ps.executeUpdate();
			list1.add(customer);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
