package com.polopoly.ps.psselenium;

import com.polopoly.ps.psselenium.agent.Agent007;
import com.polopoly.ps.psselenium.agent.GUIAgent;
import com.polopoly.ps.psselenium.agent.GUIAgentBase;
import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

public interface SimpleGUIAgentInterface extends GUIAgent{
  
  public Agent007 agent007();
  
}
