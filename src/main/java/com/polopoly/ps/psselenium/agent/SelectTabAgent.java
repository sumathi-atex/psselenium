package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This agent interacts with tabs panes in the Polopoly Admin GUI. 
 */
public class SelectTabAgent {

    private final GUIAgent guiAgent;

    public SelectTabAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
    }
    
    /**
     * Selects and opens a tab with a specific title
     * @param tabTitle the title of tab
     */
    public SelectTabAgent selectTab(String tabTitle) {
        
        String classString = null;
        WebDriver webDriver = guiAgent.getWebDriver();
        
        try {
            WebElement webElement = webDriver.findElement(By.xpath("//div[@class='tabbedMenu']/ul/li/a[contains(text(),'"+ tabTitle+"')]/.."));
            classString = webElement.getAttribute("class");
        } catch (NoSuchElementException e) {
        }

        if (!"selected".equals(classString)) {

            WebElement webElement = webDriver.findElement(By.xpath("//div[@class='tabbedMenu']/ul/li/a[contains(text(),'"+tabTitle+"')]"));
            String hrefAttribute = webElement.getAttribute("href");
            webElement.click();
            
            if (hrefAttribute.contains("idleCursor()")) { // Ajax tab
                guiAgent.waitAgent().waitForAjaxPageToLoad();
            } else {
                guiAgent.waitAgent().waitForPageToLoad();
            }
        }
        return this;
    }
}
