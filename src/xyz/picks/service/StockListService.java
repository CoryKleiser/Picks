package xyz.picks.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import xyz.picks.dao.IListDAO;
import xyz.picks.dto.StockList;

@Named
public class StockListService implements IStockListService {

	@Inject
	private IListDAO listDAO;
	

	@Override
	public void add(StockList stockList) throws Exception {
		// TODO Auto-generated method stub
		getListDAO().insertOrUpdate(stockList);
	}
	

	@Override
	public List<StockList> showAllLists() {
		return getListDAO().fetchAll();
	}
	
	public IListDAO getListDAO() {
		return listDAO;
	}

	public void setListDAO(IListDAO listDAO) {
		this.listDAO = listDAO;
	}
	
	
}
