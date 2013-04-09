package com.polopoly.ps.psselenium.framework;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

/**
 * This class holds test setup for Web Driver Tests. 
 */
public class WebDriverTestSetup {

    private WebDriver webDriver;
    private String baseURL = "http://localhost:8080";
    // private String connectionPropertiesURL = "http://localhost:8081/connection.properties/connection.properties";
    private boolean logOutAfterTest = true;

    /**
     * Constructor
     * @param webDriver the Web Driver use for test process
     */
    @Inject
    public WebDriverTestSetup(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
    
    /**
     * The base URL to the web application server. As default this is set 
     * to <code>http://localhost:8080</code>. 
     * @param baseURL the base URL
     */
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
    
    /**
     * Returns the base URL to the web application server.
     * @return the base URL
     */
    public String getBaseURL() {
        return baseURL;
    }
    
    /**
     * The URL to the {@link ConnectionProperties}. As default this is set to
     * <code>http://localhost:8081/connection.properties/connection.properties</code>
     * @param connectionPropertiesURL the URL to the connection properties. 
     */
    /*public void setConnectionPropertiesURL(String connectionPropertiesURL) {
        this.connectionPropertiesURL = connectionPropertiesURL;
    }*/
    
    /**
     * The connection properties URL
     * @return the connection properties URL
     */
    /*public String getConnectionPropertiesURL() {
        return connectionPropertiesURL;
    }*/
    
    /**
     * Return the Selenium Web Driver used for the test process
     * @return the web driver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }
    
    /**
     * Return true/false to signal if the web driver test base should log out the current user from the gui after a test completes
     * @return
     */
    public boolean isLogOutAfterTest() {
        return logOutAfterTest;
    }

    public void setLogOutAfterTest(boolean logOutAfterTest) {
        this.logOutAfterTest = logOutAfterTest;
    }

}
