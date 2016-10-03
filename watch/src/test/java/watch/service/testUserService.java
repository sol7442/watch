package watch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mom.watch.config.ApplicationConfig;
import com.mom.watch.model.User;
import com.mom.watch.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfig.class)
@WebAppConfiguration
public class testUserService {
	@Autowired
	private UserService userService;
	

	@Test
	public void testCreate(){
		User user_ = new User();
		user_.setUserId("test_2");
		user_.setFirstName("test");
		user_.setLastName("name");
		userService.create(user_);
		
	}
}
