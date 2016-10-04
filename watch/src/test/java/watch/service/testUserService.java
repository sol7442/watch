package watch.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mom.watch.config.ApplicationConfig;
import com.mom.watch.model.User;
import com.mom.watch.service.ServiceException;
import com.mom.watch.service.UserService;
import com.mom.watch.service.exception.AlreadyExistsExeception;
import com.mom.watch.service.exception.NotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfig.class)
@WebAppConfiguration
public class testUserService {
	@Autowired
	private UserService userService;
	
	private static boolean isInit = false;
	private List<User> user_list = new ArrayList<User>();
	
	@Before
	public void initUserObject(){
		
		for(int i=0; i<10; i++){
			User user = new User();
			user.setUserId("user_0"+i);
			user.setFirstName("FN_0"+i);
			user.setLastName("LN_0"+i);
			user_list.add(user);
		}
			
		if(isInit == false){	
			testCreate();
			isInit = true;
		}
	}

	@After
	public void destroyUserObject(){

	}
	private void testCreate(){
		for(User user:user_list){
			try {
				userService.create(user);
			} catch (ServiceException e) {
				System.out.println("ERROR : "+e.getClass().getName()+":"+user);
			}
		}
	}
	
	@Test
	public void testCreateError(){
		Exception error = null;
		User user = user_list.get(1);
		try {
			userService.create(user);
		} catch (ServiceException e) {
			error = e;
		}
		assertEquals(AlreadyExistsExeception.class, error.getClass());
	}
	
	@Test
	public void testUpdate(){
		User in_ = user_list.get(1);
		User out_ = null;
		try {
			in_.setFirstName("update");
			out_ = userService.update(in_);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		
		assertEquals(out_.getFirstName(),"update");
	}
	
	@Test
	public void testFindAll(){
		List<User> user_list = userService.findAll();
		for(User user : user_list){
			System.out.println(user);
		}
	}
	
	@Test
	public void testDelete(){
		User in_ = user_list.get(2);
		try {
			userService.delete(in_.getUserId());
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}
