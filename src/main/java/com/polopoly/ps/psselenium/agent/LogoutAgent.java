package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This agent handles log out of users from the Polopoly Admin GUI.  
 */
public class LogoutAgent {

    private final GUIAgent guiAgent;

    public LogoutAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
    }
    
    /**
     * Log out the current Admin user from the Polopoly Admin GUI.
     * @return this agent
     */
    public LogoutAgent logout() {
        
        WebDriver webDriver = guiAgent.getWebDriver();
        
        if (webDriver.findElements(By.id("mainframeset")).size() == 1) {
            webDriver.get(guiAgent.getBaseURL() + "/polopoly/logout");
            guiAgent.agentWait().waitForElement(By.className("loginMessage"));
        }
        return this;
    }
}