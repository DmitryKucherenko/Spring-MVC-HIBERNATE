package com.kucherenko.spring.spring_hibernate_mvc.dao;

import com.kucherenko.spring.spring_hibernate_mvc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("FROM User",User.class).getResultList();
        return allUsers;
    }

    @Override
    @Transactional
    public List<User> search(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("FROM User WHERE name LIKE '%"+keyword+"%' ",User.class).getResultList();
        System.out.println(allUsers);
        return allUsers;
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class,id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User "+
                "where id = :userId");
        query.setParameter("userId",id);
        query.executeUpdate();

    }
}
