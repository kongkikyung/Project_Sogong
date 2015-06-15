package kr.ac.mju.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.mju.model.Gangjwa;
import kr.ac.mju.model.Sugang;

public class SugangDAO {
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
	
	public void creatSugang(Sugang sugang) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "INSERT INTO sugang (gangjwaid, id, subject, prof, name, years, grade, maxnum, score)"
		+ "values(?,?,?,?,?,?,?,?,?)";
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, sugang.getGangjwaid());
		statement.setString(2, sugang.getId());
		statement.setString(3, sugang.getSubject());
		statement.setString(4, sugang.getProf());
		statement.setString(5, sugang.getName());
		statement.setString(6, sugang.getYears());
		statement.setString(7, sugang.getGrade());
		statement.setString(8, sugang.getMaxnum());
		statement.setString(9, sugang.getScore());
		
		statement.execute();
		connection.close();
	}
	
	public ArrayList<Sugang> sugangList(String id) throws SQLException {
		ArrayList<Sugang> sugangList = new ArrayList<Sugang>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from sugang where id = " + "'" + id + "'";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			Sugang sugang = new Sugang();
			sugang.setGangjwaid(resultSet.getString("gangjwaid"));
			sugang.setId(resultSet.getString("id"));
			sugang.setSubject(resultSet.getString("subject"));
			sugang.setProf(resultSet.getString("prof"));
			sugang.setYears(resultSet.getString("years"));
			sugang.setGrade(resultSet.getString("grade"));
			sugang.setMaxnum(resultSet.getString("maxnum"));
			sugang.setScore(resultSet.getString("score"));
			sugang.setAvgscore(resultSet.getString("avgscore"));
			
			sugangList.add(sugang);
		}
		return sugangList;
	}
	
	public ArrayList<Sugang> findSugang(String gangjwaid) throws SQLException {
		ArrayList<Sugang> sugangList = new ArrayList<Sugang>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from sugang where gangjwaid = " + gangjwaid;
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			Sugang sugang = new Sugang();
			sugang.setGangjwaid(resultSet.getString("gangjwaid"));
			sugang.setId(resultSet.getString("id"));
			sugang.setSubject(resultSet.getString("subject"));
			sugang.setProf(resultSet.getString("prof"));
			sugang.setName(resultSet.getString("name"));
			sugang.setYears(resultSet.getString("years"));
			sugang.setGrade(resultSet.getString("grade"));
			sugang.setMaxnum(resultSet.getString("maxnum"));
			sugang.setScore(resultSet.getString("score"));
			sugang.setAvgscore(resultSet.getString("avgscore"));
			
			sugangList.add(sugang);
		}
		return sugangList;
	}

	public void update(Sugang sugang) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "update sugang set avgscore=? where gangjwaid=? and id=?";
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, sugang.getAvgscore());
		statement.setString(2, sugang.getGangjwaid());
		statement.setString(3, sugang.getId());
		
		statement.executeUpdate();
		connection.close();
	}

}
