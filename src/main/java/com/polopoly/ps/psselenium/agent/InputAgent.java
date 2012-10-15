package com.polopoly.ps.psselenium.agent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This agent interacts on input control elements in the Polopoly Admin GUI.
 */
public class InputAgent {

    private final GUIAgent guiAgent;
    private final CKEditorAgent agentCKEditor;

    public InputAgent(GUIAgent guiAgent, CKEditorAgent agentCKEditor) {
        this.guiAgent = guiAgent;
        this.agentCKEditor = agentCKEditor;
    }
    
    /**
     * Types text into a textfield with a specific label
     * @param fieldLabel the label of the text field
     * @param value the text value to set
     * @return this agent
     */
    public InputAgent typeInTextfield(String fieldLabel, String value) {
        return typeInInternal("input", fieldLabel, value);
    }
    
    /**
     * Types text into a textarea with a specific label
     * @param fieldLabel the label of the text area
     * @param value the text value to set
     * @return this agent
     */
    public InputAgent typeInTextarea(String fieldLabel, String value) {
        return typeInInternal("textarea", fieldLabel, value);
    }
    
    /**
     * Internal method to type text into a input control element. 
     * @param type type of input control. "input", "textarea"
     * @param fieldLabel the label of the input field
     * @param value the value to set
     * @return this agent
     */
    private InputAgent typeInInternal(String type, String fieldLabel, String value) {
        String locator = getFieldLocator(fieldLabel, type);
        
        WebDriver webDriver = guiAgent.getWebDriver();
        WebElement webElement = webDriver.findElement(By.xpath(locator));
        webElement.sendKeys(value);
        
        return this;
    }
    
    /**
     * Returns the xpath location of the field type
     * @param fieldLabel the label of the input field
     * @param fieldType the input control type: "input", "textarea" 
     * @return a xpath location
     */
    private String getFieldLocator(String fieldLabel, String fieldType) {
        return "//h2[contains(text(), '"+ fieldLabel +"')]/..//"+ fieldType;
    }
    
    /**
     * Types a text in all WYSIWYG editor that are present
     * @param value the text to set
     * @return this agent
     * @throws Exception
     */
    public InputAgent typeInCKEditor(String value) throws Exception {
        agentCKEditor.setText(value);
        return this;
    }
    
    /**
     * Types a text in a WYSIWYG editor with a specific label
     * @param fieldLabel the label of the editor
     * @param value the text to set
     * @return this agent
     * @throws Exception
     */
    public InputAgent typeInCKEditor(String fieldLabel, String value) throws Exception {
        agentCKEditor.setText(value);
        return this;
    }
    
    /**
     * Returns the {@link CKEditorAgent} editor agent
     * @return a {@link CKEditorAgent} agent
     */
    public CKEditorAgent agentCKEditor() {
        return agentCKEditor;
    }
    
    /**
     * Selects an option in a select box with a specific label
     * @param fieldLabel the label of the selection field 
     * @param optionLabel the label of the option to select
     * @return this agent
     */
    public InputAgent select(String fieldLabel, String optionLabel) {
        Select selectBox = new Select(guiAgent.getWebDriver().findElement(
                By.xpath("//h2[text()='" + fieldLabel + "']/..//select")));
        selectBox.selectByVisibleText(optionLabel);
        return this;
    }
    
    /**
     * Checks (clicks on) a checkbox/radio alternative with a specific label 
     * @param fieldLabel the label of the radio alternative
     * @return this agent
     */
    public InputAgent check(String fieldLabel) {
        guiAgent.getWebDriver().findElement(
                By.xpath("//*[contains(text(),'" + fieldLabel + "')]/..//input[1]")).click();
        return this;
    }
    
    /**
     * Unchecks (clicks if selected) a checkbox/radio alternative with a specific label 
     * @param fieldLabel the label of the radio alternative
     * @return this agent
     */
    public InputAgent uncheck(String fieldLabel) {
        WebElement webElement = guiAgent.getWebDriver().findElement(By.xpath("//*[contains(text(),'" + fieldLabel + "')]/..//input[1]"));
        if (webElement.isSelected())  {
            webElement.click();    
        }
        return this;
    }
    
    /**
     * Returns the value of textfield with a specific field label
     * @param fieldLabel the label of the textfield 
     */
    public String getTextfieldValue(String fieldLabel) {
        return guiAgent.getWebDriver().findElement(
                By.xpath(getFieldLocator(fieldLabel, "input"))).getAttribute("value");
    }
    
    /**
     * Returns the value of textarea with a specific field label
     * @param fieldLabel the label of the textarea 
     */
    public String getTextareaValue(String fieldLabel) {
        return guiAgent.getWebDriver().findElement(
                By.xpath(getFieldLocator(fieldLabel, 
                                         "textarea"))).getText();
    }
}
