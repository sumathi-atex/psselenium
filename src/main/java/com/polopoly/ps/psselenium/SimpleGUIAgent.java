package com.polopoly.ps.psselenium;

import com.google.inject.Inject;
import com.polopoly.ps.psselenium.agent.Agent007;
import com.polopoly.ps.psselenium.agent.GUIAgentBase;
import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

import de.devsurf.injection.guice.annotations.Bind;

@Bind
public class SimpleGUIAgent extends GUIAgentBase implements SimpleGUIAgentInterface {
  
  private Agent007 agent007;
 
 @Inject
  public SimpleGUIAgent(WebDriverTestSetup webDriverTestSetup) {
    super(webDriverTestSetup);

    // Create your agents here
    agent007 = new Agent007(this);
  }
  
  public Agent007 agent007() {
    return agent007;
  }
}
