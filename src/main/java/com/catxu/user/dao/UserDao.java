package com.catxu.user.dao;

import org.hibernate.Session;

import com.catxu.user.model.User;
import com.catxu.user.util.HibernateUtil;

public class UserDao implements IUserDao {

	public void add(User u) {
		Session session = null;

		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();

			session.save(u);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}

	public User loadByUsername(String username) {
		Session session = null;
		User u = null;
		try {
			session = HibernateUtil.openSession();
			u = (User) session.createQuery("from User where username=?")
					.setParameter(0, username).uniqueResult();
			session.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return u;
	}

}
