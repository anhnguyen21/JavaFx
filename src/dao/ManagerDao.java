package dao;

import java.util.List;

import PersonDto.ManagerDto;

public interface ManagerDao {
	public ManagerDto getPersonBySignUp(String username,String pass);
	public List<ManagerDto> getAllmanger();
	public ManagerDto getIDBySignUp(int id);
}
