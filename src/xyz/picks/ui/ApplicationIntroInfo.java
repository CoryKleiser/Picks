package xyz.picks.ui;

import javax.annotation.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class ApplicationIntroInfo {

	
	private String welcome = "Welcome to Picks.";

	/**
	 * get welcome slogan for home page of Langsam Library Inventory
	 * @return welcome
	 */
	public String getWelcome() {
		return welcome;
	}
	/**
	 * set welcome slogan for home page of Langsam Library Inventory
	 * @param welcome
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	
}
