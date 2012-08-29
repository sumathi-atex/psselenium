package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * This agent triggers javascript action events based on the Polopoly Orchid Framework.
 * This agent should be used with caution.
 */
public class ActionEventAgent {

    private final GUIAgent guiAgent;

    public ActionEventAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
    }
    
    /**
     * Triggers an action event on the specified content id and waits for page to load . 
     * @param action the action to trigger
     * @param contentId the content the action will be trigger on
     * @return
     */
    public ActionEventAgent triggerActionEvent(String action, String contentId, String target) {
        
        WebDriver webDriver = guiAgent.getWebDriver();
        String openScript =
            "actionEventData({$action:'"+ action +"', $contentId:'"
                    + contentId + "', $target:'"+target+"'});";
        
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript(openScript);
        
        return this;
    }
}
