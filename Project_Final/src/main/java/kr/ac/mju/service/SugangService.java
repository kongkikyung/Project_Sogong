package kr.ac.mju.service;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.ac.mju.dao.SugangDAO;
import kr.ac.mju.model.Gangjwa;
import kr.ac.mju.model.Sugang;

import org.springframework.stereotype.Service;

@Service
public class SugangService {
	SugangDAO sugangDAO = new SugangDAO();

	public void sincheong(String gangjwaid, String id, String subject, String prof, String name, String years, String grade, 
			String score, String maxnum) throws SQLException {
		Sugang sugang = new Sugang();
		
		sugang.setGangjwaid(gangjwaid);
		sugang.setId(id);
		sugang.setSubject(subject);
		sugang.setProf(prof);
		sugang.setName(name);
		sugang.setYears(years);
		sugang.setGrade(grade);
		sugang.setScore(score);
		sugang.setMaxnum(maxnum);
		
		
		sugangDAO.creatSugang(sugang);
	}

	public ArrayList<Sugang> getList(String id) throws SQLException {
		ArrayList<Sugang> sugangList = new ArrayList<Sugang>();

		sugangList = sugangDAO.sugangList(id);

		return sugangList;
	}
	
	public ArrayList<Sugang> findSugang(String gangjwaid) throws SQLException {
		ArrayList<Sugang> sugangList = new ArrayList<Sugang>();
		sugangList = sugangDAO.findSugang(gangjwaid);
		
		return sugangList;
	}
	
	public void update(String gangjwaid, String id, String avgscore) throws SQLException {
		Sugang sugang = new Sugang();
		sugang.setGangjwaid(gangjwaid);
		sugang.setId(id);
		sugang.setAvgscore(avgscore);
		
		sugangDAO.update(sugang);
	}
}
