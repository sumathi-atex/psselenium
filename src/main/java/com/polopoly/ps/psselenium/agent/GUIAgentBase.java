package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.WebDriver;

import com.polopoly.ps.psselenium.framework.WebDriverTestBase;
import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

/**
 * This agent acts as a holder for agents that interacts with the Polopoly Admin GUI.
 * Every test of {@link WebDriverTestBase} has a reference to a {@link GUIAgentBase}.  
 */
public abstract class GUIAgentBase implements GUIAgent {
    
    private LoginAgent loginAgent;
    private LogoutAgent logoutAgent;
    private WaitAgent waitAgent;
    private ContentNavigatorAgent contentAgent;
    private ActionEventAgent actionEventAgent;
    private FrameAgent frameAgent;
    private InputAgent inputAgent;
    private CKEditorAgent ckEditor;
    private ToolbarAgent toolbarAgent;
    private ClipboardAgent clipboardAgent;
    private SelectTabAgent selectTabAgent;
    private ContentCreatorAgent contentCreatorAgent;
    private TreeSelectAgent treeSelectAgent;
    private SearchAgent searchAgent;

    private final WebDriverTestSetup webDrivertTestSetup;
    
    public GUIAgentBase(WebDriverTestSetup webDriverTestSetup) {
        this.webDrivertTestSetup = webDriverTestSetup;
        createAgents();
    }

    protected void createAgents() {
        
        loginAgent = new LoginAgent(this);
        logoutAgent = new LogoutAgent(this);
        waitAgent = new WaitAgent(this, 60L);
        actionEventAgent = new ActionEventAgent(this);
        frameAgent = new FrameAgent(this);
        contentAgent = new ContentNavigatorAgent(this);
        ckEditor = new CKEditorAgent(this);
        inputAgent = new InputAgent(this, ckEditor);
        toolbarAgent = new ToolbarAgent(this);
        clipboardAgent = new ClipboardAgent(this);
        selectTabAgent = new SelectTabAgent(this);
        contentCreatorAgent = new ContentCreatorAgent(this);
        treeSelectAgent = new TreeSelectAgent(this);
        searchAgent = new SearchAgent(this);
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#getWebDriver()
     */
    public WebDriver getWebDriver() {
        return webDrivertTestSetup.getWebDriver();
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#getBaseURL()
     */
    public String getBaseURL() {
        return webDrivertTestSetup.getBaseURL();
    }

    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentLogin()
     */
    public LoginAgent agentLogin() {
        return loginAgent;
    }

    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentLogout()
     */
    public LogoutAgent agentLogout() {
        return logoutAgent;
    }

    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentWait()
     */
    public WaitAgent agentWait() {
        return waitAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentActionEvent()
     */
    public ActionEventAgent agentActionEvent() {
        return actionEventAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentFrame()
     */
    public FrameAgent agentFrame() {
        return frameAgent;
    }

    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentContentNavigator()
     */
    public ContentNavigatorAgent agentContentNavigator() {
        return contentAgent;
    }

    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentInput()
     */
    public InputAgent agentInput() {
        return inputAgent;
    }

    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentToolbar()
     */
    public ToolbarAgent agentToolbar() {
        return toolbarAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentClipboard()
     */
    public ClipboardAgent agentClipboard() {
        return clipboardAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentSelectTab()
     */
    public SelectTabAgent agentSelectTab() {
        return selectTabAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentContentCreator()
     */
    public ContentCreatorAgent agentContentCreator() {
        return contentCreatorAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentTreeSelect()
     */
    public TreeSelectAgent agentTreeSelect() {
        return treeSelectAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#agentSearch()
     */
    public SearchAgent agentSearch() {
        return searchAgent;
    }
    
    /* (non-Javadoc)
     * @see com.polopoly.ps.psselenium.agent.GUIAgent#getWebDriverTestSetup()
     */
    public WebDriverTestSetup getWebDriverTestSetup() {
      return webDrivertTestSetup;
    }
}
