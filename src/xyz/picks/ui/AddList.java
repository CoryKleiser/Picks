package xyz.picks.ui;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import xyz.picks.dto.StockList;
import xyz.picks.service.IStockListService;

@Named
@ManagedBean
@Scope("request")
public class AddList {
	final static Logger logger = Logger.getLogger(AddList.class);
	
	@Inject
	private StockList stockList;
	
	@Inject
	private IStockListService stockListService;
	
	public String execute(){
		
		logger.info("Entering the add list execute method");
		String returnMessage;
		FacesMessage fm;
		
		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		if(stockList != null && stockList.getTitle().length() > 0){
		//:: implement add method from StockListService
		try{
			stockListService.add(stockList);
			logger.info("INFO:: User stock list saved successfully");
			returnMessage = "success";
			// what is the message that we want to show?
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Stock List Saved");
			// display the message
			currentInstance.addMessage(null, fm);
		} 
		catch(Exception e) {
			returnMessage = "fail";
			logger.error("ERROR:: User stock list did not save successfully.");
			logger.error(e);
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Whoops!", "Something went wrong. Please try again later.");
			currentInstance.addMessage(null, fm);
		}
		} else {
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Uh Oh", "Looks like you forgot the title");
			currentInstance.addMessage(null, fm);
			returnMessage = "nullentry";
		}
		return returnMessage;
	}

	public StockList getStockList() {
		return stockList;
	}

	public void setStockList(StockList stockList) {
		this.stockList = stockList;
	}
	
}
