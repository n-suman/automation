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
	public String xpathExpression;
	public XBy(String xpath, String desc) {
		this.xpathExpression = xpath;
		this.description = desc;
	}
	
	public By xpath() {
		return xpath(this.xpathExpression);
	}
	
	

}
