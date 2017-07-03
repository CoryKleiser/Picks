package xyz.picks.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import xyz.picks.dto.StockList;
import xyz.picks.dto.User;


/**
 * User hibernate DAO class
 * 
 * @author moku
 *
 */
@Named
public class UserDAO implements IUserDAO {

	public List<User> allUsers;

	public UserDAO() {
		allUsers = new ArrayList<User>();
	}

	// :: implement Hibernate
	@Override
	public List<User> fetchAllUsers() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("FROM User");

		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		allUsers = Collections.checkedList(list, User.class);
		
		session.close();
		return allUsers;	
		
	}

	@Override
	public void insert(User user) {
		// save user to database
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(user);
		allUsers.add(user);

		session.getTransaction().commit();
	}

}
