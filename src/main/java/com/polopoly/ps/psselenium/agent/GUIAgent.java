package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.WebDriver;

import com.polopoly.ps.psselenium.framework.SeleniumWebDriverTestCase;
import com.polopoly.ps.psselenium.framework.SeleniumWebDriverTestSetup;

/**
 * This agent acts as a holder for agents that interacts with the Polopoly Admin GUI.
 * Every test of {@link SeleniumWebDriverTestCase} has a reference to a {@link GUIAgent}.  
 */
public class GUIAgent {
    
    private LoginAgent loginAgent;
    private LogoutAgent logoutAgent;
    private WaitAgent waitAgent;
    private ContentNavigatorAgent contentAgent;
    private ActionEventAgent actionEventAgent;
    private FrameAgent frameAgent;
    private InputAgent inputAgent;
    private WYSIWYGEditorAgent WYSIWYGEditor;
    private ToolbarAgent toolbarAgent;
    private ClipboardAgent clipboardAgent;
    private SelectTabAgent selectTabAgent;
    private ContentCreatorAgent contentCreatorAgent;
    private TreeSelectAgent treeSelectAgent;
    private SearchAgent searchAgent;

    private final SeleniumWebDriverTestSetup testSetup;
    
    public GUIAgent(SeleniumWebDriverTestSetup testSetup) {
        this.testSetup = testSetup;
        createAgents();
    }

    protected void createAgents() {
        
        loginAgent = new LoginAgent(this);
        logoutAgent = new LogoutAgent(this);
        waitAgent = new WaitAgent(this, 60L);
        actionEventAgent = new ActionEventAgent(this);
        frameAgent = new FrameAgent(this);
        contentAgent = new ContentNavigatorAgent(this);
        WYSIWYGEditor = new CKEditorAgent(this);
        inputAgent = new InputAgent(this, WYSIWYGEditor);
        toolbarAgent = new ToolbarAgent(this);
        clipboardAgent = new ClipboardAgent(this);
        selectTabAgent = new SelectTabAgent(this);
        contentCreatorAgent = new ContentCreatorAgent(this);
        treeSelectAgent = new TreeSelectAgent(this);
        searchAgent = new SearchAgent(this);
    }
    
    public WebDriver getWebDriver() {
        return testSetup.getWebDriver();
    }
    
    public String getBaseURL() {
        return testSetup.getBaseURL();
    }

    public LoginAgent loginAgent() {
        return loginAgent;
    }

    public LogoutAgent logoutAgent() {
        return logoutAgent;
    }

    public WaitAgent waitAgent() {
        return waitAgent;
    }
    
    public ActionEventAgent actionEventAgent() {
        return actionEventAgent;
    }
    
    public FrameAgent frameAgent() {
        return frameAgent;
    }

    public ContentNavigatorAgent contentNavigatorAgent() {
        return contentAgent;
    }

    public InputAgent inputAgent() {
        return inputAgent;
    }

    public ToolbarAgent toolbarAgent() {
        return toolbarAgent;
    }
    
    public ClipboardAgent clipboardAgent() {
        return clipboardAgent;
    }
    
    public SelectTabAgent selectTabAgent() {
        return selectTabAgent;
    }
    
    public ContentCreatorAgent contentCreatorAgent() {
        return contentCreatorAgent;
    }
    
    public TreeSelectAgent treeSelectAgent() {
        return treeSelectAgent;
    }
    
    public SearchAgent searchAgent() {
        return searchAgent;
    }
}
