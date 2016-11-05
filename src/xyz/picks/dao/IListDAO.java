package xyz.picks.dao;

import java.util.List;

import xyz.picks.dto.StockList;

public interface IListDAO {

	/**
	 * method to insert user defined stock list or update 
	 * @param stockList stock list to be inserted/updated
	 * @throws Exception
	 */
	void insertOrUpdate(StockList stockList) throws Exception;

	/**
	 * fetch a single or multiple stock list
	 * @param title
	 * @return one stocklist or list of stocklists
	 */
	List<StockList> fetch(String title);

	/**
	 * fetch all of the user's stock lists.
	 * @return all of the user's defined stocklists
	 */
	List<StockList> fetchAll();

}