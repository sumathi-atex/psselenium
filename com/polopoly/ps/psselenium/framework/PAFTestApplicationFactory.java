package com.polopoly.ps.psselenium.framework;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

import com.polopoly.application.Application;
import com.polopoly.application.ConnectionProperties;
import com.polopoly.application.StandardApplication;
import com.polopoly.cm.client.DiskCacheSettings;
import com.polopoly.cm.client.EjbCmClient;
import com.polopoly.common.ProductVersion;
import com.polopoly.common.io.FileUtil;
import com.polopoly.common.lang.PolopolyThread;
import com.polopoly.management.jmx.JMXManagedBeanRegistry;

/**
 * An internal class used to create and setup a {@link TestApplication}. 
 */
public class PAFTestApplicationFactory {
    
    private static Logger LOG = Logger.getLogger(PAFTestApplicationFactory.class.getName());
    private static final String POLOPOLY_TEST_APPLICATION_NAME = "polopoly-test";

    @SuppressWarnings("serial")
    public static Application createApplication(String connectionPropertiesURL) throws Exception {
        
        File tempDir = FileUtil.createTempDir(POLOPOLY_TEST_APPLICATION_NAME, "dir");
        tempDir.deleteOnExit();
        
        ProductVersion.CODE = new ProductVersion(0, 0, 0)  {
            public boolean equals(Object o) {
                return true;
            }
        };
        
        final Application application = new StandardApplication(POLOPOLY_TEST_APPLICATION_NAME);
        setupApplicationComponentsAndInit(application, tempDir, connectionPropertiesURL);
        
        createHearthbeatThread(application);
        
        return application; 
    }

    private static void createHearthbeatThread(final Application application) {
        Thread thread = new PolopolyThread("Heartbeat thread") {
            public void run() {
                try {
                    while (true) {
                        application.triggerHeartbeat();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    LOG.log(Level.SEVERE, "Heartbeat thread interrupted!", e);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    private static void setupApplicationComponentsAndInit(Application application, 
                                                          File diskCacheBasePath, 
                                                          String connectionPropertiesURL) 
        throws Exception {
        
        // CM client.
        EjbCmClient cmClient = new EjbCmClient();

        DiskCacheSettings dcs = new DiskCacheSettings();
        dcs.setContentCacheDirectory(new File(diskCacheBasePath, "contentcache"));
        dcs.setFilesCacheDirectory(new File(diskCacheBasePath, "filescache"));
        cmClient.setDiskCacheSettings(dcs);

        application.addApplicationComponent(cmClient);

//        // Search client.
//        RmiSearchClient searchClient = new RmiSearchClient();
//        application.addApplicationComponent(searchClient);

        // Solr search client (Searches in the public index).
//        SolrSearchClient solrSearchClientPublic = new SolrSearchClient(SolrSearchClient.DEFAULT_MODULE_NAME,
//                                                           "solrClientPublic",
//                                                           cmClient);
//        solrSearchClientPublic.setIndexName(new SolrIndexName("public"));
//        application.addApplicationComponent(solrSearchClientPublic);
//
//        // Solr search client (Searches in the internal index).
//        SolrSearchClient solrSearchClientInternal = new SolrSearchClient(SolrSearchClient.DEFAULT_MODULE_NAME,
//                                                             "solrClientInternal",
//                                                             cmClient);
//        solrSearchClientInternal.setIndexName(new SolrIndexName("internal"));
//        application.addApplicationComponent(solrSearchClientInternal);

        // Statistics client
//        StatisticsClient statisticsClient = new StatisticsClient();
//        application.addApplicationComponent(statisticsClient);

        // Statistics rmi client.
//        RmiStatisticsGuiClient rmiStatisticsClient = new RmiStatisticsGuiClient();
//        application.addApplicationComponent(rmiStatisticsClient);

//        RmiNewsLetterClient rmiNewsLetterClient = new RmiNewsLetterClient();
//        application.addApplicationComponent(rmiNewsLetterClient);

        // Log message client (UDP)
//        UDPLogMsgClient udpLogMsgClient = new UDPLogMsgClient();
//        application.addApplicationComponent(udpLogMsgClient);

        // Cache.
//        LRUSynchronizedUpdateCache lruSyncCache = new LRUSynchronizedUpdateCache();
//        application.addApplicationComponent(lruSyncCache);

        // Poll client.
//        PollClient pollClient = new PollClient();
//        application.addApplicationComponent(pollClient);
        // Use short cache time for tests.
//        pollClient.setCacheSettings(new CacheSettings(1000, 1000));


//        CommunityClient communityClient =
//                new CommunityClient(cmClient,
//                                    statisticsClient,
//                                    null /* no log msg client */,
//                                    searchClient);
//        AdminUserUtil.getSettings().setUserName("forumsuperuser");
//        AdminUserUtil.getSettings().setPassword("forumsuperuser");
//        application.addApplicationComponent(communityClient);

//        RmiIndexerClient indexerClient = new RmiIndexerClient();
//        application.addApplicationComponent(indexerClient);
                
        MBeanServer mBeanServer = MBeanServerFactory.createMBeanServer();
        application.setManagedBeanRegistry(new JMXManagedBeanRegistry(mBeanServer));
        
        application.readConnectionProperties(new ConnectionProperties(new URL(connectionPropertiesURL)));
        application.init();
        
//        PollServer.setPollManager(pollClient.getPollManager());
    }
}
