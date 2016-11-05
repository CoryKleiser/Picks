package xyz.picks.dao;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import xyz.picks.dto.StockList;

public class TestListDAO extends TestCase{

	private IListDAO listDAO;

	@Test
	public void testInsertAndFetch() throws Exception{
		givenThatListDAOIsCreated();
		whenInsertTestList();
		thenVerifyTestListIsCreated();
	}

	private void thenVerifyTestListIsCreated() {
		List<StockList> lists = listDAO.fetch("Test");
		assertTrue(lists.size()==1);
	}

	private void whenInsertTestList() throws Exception {
		StockList stockList = new StockList();
		stockList.setTitle("Test List!");
		stockList.setDescription("Test Description.");
		listDAO.insertOrUpdate(stockList);
	}

	private void givenThatListDAOIsCreated() {
		listDAO = new UserDAO();
	}
	
	
}
