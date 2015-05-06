package com.gft.timesheet.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileGwtTest extends GWTTestCase {
  
  @Override
  public String getModuleName() {
    return "com.gft.timesheet.Timesheet";
  }

  public void testSandbox() {
    assertTrue(true);
  }
  
}
