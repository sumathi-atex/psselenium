package com.polopoly.ps.psselenium.agent;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This agent handles log in of users into the Polopoly Admin GUI.  
 */
public class LoginAgent {
    
    private static Logger LOG = Logger.getLogger(LoginAgent.class.getName());
    
    private final GUIAgent guiAgent;

    public LoginAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
    }
    
    /**
     * Log in with an Admin GUI user into the Polopoly Admin GUI. Always log out 
     * the current user.
     * @param username the user login name
     * @param password the user login password
     * @return this agent
     */
    public LoginAgent login(String username, String password) {
        
        try {
            guiAgent.agentLogout().logout();
        } catch (Throwable e) {
            LOG.log(Level.WARNING, "Exception occur while logging out", e);
        }
        
        WebDriver webDriver = guiAgent.getWebDriver();
        
        webDriver.get(guiAgent.getBaseURL() + "/polopoly/Login.jsp");
        webDriver.findElement(By.name("j_username")).sendKeys(username);
        webDriver.findElement(By.name("j_password")).sendKeys(password);
        
        webDriver.findElement(By.name("mainform")).submit();
        webDriver.switchTo().window(webDriver.getWindowHandle());

        // Wait for all frames
        WaitAgent waitAgent = guiAgent.agentWait();
        
        waitAgent.waitForElement(By.id("mainframeset"));
        
        FrameAgent frameAgent = guiAgent.agentFrame();

        frameAgent.selectNavFrame();
        waitAgent.waitForPageToLoad();
        frameAgent.selectUserSessionFrame();
        waitAgent.waitForPageToLoad();
        frameAgent.selectWorkFrame();
        waitAgent.waitForPageToLoad();
        
        webDriver.switchTo().defaultContent();
        
        return this;
    }
    
    /**
     * Log in if necessary as an Admin GUI user into the Polopoly Admin GUI.
     * @param username the user login name
     * @param password the user login password
     * @return this agent
     */
    public LoginAgent loginIfNecessary(String username, String password)
    {
        WebDriver webDriver = guiAgent.getWebDriver();
        webDriver.switchTo().window(webDriver.getWindowHandle());

        if (webDriver.findElements(By.id("mainframeset")).isEmpty()) {
            return login(username, password);
        }
        
        return this;
    }
    
    /**
     * Log in as user 'sysadmin' into the Polopoly Admin GUI
     * @return this agent
     */
    public LoginAgent loginAsSysadmin() {
        return login("sysadmin", "sysadmin");
    }
    
    /**
     * Log in if necessary as user 'sysadmin' into the Polopoly Admin GUI
     * @return this agent
     */
    public LoginAgent loginIfNecessaryAsSysadmin() {
        return loginIfNecessary("sysadmin", "sysadmin");
    }
}
