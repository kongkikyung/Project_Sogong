package kr.ac.mju.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.mju.model.User;

public class UserDAO {
	private final static String URL = "jdbc:mysql://localhost:3306/sogongDB";
	private final static String ID = "project";
	private final static String PASSWORD = "mju12345";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	private void closeConnection(Connection connection, Statement statement, ResultSet resultset) throws SQLException {
		if(connection == null) {
			return;
		}
		connection.close();
		statement.close();
		resultset.close();
	}
	
	
	public User login(String userID, String userPassword) throws ClassNotFoundException, SQLException {
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from user";
		User user = null;
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			String password = resultSet.getString("password");
			
			if(id.equals(userID) && password.equals(userPassword)) {
				sql = "select * from user where id = " + id;
				statement = connection.prepareStatement(sql);
				//resultSet = statement.executeQuery();
				user = new User();
				user.setUserID(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setJob(resultSet.getString("job"));
				return user;
			}
		}
		closeConnection(connection, statement, resultSet);
		return null;
	}

	public void signup(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "INSERT INTO user (id, name, password, job)" + "values(?,?,?,?)";
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUserID());
		statement.setString(2, user.getName());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getJob());
		
		statement.execute();
		connection.close();
	}
}
