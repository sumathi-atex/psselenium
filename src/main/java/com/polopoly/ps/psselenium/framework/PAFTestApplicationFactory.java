package com.polopoly.ps.psselenium.framework;


//import com.polopoly.application.Application;
//import com.polopoly.application.ConnectionProperties;
//import com.polopoly.application.StandardApplication;
//import com.polopoly.cm.client.DiskCacheSettings;
//import com.polopoly.cm.client.EjbCmClient;
//import com.polopoly.common.ProductVersion;
//import com.polopoly.common.io.FileUtil;
//import com.polopoly.common.lang.PolopolyThread;
//import com.polopoly.management.jmx.JMXManagedBeanRegistry;

/**
 * An internal class used to create and setup a {@link TestApplication}. 
 */
public class PAFTestApplicationFactory {
    
//    private static Logger LOG = Logger.getLogger(PAFTestApplicationFactory.class.getName());
//    private static final String POLOPOLY_TEST_APPLICATION_NAME = "polopoly-test";

//    @SuppressWarnings("serial")
//    public static Application createApplication(String connectionPropertiesURL) throws Exception {
//        
//        File tempDir = FileUtil.createTempDir(POLOPOLY_TEST_APPLICATION_NAME, "dir");
//        tempDir.deleteOnExit();
//        
//        ProductVersion.CODE = new ProductVersion(0, 0, 0)  {
//            public boolean equals(Object o) {
//                return true;
//            }
//        };
//        
//        final Application application = new StandardApplication(POLOPOLY_TEST_APPLICATION_NAME);
//        setupApplicationComponentsAndInit(application, tempDir, connectionPropertiesURL);
//        
//        createHearthbeatThread(application);
//        
//         return application;
//    }

//    private static void createHearthbeatThread(final Application application) {
//        Thread thread = new PolopolyThread("Heartbeat thread") {
//            public void run() {
//                try {
//                    while (true) {
//                        application.triggerHeartbeat();
//                        Thread.sleep(1000);
//                    }
//                } catch (InterruptedException e) {
//                    LOG.log(Level.SEVERE, "Heartbeat thread interrupted!", e);
//                }
//            }
//        };
//        thread.setDaemon(true);
//        thread.start();
//    }

//    private static void setupApplicationComponentsAndInit(Application application, 
//                                                          File diskCacheBasePath, 
//                                                          String connectionPropertiesURL) 
//        throws Exception {
//        
//        // CM client.
//        EjbCmClient cmClient = new EjbCmClient();
//
//        DiskCacheSettings dcs = new DiskCacheSettings();
//        dcs.setContentCacheDirectory(new File(diskCacheBasePath, "contentcache"));
//        dcs.setFilesCacheDirectory(new File(diskCacheBasePath, "filescache"));
//        cmClient.setDiskCacheSettings(dcs);
//
//        application.addApplicationComponent(cmClient);
//        
//        application.readConnectionProperties(new ConnectionProperties(new URL(connectionPropertiesURL)));
//        application.init();
//        
//    }
}
