package xyz.picks.dao;

import org.junit.Test;

import junit.framework.TestCase;
import xyz.picks.dto.User;

public class TestUserDAO extends TestCase{

	private IUserDAO userDAO;
	
	@Test
	public void testInsertAndFetch() throws Exception{
		givenThatUserDAOIsCreated();
		whenInsertUser();
		thenVerifyTestUserIsCreated();
	}

	private void thenVerifyTestUserIsCreated() {
		User testUser = userDAO.fetch(-1);
		String firstName = testUser.getFirstName();
		assertTrue(firstName == "Test");
	}

	private void whenInsertUser() {
		User user = new User();
		user.setUserId(-1);
		user.setEmail("test@dev.com");
		user.setPassword("test");
		user.setFirstName("Test");
		user.setLastName("Testington");
		user.setSummary("This is a test user created by a JUnit test");
		userDAO.insert(user);
	}

	private void givenThatUserDAOIsCreated() {
		userDAO = new UserDAO(); 
	}


}
