package com.polopoly.ps.psselenium.agent;

import static junit.framework.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CodeMirrorAgent {

    private GUIAgent guiAgent;
    private JavascriptExecutor jsExecutor;

    public CodeMirrorAgent(GUIAgent guiAgent) {
        this.guiAgent = guiAgent;
        jsExecutor = (JavascriptExecutor) guiAgent.getWebDriver();
    }

    /**
     *
     * @param editorName
     * @param editorContent Must not contain \n characters or \" characters
     */
    public void setText(String editorName, String editorContent)
    {
        String componentid = getComponentId(editorName);
        assertFalse("CodeMirrorAgent does not support setting text that contains \"", editorContent.contains("\""));
        assertFalse("CodeMirrorAgent ECMAScript® string literals can not contain newlines characters, did you mean \\n?,", editorContent.contains("\n"));
        jsExecutor.executeScript("window.codemirror_" + componentid + ".setValue(\"" + editorContent + "\")");
    }

    private String getComponentId(String editorname)
    {
        String locator = "//h2[text()='" + editorname + "']/following-sibling::textarea";
        WebElement codeMirrorEditor = guiAgent.getWebDriver().findElement(By.xpath(locator));
        assertNotNull("CodeMirror editor with name '" + editorname + "' not found", codeMirrorEditor);

        return codeMirrorEditor.getAttribute("id");
    }
}
