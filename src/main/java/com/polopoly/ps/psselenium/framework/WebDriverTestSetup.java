package com.polopoly.ps.psselenium.framework;

import org.openqa.selenium.WebDriver;

/**
 * This class holds test setup for Web Driver Tests. 
 */
public class WebDriverTestSetup {

    private WebDriver webDriver;
    private String baseURL = "http://localhost:8080";
    // private String connectionPropertiesURL = "http://localhost:8081/connection.properties/connection.properties";
    
    /**
     * Constructor
     * @param webDriver the Web Driver use for test process
     */
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
}
