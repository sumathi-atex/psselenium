package com.polopoly.ps.psselenium.framework;

//import com.polopoly.application.Application;
//import com.polopoly.cm.client.CmClient;
//import com.polopoly.cm.client.EjbCmClient;
// import com.polopoly.gui.orchid.util.PolopolyApplication;

/**
 *  This singleton class is an application that provides Polopoly Application clients
 *  to within a test process.     
 */
public class TestApplication {
    
//    private static Object[] mutex = new Object[0];
//    private static boolean initialized = false;
//    private static Application application;
    private TestApplication() {}
    
    /**
     * Creates an {@link PolopolyApplication} with different Polopoly Application
     * components.  
     * @param connectionPropertiesURL the connection properties URL
     * @throws Exception
     */
//    public static void init(String connectionPropertiesURL) throws Exception {
//        
//        synchronized (mutex) {
//            if (!initialized) {
//                application = PAFTestApplicationFactory.createApplication(connectionPropertiesURL);
//                initialized = true;
//            }
//        }
//    }
    
    /**
     * Returns a {@link CmClient} that communicates with the CM backend.
     * @return a CM Client
     */
//    public static CmClient getCmClient() {        
//        return (CmClient) application.getApplicationComponent(
//                EjbCmClient.DEFAULT_COMPOUND_NAME);
//    }
}
