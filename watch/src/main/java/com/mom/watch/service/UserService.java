package com.mom.watch.service;

import java.util.List;

import com.mom.watch.model.User;

public interface UserService {
    public User create(User user)throws ServiceException;
    public void delete(String id) throws ServiceException;
    public List<User> findAll();
    public User update(User user) throws ServiceException;
    public User findById(String id);

}
