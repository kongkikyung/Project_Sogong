package kr.ac.mju.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.mju.dao.UserDAO;
import kr.ac.mju.model.User;
import kr.ac.mju.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	@Autowired	//자동으로 객체 생성
	private LoginService service;
	private UserDAO userDAO = new UserDAO();
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request)
			throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		User user = null;
		try {
			user = userDAO.login(userID, userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("로그인 요청 : " + userID);
		if (user == null) {
				return "alert";
		} else {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60*60);
			request.getSession().setAttribute("userSession", user);
			request.getSession().setAttribute("userName", user.getName());
			request.getSession().setAttribute("id", user.getUserID());
			return "main";
		}
	}
	
	@RequestMapping(value = "/loginController/signupPage.do")
	public String signupPage(HttpServletRequest request)
			throws UnsupportedEncodingException {
			return "signup";
	}
	
	@RequestMapping(value = "/loginController/signup.do", method = RequestMethod.POST)
	public String signup(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String job = request.getParameter("job");
		
		try {
		service.signup(userID, userName, userPassword, job);
		} catch(Exception e) {
			e.printStackTrace();
		}
			return "redirect:/";
	}
	
	
	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("userSession");
		return "redirect:/";
	}
}
