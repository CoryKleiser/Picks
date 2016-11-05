package xyz.picks.dto;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("request")
public class StockList {

	private int stockListId; //unique list id
	private int authorId; //author's user id
	private String title;
	private String description;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return title;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getStockListId() {
		return stockListId;
	}

	public void setStockListId(int stockListId) {
		this.stockListId = stockListId;
	}
	
}
