package com.mom.watch.service;

import java.util.List;


public interface ICommonService<T> {
    public T create(T obj);
    public T delete(int id) throws ServiceException;
    public List<T> findAll();
    public T update(T obj) throws ServiceException;
    public T findById(int id);
}
