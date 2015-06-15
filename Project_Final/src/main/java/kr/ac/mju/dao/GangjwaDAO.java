package kr.ac.mju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.mju.model.Gangjwa;

import org.springframework.stereotype.Repository;

@Repository
public class GangjwaDAO {
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
	
	
	
	public void creatGangjwa(Gangjwa gangjwa) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "INSERT INTO gangjwa (gangjwaid, subject, name, years, grade, maxnum, score)"
		+ "values(?,?,?,?,?,?,?)";
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, gangjwa.getGangjwaid());
		statement.setString(2, gangjwa.getSubject());
		statement.setString(3, gangjwa.getName());
		statement.setString(4, gangjwa.getYears());
		statement.setString(5, gangjwa.getGrade());
		statement.setString(6, gangjwa.getMaxnum());
		statement.setString(7, gangjwa.getScore());
		
		statement.execute();
		connection.close();
	}
	
	public ArrayList<Gangjwa> gangjwaList() throws SQLException {
		ArrayList<Gangjwa> gangjwaList = new ArrayList<Gangjwa>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from gangjwa";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			Gangjwa gangjwa = new Gangjwa();
			gangjwa.setGangjwaid(resultSet.getString("gangjwaid"));
			gangjwa.setSubject(resultSet.getString("subject"));
			gangjwa.setName(resultSet.getString("name"));
			gangjwa.setYears(resultSet.getString("years"));
			gangjwa.setGrade(resultSet.getString("grade"));
			gangjwa.setMaxnum(resultSet.getString("maxnum"));
			gangjwa.setScore(resultSet.getString("score"));
			
			gangjwaList.add(gangjwa);
		}
		return gangjwaList;
	}
	
	public Gangjwa findGangjwa(String gangjwaid) throws SQLException {
		Gangjwa gangjwa = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from gangjwa where gangjwaid = " + gangjwaid;
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			gangjwa = new Gangjwa();
			gangjwa.setGangjwaid(resultSet.getString("gangjwaid"));
			gangjwa.setSubject(resultSet.getString("subject"));
			gangjwa.setYears(resultSet.getString("years"));
			gangjwa.setGrade(resultSet.getString("grade"));
			gangjwa.setMaxnum(resultSet.getString("maxnum"));
			gangjwa.setScore(resultSet.getString("score"));
		}
		return gangjwa;
	}
}