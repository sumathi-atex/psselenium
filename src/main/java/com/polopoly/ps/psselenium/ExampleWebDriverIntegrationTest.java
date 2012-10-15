package com.polopoly.ps.psselenium;

import org.junit.Test;

public class ExampleWebDriverIntegrationTest extends SimpleWebDriverTestBase {
  
  @Test
  public void shouldLoginAsSysadmin() throws Exception {
    
    guiAgent().agentLogin().loginAsSysadmin();
    
    // Custom agent 007
    guiAgent().agent007().introduceMyself();
    
    // Assertions
  }
}
