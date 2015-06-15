package kr.ac.mju.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.ac.mju.dao.UserDAO;
import kr.ac.mju.model.User;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	UserDAO userDAO = new UserDAO();
	User user = new User();

	public void signup(String userID, String userName, String userPassword,
			String job) throws SQLException {
		user.setUserID(userID);
		user.setName(userName);
		user.setPassword(userPassword);
		user.setJob(job);
		
		userDAO.signup(user);
	}
}
