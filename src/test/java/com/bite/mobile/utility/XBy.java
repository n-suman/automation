package com.bite.mobile.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class XBy extends By {

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String description;
	public String locExpression;
	private Boolean locExpIsNotXpath = false;
	
	public XBy(String xpath, String desc) {
		this.locExpression = xpath;
		this.description = desc;
	}
	
	//default is ID
	public XBy(String id, String desc, String locByType) {
		this.locExpIsNotXpath = true;
		this.locExpression = id;
		this.description = desc;
	}
	
	public By xpath() {
		return xpath(this.locExpression);
	}
	
	public By id() {
		if (this.locExpIsNotXpath)
			return id(this.locExpression);
		else
			return xpath(this.locExpression);
	}

}
