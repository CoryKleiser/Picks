package xyz.picks.ui;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import xyz.picks.dto.StockList;
import xyz.picks.service.IStockListService;

@Named
@ManagedBean
@Scope("session")
public class GetLists {

	@Inject
	private IStockListService stockListService;
	
	private List<StockList> lists;
	
	private StockList selectedList;

	public IStockListService getStockListService() {
		return stockListService;
	}

	public void setStockListService(IStockListService stockListService) {
		this.stockListService = stockListService;
	}

	public List<StockList> getLists() {
		lists = stockListService.showAllLists();
		return lists;
	}

	public void setLists(List<StockList> lists) {
		this.lists = lists;
	}

	public StockList getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(StockList selectedList) {
		this.selectedList = selectedList;
	}
	
}
