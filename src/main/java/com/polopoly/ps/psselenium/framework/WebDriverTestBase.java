package com.polopoly.ps.psselenium.framework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.polopoly.ps.psselenium.agent.GUIAgent;

/**
 * This is an abstract base class that should be extended by a junit test class 
 * with purpose of running selenium browser tests.  
 */
public abstract class WebDriverTestBase<T extends GUIAgent> {
    
    private T guiAgent;
    protected WebDriverTestSetup webDriverTestSetup;
    
    public WebDriverTestBase() {
        super();
    }
    
    protected abstract T createGUIAgent(final WebDriverTestSetup webDriverTestSetup);
    
    protected T guiAgent() {
      return guiAgent;
    }
    
    /**
     * This method will be called before the test starts running. It will call 
     * the {@link #getWebDriverTestSetup()} to receive the test setup.
     * If the {@link #getWebDriverTestSetup()} return null; A default setup 
     * is used with Firefox as Web Driver.
     */
    @Before
    public void beforeTest() throws Exception {
        
        this.webDriverTestSetup = getWebDriverTestSetup();
        
        if (webDriverTestSetup == null) {
            throw new IllegalArgumentException("Missing required WebDriverTestSetup");
        }
                
        this.guiAgent = createGUIAgent(webDriverTestSetup);
    }
    
    /**
     * This method will be called in the {@link #beforeTest()}. The test case should
     * return a {@link WebDriverTestSetup} instance with preferred setup.
     * If null is return; a default setup will be used with Firefox as Web Driver. 
     * See {@link WebDriverTestSetup}. 
     * @return the test setup
     */
    protected WebDriverTestSetup getWebDriverTestSetup() {
      return createDeafultTestSetup();
    }

    
    /**
     * This method will quit the current web driver.  
     */
    @After
    public void afterTest() throws Exception {
        try {
    } finally {
        if (webDriverTestSetup.getWebDriver() != null) {
            webDriverTestSetup.getWebDriver().quit();
            webDriverTestSetup = null;
        }
      }
    }
    
    /**
     * Returns the current Selenium Web Driver set in {@link WebDriverTestSetup#getWebDriver()}
     * @return the web driver
     */
    protected WebDriver getWebDriver() {
        return webDriverTestSetup.getWebDriver();
    }
    
    /**
     * Returns the current base URL set in {@link WebDriverTestSetup#getBaseURL()}
     * @return the base URL
     */
    protected String getBaseURL() {
        return webDriverTestSetup.getBaseURL();
    }
    
    /**
     * Creates a default {@link WebDriverTestSetup} with Firefox as 
     * Web Driver.
     * @return a default test setup
     */
    private WebDriverTestSetup createDeafultTestSetup() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver webDriver = new FirefoxDriver(firefoxProfile);
        return new WebDriverTestSetup(webDriver);
    }
}
