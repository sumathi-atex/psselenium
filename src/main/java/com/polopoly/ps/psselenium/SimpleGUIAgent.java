package com.polopoly.ps.psselenium;

import com.polopoly.ps.psselenium.agent.Agent007;
import com.polopoly.ps.psselenium.agent.GUIAgentBase;
import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

public class SimpleGUIAgent extends GUIAgentBase {
  
  private Agent007 agent007;

  public SimpleGUIAgent(WebDriverTestSetup webDriverTestSetup) {
    super(webDriverTestSetup);

    // Create your agents here
    agent007 = new Agent007(this);
  }
  
  public Agent007 agent007() {
    return agent007;
  }
}
