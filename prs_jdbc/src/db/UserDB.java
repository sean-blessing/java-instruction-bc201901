package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB extends DBConnection implements DAO<User>{
	//ArrayList<User> users = null;
	
	public UserDB() {
	}
		
	@Override
	public User get(int id) {
		String sql = "SELECT * FROM user" + 
				" where id = ?";
		User u = null;
		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = getUserFromResultSet(rs);				
			}
		}
		catch (SQLException e) {
			System.err.println(e);
		}
		return u;
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * "+
				 "FROM User";
		List<User> users = new ArrayList<>();
		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = getUserFromResultSet(rs);
				users.add(u);				
			}
		}
		catch (SQLException e) {
			System.err.println(e);
		}
		return users;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(User t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// MAP a result set row to an instance of User
	private User getUserFromResultSet(ResultSet rs) throws SQLException{
		User u = new User();
		u.setId(rs.getInt(1));
		u.setUserName(rs.getString(2));
		u.setPassword(rs.getString(3));
		u.setFirstName(rs.getString(4));
		u.setLastName(rs.getString(5));
		u.setPhoneNumber(rs.getString(6));
		u.setEmail(rs.getString(7));
		u.setReviewer(rs.getBoolean(8));
		u.setAdmin(rs.getBoolean(9));

		return u;
	}
	
	public User authenticateUser(String uName, String pwd) {
		User usr = null;
		String sql = "Select * FROM User where UserName = ? and password = ?";
		try(Connection connection = getConnection();
	       		PreparedStatement ps = connection.prepareStatement(sql))
		{
			ps.setString(1, uName);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usr = getUserFromResultSet(rs);
			}
		}
		catch (SQLException sqle) {
			System.out.println("Error logging in user for username '"+uName+"' and pwd = '"+pwd+"'!");
			sqle.printStackTrace();
		}
		
		return usr;
	}



}
