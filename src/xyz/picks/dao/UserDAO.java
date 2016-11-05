package xyz.picks.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import xyz.picks.dto.User;


/**
 * User hibernate DAO class
 * 
 * @author moku
 *
 */
@Named
public class UserDAO implements IUserDAO {

	public Set<User> users;

	public UserDAO() {
		users = new HashSet<User>();
	}

	// TODO:: implement Hibernate
	@Override
	public List<User> fetchAllUsers() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		Query query = session.createQuery("from User");
		@SuppressWarnings("rawtypes")
		List list = query.list();
		List<User> allUsers = Collections.checkedList(list, User.class);

		return list;
	}

	@Override
	public void insert(User user) {
		// save user to database
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(user);
		users.add(user);

		session.getTransaction().commit();
	}

}
