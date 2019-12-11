package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import PersonDto.CustomerDto;
import PersonDto.ManagerDto;

public class ManagerImpl implements ManagerDao{

	@Override
	public ManagerDto getPersonBySignUp(String username,String pass) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stm = null;
		try {
			connection = ConnectionPerson.getConnection();
			stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM MANAGER WHERE USERNAME='" + username + "'AND PASS='"+pass+"'");
			if (rs.next()) {
				ManagerDto bd =new ManagerDto();
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
	public List<ManagerDto> getAllmanger() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		try {
			con = ConnectionPerson.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM MANAGER");
			List<ManagerDto> ma = new ArrayList<ManagerDto>();
			while (rs.next()) {
				ManagerDto bd = new ManagerDto();
				bd.setId(rs.getInt("ID"));
				bd.setName(rs.getString("NAME"));
				bd.setPhone(rs.getString("PHONE"));
				bd.setAddress(rs.getString("ADDRESS"));
				bd.setAccount(rs.getString("USERNAME"));
				bd.setPassword(rs.getString("PASS"));
				ma.add(bd);
			}
			return ma;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public ManagerDto getIDBySignUp(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stm = null;
		try {
			connection = ConnectionPerson.getConnection();
			stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT *FROM MANAGER WHERE ID='" + id + "'");
			if (rs.next()) {
				ManagerDto bd = new ManagerDto();
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
}
