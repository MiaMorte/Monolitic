package com.example.demo5.dao.impl;

import com.example.demo5.dao.AbstractDao;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDaoImpl implements AbstractDao {
    private static final String UNCHECKED = "unchecked";

    @Autowired
    protected EntityManager entityManager;

    @Override
    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Object saveOrUpdate(Object objectToSave) {
        getSession().saveOrUpdate(objectToSave);
        return objectToSave;
    }

    @Override
    public void delete(Object objectToDelete) {
        getSession().delete(objectToDelete);
    }

    @SuppressWarnings(UNCHECKED)
    @Override
    public <T> T findById(Class<T> clazz, Long id) {
        return getSession().get(clazz, id);
    }

    @SuppressWarnings(UNCHECKED)
    @Override
    public <T> T findByProperty(Class<T> clazz, String propertyName, Object value) {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        criteria.add(Restrictions.eq(propertyName, value));
        return (T) criteria.getExecutableCriteria(getSession()).uniqueResult();
    }

    @SuppressWarnings(UNCHECKED)
    @Override
    public <T> List<T> findAllByProperty(Class<T> clazz, String propertyName, Object value) {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        criteria.add(Restrictions.eq(propertyName, value));
        return (List<T>) criteria.getExecutableCriteria(getSession()).list();
    }

    @SuppressWarnings(UNCHECKED)
    @Override
    public <T> List<T> findAllByProperty(Class<T> clazz, String propertyName, List<? extends Object> value) {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        criteria.add(Restrictions.in(propertyName, value));
        return (List<T>) criteria.getExecutableCriteria(getSession()).list();
    }

    @SuppressWarnings(UNCHECKED)
    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        return (List<T>) criteria.getExecutableCriteria(getSession()).list();
    }

}
