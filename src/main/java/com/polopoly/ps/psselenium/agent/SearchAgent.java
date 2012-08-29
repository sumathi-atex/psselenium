package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchAgent {

    private final GUIAgent guiAgent;

    public SearchAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
    }
    
    /**
     * Performs a free text search in the Polopoly Admin GUI  
     * @param searchText the text to search for
     * @return this agent
     */
    public SearchAgent search(String searchText) {
        
        guiAgent.frameAgent().selectSearchFrame();
        
        String locator = "//div[@id='search']//input[contains(@class,'searchInput')]";
        
        WebDriver webDriver = guiAgent.getWebDriver();
        
        WebElement element = webDriver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(searchText, Keys.RETURN);
        
        guiAgent.waitAgent().waitForAjaxPageToLoad();
        
        return this;
    }
    
    /**
     * This will check if a certain text string exists in the search result pane.  
     * @param text the text string to check
     * @return true if exists
     */
    public boolean isPresentInSearchResult(String text) {
        guiAgent.frameAgent().selectSearchFrame();
        String locator = "//div[contains(@class, 'searchAreaResult')]//div[contains(@class, 'searchAreaResultItem')]//*[text() ='"+text+"']";
        return guiAgent.getWebDriver().findElements(By.xpath(locator)).size() > 0;
    }
    
    /**
     * Gets the number of the search hits
     * @return this agent
     */
    public int getNumberOfSearchHits() {
        guiAgent.frameAgent().selectSearchFrame();
        WebDriver webDriver = guiAgent.getWebDriver();
        WebElement element = webDriver.findElement(
                By.xpath("//div[@id='search']//span[@class='numberOfResults']"));
        return Integer.valueOf((String)((JavascriptExecutor)webDriver).executeScript("return arguments[0].innerHTML",element));
    }
    
    /**
     * Filter the search result by facet navigation for a specific category 
     * @param categoryType the title of category type 
     * @param category the label of the category
     * @return this agent
     */
    public SearchAgent filterSearchOn(String categoryType, String category) {
        guiAgent.frameAgent().selectSearchFrame();
        
        showFilterPane();
       
        String locator = "//div[contains(@class,'search_facets')]";
        
        if (categoryType != null) {
            locator += "/ul[contains(@class,'facets_fields')]/li[contains(text(), '" + categoryType + "')]";
        }
        
        locator += "//a[contains(text(),'"+category+"')]";

        guiAgent.getWebDriver().findElement(By.xpath(locator)).click();
        guiAgent.waitAgent().waitForAjaxPageToLoad();
        
        return this;
    }
    
    /**
     * Filter the search result by facet navigation for a specific category 
     * @param category the label of the category
     * @return this agent
     */
    public SearchAgent filterSearchOn(String category) {
        filterSearchOn(null, category);
        return this;
    }
    
    /**
     * Display the search filter pane.
     * @return this agent
     */
    public SearchAgent showFilterPane() {
        
        guiAgent.frameAgent().selectSearchFrame();
        
        String locator = "//div[@id='search']//li[contains(@class,'facets_toggle')]"; 
        WebDriver webDriver = guiAgent.getWebDriver();
        if (webDriver.findElements(By.xpath(locator + "/a[contains(@class, 'active')]")).isEmpty()) {
            webDriver.findElement(By.xpath(locator + "/a")).click();
        }
        
        return this;
    }
    
    /**
     * Hide the search filter pane
     * @return this agent
     */
    public SearchAgent hideFilterPane() {
        guiAgent.frameAgent().selectSearchFrame();
        
        String locator = "//div[@id='search']//li[contains(@class,'facets_toggle')]/a[contains(@class, 'active')]";
        WebDriver webDriver = guiAgent.getWebDriver();
        if (webDriver.findElements(By.xpath(locator)).size() == 1) {
            webDriver.findElement(By.xpath(locator)).click();
        }
        return this;
    }
}
