package watch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mom.watch.config.ApplicationConfig;
import com.mom.watch.model.DMPolicy;
import com.mom.watch.service.MDPolicyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfig.class)
@WebAppConfiguration
public class testMDPolicyService {
	@Autowired
	private MDPolicyService policyService;
	

	@Test
	public void testCreate(){
		DMPolicy policy = new DMPolicy();
		policy.setName("policy1");
		policy.setDesc("test");
		policy.setValue("value");
		policyService.create(policy);
		
	}
}
