package xyz.picks.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import xyz.picks.dto.StockList;

@Named
public class UserDAO implements IListDAO {
	
	private Set<StockList> allLists;
	
	public UserDAO() {
		allLists = new HashSet<StockList>();
	}


	@Override
	public void insertOrUpdate(StockList stockList) throws Exception {
		allLists.add(stockList);

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
