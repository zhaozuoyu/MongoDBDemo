package cn.zzy.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zzy.mongodb.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Value("${userName}")
	private String userName;
	
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/userInfo.html")
	public String findByUserCode(String userCode,Model model) {

		return "userInfo";
	}
	
	

}
