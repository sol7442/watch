package com.mom.watch.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mom.watch.model.User;
import com.mom.watch.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/create")
	public String home(){
		User user = new User();
		user.setUserId("test_user1");
		user.setFirstName("test");
		user.setLastName("name");
		userService.create(user);
		System.out.println("create---");
		return "index";
	}
}
