package com.polopoly.ps.psselenium.framework;

import junit.framework.TestCase;

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
public abstract class SeleniumWebDriverTestCase extends TestCase {
    
    protected GUIAgent guiAgent;
    protected SeleniumWebDriverTestSetup seleniumWebDriverTestSetup;
    
    public SeleniumWebDriverTestCase() {
        super();
    }
    
    public SeleniumWebDriverTestCase(String name) {
        super(name);
    }
    
    /**
     * This method will be called before the test starts running. It will call 
     * the {@link #getSeleniumWebDriverTestSetup()} to receive the test setup.
     * If the {@link #getSeleniumWebDriverTestSetup()} return null; A default setup 
     * is used with Firefox as Web Driver.
     */
    @Before
    public void setUp() throws Exception {
        
        this.seleniumWebDriverTestSetup = getSeleniumWebDriverTestSetup();
        
        if (seleniumWebDriverTestSetup == null) {
            seleniumWebDriverTestSetup = createDeafultTestSetup();
        }
        
        TestApplication.init(seleniumWebDriverTestSetup.getConnectionPropertiesURL());

        guiAgent = new GUIAgent(seleniumWebDriverTestSetup);
    }
    
    /**
     * This method will be called in the {@link #setUp()}. The test case should
     * return a {@link SeleniumWebDriverTestSetup} instance with preferred setup.
     * If null is return; a default setup will be used with Firefox as Web Driver. 
     * See {@link SeleniumWebDriverTestSetup}. 
     * @return the test setup
     */
    protected abstract SeleniumWebDriverTestSetup getSeleniumWebDriverTestSetup();

    
    /**
     * This method will 
     */
    @Override
    @After
    protected void tearDown() throws Exception {
        try {
            super.tearDown();
    } finally {
        
        if (seleniumWebDriverTestSetup.getWebDriver() != null) {
            seleniumWebDriverTestSetup.getWebDriver().quit();
            seleniumWebDriverTestSetup = null;
        }
      }
    }
    
    /**
     * Returns the current Selenium Web Driver set in {@link SeleniumWebDriverTestSetup#getWebDriver()}
     * @return the web driver
     */
    protected WebDriver getWebDriver() {
        return seleniumWebDriverTestSetup.getWebDriver();
    }
    
    /**
     * Returns the current base URL set in {@link SeleniumWebDriverTestSetup#getBaseURL()}
     * @return the base URL
     */
    protected String getBaseURL() {
        return seleniumWebDriverTestSetup.getBaseURL();
    }
    
    /**
     * Creates a default {@link SeleniumWebDriverTestSetup} with Firefox as 
     * Web Driver.
     * @return a default test setup
     */
    private SeleniumWebDriverTestSetup createDeafultTestSetup() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver webDriver = new FirefoxDriver(firefoxProfile);
        return new SeleniumWebDriverTestSetup(webDriver);
    }
}
