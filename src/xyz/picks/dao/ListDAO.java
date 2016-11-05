package xyz.picks.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.hibernate.Session;

import xyz.picks.dto.StockList;

@Named
public class ListDAO implements IListDAO {
	
	private Set<StockList> allLists;
	
	public ListDAO() {
		allLists = new HashSet<StockList>();
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
		return new ArrayList<StockList>(allLists);
	}

}
