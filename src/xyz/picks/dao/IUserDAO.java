package xyz.picks.dao;

import java.util.List;

import xyz.picks.dto.User;


public interface IUserDAO {

	/**
	 * fetches all user
	 * @return HashSet of all users
	 */
	List<User> fetchAllUsers();

	/**
	 * persist user
	 * @param user
	 */
	void insert(User user);

}