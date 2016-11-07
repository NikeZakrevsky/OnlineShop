package com.nike.dao;

import com.nike.model.Category;
import com.nike.model.Role;
import com.nike.model.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        Role role = new Role();
        role.setRole("ROLE_USER");
        role.setUser(user);
        user.getRoles().add(role);
        session.save(role);
        session.getTransaction().commit();
    }

    @Override
    public Set<User> getUserList() {
        return null;
    }

    @Override
    public User getUserByName2(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User where username=?").setParameter(0, name).list();
        session.getTransaction().commit();
        return users.get(0);
    }

    @Override
    public User getUserByName(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User where username=?").setParameter(0, user.getUsername()).list();
        session.getTransaction().commit();
        if (users.size() > 0)
            if(users.get(0).getPassword().equals(user.getPassword()))
                return users.get(0);
        return null;
    }
}
