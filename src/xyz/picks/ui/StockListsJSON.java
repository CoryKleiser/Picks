package xyz.picks.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import xyz.picks.dto.StockList;
import xyz.picks.service.IStockListService;

@Named
public class StockListsJSON extends HttpServlet {

	@Inject
	IStockListService stockListService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		//this sets up dependency injection
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//set response header
		resp.addHeader("Access-Control-Allow-Origin", "*");
				
		// write JSON stream
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		
		//get data
		List<StockList> stockLists = stockListService.showAllLists();
		

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		for(StockList stockList : stockLists){
			//create JSON object for each stock list
			JsonObjectBuilder listBuilder = Json.createObjectBuilder();
			JsonObject stockListJson = listBuilder
				.add("id", stockList.getStockListId())
				.add("authorId", stockList.getAuthorId())
				.add("title", stockList.getTitle())
				.add("description", stockList.getDescription() != null ? stockList.getDescription() : "")
				.build();
			//add object to stock list array
			arrayBuilder.add(stockListJson);
		}
		//add stocklist array to root JSON object
		JsonObject root = rootBuilder.add("stockLists", arrayBuilder).build();
		//write JSON to servlet
		writer.println(root);
		
		writer.flush();
		writer.close();
		
	}
	
}
