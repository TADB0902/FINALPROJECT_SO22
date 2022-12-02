package iotstar.vn.Dao;

import java.util.List;

import iotstar.vn.Entity.Account;

public interface IAccountDao {
	Account login(String user, String pass);
	List<Account> getAll();
	void insert(Account account);
	void edit(Account account);
	void delete(int id);
	Account get(int id);
}
