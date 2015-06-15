package kr.ac.mju.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.mju.model.Gangjwa;
import kr.ac.mju.model.Sugang;
import kr.ac.mju.service.GangjwaService;
import kr.ac.mju.service.LoginService;
import kr.ac.mju.service.SugangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GangjwaController {
	@Autowired(required=true)	//자동으로 객체 생성
	private GangjwaService service;
	@Autowired	//자동으로 객체 생성
	private LoginService lservice;
	@Autowired
	private SugangService sservice;
	
	@RequestMapping(value = "/gangjwaController/gaeseolpage", method = RequestMethod.GET)
	public String gaeseolPage(HttpServletRequest request) throws SQLException {
		
		return "gangjwa";
	}
	
	@RequestMapping(value = "/gangjwaController/input", method = RequestMethod.GET)
	public String input(HttpServletRequest request) throws SQLException {
		ArrayList<Gangjwa> gangjwaList = service.getList();
		
		request.setAttribute("gangjwalist", gangjwaList);
		return "input";
	}
	
	@RequestMapping(value = "/gangjwaController/gaeseol", method = RequestMethod.POST)
	public String gaeseol(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		//HttpSession session = request.getSession();
		request.getSession();
		
		String gangjwaid = request.getParameter("gangjwaid");
		String subject = request.getParameter("subject");
		String years = request.getParameter("years");
		String grade = request.getParameter("grade");
		String maxnum = request.getParameter("maxnum");
		String score = request.getParameter("score");
		String name = request.getParameter("name");
		service.gaeseol(gangjwaid, subject, years, grade, maxnum, score, name);
		
		return "gangjwa";
	}
	
	@RequestMapping(value = "/gangjwaController/findGangjwa.do", method = RequestMethod.POST)
	public String findGangjwa(HttpServletRequest request) throws SQLException, UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String gangjwaid = request.getParameter("gangjwaid");
		ArrayList<Sugang> sugangList = sservice.findSugang(gangjwaid);
		request.getSession().setAttribute("sugangSession", sugangList);
		request.setAttribute("sugang", sugangList);
		
		return "inputScore";
	}
	
	@RequestMapping(value = "/gangjwaController/inputresult", method = RequestMethod.POST)
	public String inputResult(HttpServletRequest request) throws SQLException, UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String gangjwaid = request.getParameter("gangjwaid");
		String id = request.getParameter("id");
		String avgscore = request.getParameter("inputscore");
		
		sservice.update(gangjwaid, id, avgscore);
		
		return "main";
	}
}
