package xyz.picks.ui;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import xyz.picks.dto.User;
import xyz.picks.service.IUserService;

@Named
@ManagedBean
@Scope("session")
public class GetUser {

	@Inject
	private IUserService userService;
	
	private List<User> users;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		users = userService.showAllUsers();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



}
