package com.app.libs.web;

import org.openqa.selenium.WebElement;

public interface BaseElement extends WebElement {
	
	public boolean verifyPresent();
	public void mouseHover();
	public void mouseHoverAndClick();
	public void scrollAndClick();
	public void scrollAndDoubleClick();
	public void scrollToElement();

}
