package com.polopoly.ps.psselenium.agent;

/**
 * An interface for WYSIWYG Editor Agents to implement.
 *  
 */
public interface WYSIWYGEditorAgent {

    public void setText(String value) throws Exception;
    public void setText(String fieldLabel, String value) throws Exception;
    
    public String getText() throws Exception;
    public String getText(String fieldLabel) throws Exception;
    
    public void executeCommand(String command) throws Exception;
    public void executeCommand(String fieldLabel, String command) throws Exception;

}
