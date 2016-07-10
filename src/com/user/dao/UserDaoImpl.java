package com.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public User getUser(int empid) {
		return (User) sessionFactory.getCurrentSession().get(User.class, empid);
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM user WHERE USER_ID = "+user.getUserId()).executeUpdate();
	}

}
