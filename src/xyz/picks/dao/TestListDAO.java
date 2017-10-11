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
	
	@Test
	public void testFetchAll() throws Exception{
		givenThatListDAOIsCreated();
		verifyFetchAll();
	}

	private void verifyFetchAll() {
		// TODO Auto-generated method stub
		List<StockList> lists = listDAO.fetchAll();
		assertTrue(lists.size()>1);
	}

	private void thenVerifyTestListIsCreated() {
		List<StockList> lists = listDAO.fetch("Test");
		assertTrue(lists.size()==1);
	}

	private void whenInsertTestList() throws Exception {
		StockList list = new StockList();
		list.setTitle("Test List!");
		list.setDescription("Test Description.");
		listDAO.insertOrUpdate(list);
	}

	private void givenThatListDAOIsCreated() {
		listDAO = new ListDAO();
	}
	
	
}
