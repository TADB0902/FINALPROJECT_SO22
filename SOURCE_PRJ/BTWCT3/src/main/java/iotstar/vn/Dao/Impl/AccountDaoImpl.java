package iotstar.vn.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.Connection.DBConnection;
import iotstar.vn.Dao.IAccountDao;

import iotstar.vn.Entity.Account;

public class AccountDaoImpl extends DBConnection implements IAccountDao {

	@Override
	public Account login(String user, String pass) {
		String query = "select * from account where [user] = ? and pass = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<Account> getAll() {
		List<Account> acclist = new ArrayList<Account>();
		String sql = "SELECT * FROM account";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setUser(rs.getString("user"));
				acc.setPass(rs.getString("pass"));
				acc.setAuthor(rs.getString("author"));
				acclist.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acclist;
	}

	@Override
	public void insert(Account account) {
		String query = "insert into account values (?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, account.getUser());
			ps.setString(2, account.getPass());
			ps.setString(3, account.getAuthor());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(Account account) {
		String query = "update account set [user] = ?, pass=?, author=? where id=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, account.getUser());
			ps.setString(2, account.getPass());
			ps.setString(3, account.getAuthor());
			ps.setInt(4, account.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String query = "delete from account where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Account get(int id) {
		String sql = "SELECT * FROM account WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setUser(rs.getString("user"));
				acc.setPass(rs.getString("pass"));
				acc.setAuthor(rs.getString("author"));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
