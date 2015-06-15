package kr.ac.mju.service;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.ac.mju.dao.GangjwaDAO;
import kr.ac.mju.model.Gangjwa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GangjwaService {
	@Autowired
	GangjwaDAO gangjwaDAO;

	public Gangjwa gaeseol(String gangjwaid, String subject, String years,
			String grade, String maxnum, String score, String name) throws SQLException {
		Gangjwa gangjwa = new Gangjwa();

		gangjwa.setGangjwaid(gangjwaid);
		gangjwa.setSubject(subject);
		gangjwa.setYears(years);
		gangjwa.setGrade(grade);
		gangjwa.setMaxnum(maxnum);
		gangjwa.setScore(score);
		gangjwa.setName(name);

		gangjwaDAO.creatGangjwa(gangjwa);

		return gangjwa;
	}

	public ArrayList<Gangjwa> getList() throws SQLException {
		ArrayList<Gangjwa> gangjwaList = new ArrayList<Gangjwa>();
		gangjwaList = gangjwaDAO.gangjwaList();
		
		return gangjwaList;
	}
	
	public Gangjwa findGangjwa(String gangjwaid) throws SQLException {
		Gangjwa gangjwa = new Gangjwa();
		gangjwa = gangjwaDAO.findGangjwa(gangjwaid);
		
		return gangjwa;
	}
}
