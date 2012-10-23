package com.polopoly.ps.psselenium.agent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * This agent interacts with Polopoly quick content creator fields in the Polopoly Admin GUI.
 */
public class QuickContentCreatorAgent {

    private final GUIAgent guiAgent;

    public QuickContentCreatorAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
    }
    
    /**
     * Creates a content using the quick content creator.  
     * @param label The label in the quick creator of the content to create.
     * @return this
     */
    public QuickContentCreatorAgent createContent(String label) {
    
        return createContent(label, 0);
    }
    
    /**
     * Creates a content using the quick content creator with a specific section title.
     * @param label The label in the quick creator of the content to create.
     * @param index The index of the item to create. Useful if the provided label results in several entries.
     * @return this
     */
    public QuickContentCreatorAgent createContent(String label, int index) {
        
        if(index < 0){
            throw new IllegalArgumentException("You need to specify a positive index rather than " + index);
        }

        guiAgent.agentFrame().selectNavFrame();
        WebDriver webDriver = guiAgent.getWebDriver();
        String selectLocator = "//div[@class='quickCreator contentCreator container']//a//span[text()='" + label + "']/../../a";
        this.guiAgent.getWebDriver().findElement(By.xpath(selectLocator));
        List<WebElement> webElements = webDriver.findElements(By.xpath(selectLocator));
        WebElement createLink = webElements.get(index);
        createLink.click();
        
        return this;
    }
}
