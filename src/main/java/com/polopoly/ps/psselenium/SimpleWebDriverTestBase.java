package com.polopoly.ps.psselenium;

import com.polopoly.ps.psselenium.framework.WebDriverTestBase;
import com.polopoly.ps.psselenium.framework.WebDriverTestSetup;

public class SimpleWebDriverTestBase extends WebDriverTestBase<SimpleGUIAgent> {

  @Override
  protected SimpleGUIAgent createGUIAgent(WebDriverTestSetup webDriverTestSetup) {
    return new SimpleGUIAgent(webDriverTestSetup);
  }
}
