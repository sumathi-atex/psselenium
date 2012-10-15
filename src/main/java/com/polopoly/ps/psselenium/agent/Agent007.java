package com.polopoly.ps.psselenium.agent;

import com.polopoly.ps.psselenium.SimpleGUIAgent;

public class Agent007 {

  @SuppressWarnings("unused")
  private final SimpleGUIAgent simpleGUIAgent;

  public Agent007(SimpleGUIAgent simpleGUIAgent) {
    this.simpleGUIAgent = simpleGUIAgent;
  }
  
  public String introduceMyself() {
    return "My name is Bond, James Bond";
  }
}
