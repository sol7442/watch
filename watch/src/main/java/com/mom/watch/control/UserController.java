package com.mom.watch.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mom.watch.model.User;
import com.mom.watch.service.ServiceException;
import com.mom.watch.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/create")
	public String home(){
		try {
			User user = new User();
			user.setUserId("test_user1");
			user.setFirstName("test");
			user.setLastName("name");
			
			userService.create(user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println("create---");
		return "index";
	}
}
