package kr.ac.mju.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.mju.model.Gangjwa;
import kr.ac.mju.model.Sugang;
import kr.ac.mju.service.GangjwaService;
import kr.ac.mju.service.SugangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SugangController {
	@Autowired	//자동으로 객체 생성
	private GangjwaService service;
	@Autowired	//자동으로 객체 생성
	private SugangService sservice;
	
	@RequestMapping(value = "/sugangController/sugangpage", method = RequestMethod.GET)
	public String sugangpage(HttpServletRequest request) throws SQLException {
		ArrayList<Gangjwa> gangjwaList = service.getList();
		request.setAttribute("gangjwalist", gangjwaList);
		return "sugang";
	}
	
	@RequestMapping(value = "/sugangController/sincheong", method = RequestMethod.POST)
	public String sincheong(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String gangjwaid = request.getParameter("gangjwaid");
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		String prof = request.getParameter("name");
		String years = request.getParameter("years");
		String grade = request.getParameter("grade");
		String score = request.getParameter("score");
		String maxnum = request.getParameter("maxnum");
		String name = request.getParameter("userName");
		
		sservice.sincheong(gangjwaid, id, subject, prof, name, years, grade, score, maxnum);
		
		return "main";
	}
	
	@RequestMapping(value = "/sugangController/reading", method = RequestMethod.GET)
	public String reading(HttpServletRequest request) throws SQLException {
		String id = (String) request.getSession().getAttribute("id");
		ArrayList<Sugang> sugangList = sservice.getList(id);
		request.setAttribute("sugangList", sugangList);
		
		return "reading";
	}
	
}
