package com.polopoly.ps.psselenium.agent;

import junit.framework.AssertionFailedError;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This agent navigates (opens a content in a view or edit mode) in the Polopoly Admin Gui. 
 */
public class ContentNavigatorAgent {

    // private static final int OPEN_CONTENT_WAIT_MAX_TIME = 10 * 1000;
    private final GUIAgent guiAgent;
    

    public ContentNavigatorAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
    }

    /**
     * Opens a content in view mode in the work frame 
     * @param contentIdString the content to open. Either a real content id or 
     * an external content id
     * @return this agent
     * @throws Exception
     */
    public ContentNavigatorAgent openContent(final String contentIdString) throws Exception {
        return internalOpenOrEditContent("view", contentIdString);
    }
    
    /**
     * Open a content in view or edit mode. 
     * @param actionEventName the action event name: 'view' or 'edit'
     * @param contentIdString the content to open
     * @return this agent
     * @throws AssertionFailedError if not able to open the content
     * @throws Exception
     */
    private ContentNavigatorAgent internalOpenOrEditContent(
            final String actionEventName,
            final String contentIdString) throws AssertionFailedError,
            Exception {
        guiAgent.agentFrame().selectWorkFrame();
        guiAgent.agentActionEvent().triggerActionEvent(actionEventName, 
                                                          contentIdString,
                                                          "work");
        guiAgent.agentWait().waitForPageToLoad();
        
//        final ContentId contentId;
//        try {
//            contentId = getContentId(contentIdString);
//        } catch (Exception e) {
//            throw new AssertionFailedError("Failed to verify that the requested " +
//            		"content was opened. ContentId: " + contentIdString 
//            		+ ", Exception: " + e.getMessage());
//        }
//        
//        final WebDriver webDriver = guiAgent.getWebDriver();
//        final String checkedContentIdString = contentId.getContentIdString();
//        
//        
//        
//        // Fallback
//        if (!isContentOpen(webDriver, checkedContentIdString)) {
//            
//            AssertRetry.assertRetry(OPEN_CONTENT_WAIT_MAX_TIME, 1000, new AssertRetry.Function() {
//                public void doAssert() throws Exception {
//                    guiAgent.agentFrame().selectWorkFrame();
//                    guiAgent.agentActionEvent().triggerActionEvent(actionEventName, 
//                            checkedContentIdString, "work");
//                    guiAgent.agentWait().waitForPageToLoad();
//                    
//                    if (!isContentOpen(webDriver, checkedContentIdString)) {
//                        throw new AssertionFailedError("The content with id: " 
//                                + checkedContentIdString + " was never opened");
//                    }
//                }
//            });
//        }
        
        return this;
    }
    
    
//    private boolean isContentOpen(final WebDriver webDriver, String contentIdString) {
//        try {
//            WebElement webElement = webDriver.findElement(
//                    By.xpath("//div[@class='content-info' and contains(@id,'content-info-" + contentIdString + "')]"));
//            
//            if (webElement != null) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
    
    
//    private ContentId getContentId(String contentIdString) throws Exception {
//        
//         CMServer cmServer = TestApplication.getCmClient().getCMServer();
//        
//        ContentId contentId = null;
//
//        try {
//            contentId = ContentIdFactory.createContentId(contentIdString);
//        } catch (IllegalArgumentException iae) {
//            ContentRead content = cmServer.getContent(new ExternalContentId(contentIdString));
//            contentId = content.getContentId();
//        }
//
//        return contentId;
//    }
    
    /**
     * Returns the current opened/active content's id
     * @return a content id
     * @throws Exception
     */
    public String getOpenedContentContentId() throws Exception {
        WebDriver webDriver = guiAgent.getWebDriver();
        String attributeId = webDriver.findElement(By.className("content-info")).getAttribute("id");
        return attributeId.substring("content-info-".length());
    }
    
    /**
     * Checks if the current opened/active content is locked
     * @return true if locked
     */
    public boolean isOpenedContentLocked() throws Exception {
        WebDriver webDriver = guiAgent.getWebDriver();
        if (webDriver.findElements(By.xpath("//div[@class = 'content-info']//img[contains(@src, 'lock.png')]")).size() == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Opens a content in edit mode in the work frame
     * @param contentIdString the content to open. Either a real content id or 
     * an external content id
     * @return this agent
     * @throws Exception 
     */
    public ContentNavigatorAgent editContent(String contentIdString) throws Exception {
        openContent(contentIdString);
        guiAgent.agentToolbar().clickOnEdit();
        return this;
    }
}
