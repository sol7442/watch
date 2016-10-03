package com.mom.watch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mom.watch.model.DMPolicy;
import com.mom.watch.repository.DMPolicyRepository;
import com.mom.watch.service.MDPolicyService;
import com.mom.watch.service.ServiceException;

@Service
public class DNPolicyServiceImpl implements MDPolicyService{
	@Resource
	private DMPolicyRepository dmpolicyRepository;
	
	@Override
	public DMPolicy create(DMPolicy policy) {
		return dmpolicyRepository.save(policy);
	}

	@Override
	public DMPolicy delete(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DMPolicy> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMPolicy update(DMPolicy obj) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMPolicy findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
