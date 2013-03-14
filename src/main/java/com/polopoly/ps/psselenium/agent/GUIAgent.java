package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.WebDriver;

import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

public interface GUIAgent {

  public WebDriver getWebDriver();
  public String getBaseURL();
  public WebDriverTestSetup getWebDriverTestSetup();

  public LoginAgent agentLogin();
  public LogoutAgent agentLogout();
  public WaitAgent agentWait();
  public ActionEventAgent agentActionEvent();
  public FrameAgent agentFrame();
  public ContentNavigatorAgent agentContentNavigator();
  public InputAgent agentInput();
  public ToolbarAgent agentToolbar();
  public ClipboardAgent agentClipboard();
  public SelectTabAgent agentSelectTab();
  public ContentCreatorAgent agentContentCreator();
  public TreeSelectAgent agentTreeSelect();
  public SearchAgent agentSearch();
  public QuickContentCreatorAgent agentQuickContentCreator();
  public CodeMirrorAgent agentCodeMirror();

}