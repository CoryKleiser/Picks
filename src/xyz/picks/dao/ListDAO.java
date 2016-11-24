package xyz.picks.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import xyz.picks.dto.StockList;

@Named
public class ListDAO implements IListDAO {
	
	private List<StockList> allLists;
	
	public ListDAO() {
		allLists = new ArrayList<StockList>();
	}


	@Override
	public void insertOrUpdate(StockList stockList) throws Exception {
		allLists.add(stockList);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(stockList);
		
		session.getTransaction().commit();

	}


	@Override
	public List<StockList> fetch(String title) {
		// : finish method so test passes 100%
		List<StockList> returnLists = new ArrayList<StockList>();
		
		for (StockList stockList : allLists){
			if(stockList.toString().contains(title)){
				returnLists.add(stockList);
			}
		}
		
		
		return returnLists;
	}
	
	@Override
	public List<StockList> fetchAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("FROM StockList");

		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		allLists = Collections.checkedList(list, StockList.class);
		
		session.close();
		return allLists;	
	}

}
