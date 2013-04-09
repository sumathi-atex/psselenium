package com.polopoly.psselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.AbstractModule;
import com.polopoly.ps.psselenium.SimpleGUIAgent;
import com.polopoly.ps.psselenium.SimpleGUIAgentInterface;


public class SeleniumTestStartupModuleImpl extends AbstractModule implements SeleniumTestStartupModule{
	
	private static  WebDriver DRIVER;

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
		this.DRIVER = new FirefoxDriver();
		
		bind(SimpleGUIAgentInterface.class).to(SimpleGUIAgent.class);
		bind(WebDriver.class).toInstance(DRIVER);
		bind(SeleniumTestStartupModule.class).to(SeleniumTestStartupModuleImpl.class);
	}
	
}
