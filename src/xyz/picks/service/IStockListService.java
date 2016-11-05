package xyz.picks.service;

import java.util.List;

import xyz.picks.dto.StockList;

public interface IStockListService {

	/**
	 * add stock list to user's set of stock lists
	 * @param stockList (stock list to add)
	 * @throws Exception
	 */
	void add(StockList stockList) throws Exception;

	/**
	 * shows user's stock list collection
	 * @return all user stock lists
	 */
	List<StockList> showAllLists();

}