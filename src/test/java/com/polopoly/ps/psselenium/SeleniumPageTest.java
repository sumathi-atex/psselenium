package com.polopoly.ps.psselenium;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.polopoly.psselenium.SeleniumTestRunner;

@RunWith(SeleniumTestRunner.class)
public class SeleniumPageTest{
	
	@Inject 
	private SimpleGUIAgentInterface guiAgent;
	
	@Test
	public void shouldLoginAsSysadmin() throws Exception {
		
		guiAgent.agentLogin().loginAsSysadmin();
		guiAgent.agent007().introduceMyself();

	    //guiAgent().agentLogin().loginAsSysadmin();

	    // Custom agent 007
	    //guiAgent().agent007().introduceMyself();

	    // Assertions
	 }
	

}
