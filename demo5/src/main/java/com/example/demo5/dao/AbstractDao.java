package com.example.demo5.dao;

import org.hibernate.Session;

import java.util.List;

public interface AbstractDao
{

    Session getSession();

    Object saveOrUpdate(Object objectToSave);

    void delete(Object objectToDelete);

    <T> T findById(Class<T> clazz, Long id);

    <T> T findByProperty(Class<T> clazz, String propertyName, Object value);

    <T> List<T> findAllByProperty(Class<T> clazz, String propertyName, List<? extends Object> value);

    <T> List<T> findAllByProperty(Class<T> clazz, String propertyName, Object value);

    <T> List<T> findAll(Class<T> clazz);
}
