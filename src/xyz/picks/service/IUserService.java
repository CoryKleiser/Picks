package xyz.picks.service;

import java.util.List;

import xyz.picks.dto.User;


public interface IUserService {

	/**
	 * add user
	 * @param user to add
	 */
	void add(User user);

	/**
	 * show all registered users
	 * @return set of all users
	 */
	List<User> showAllUsers();

}