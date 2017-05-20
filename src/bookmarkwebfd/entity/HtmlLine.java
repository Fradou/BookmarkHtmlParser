/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarkwebfd.entity;

/**
 *
 * @author alex
 */
public class HtmlLine {
    
    private String lineContent;
    private String lineTagStart;
    private String lineTagEnd;
    
    public HtmlLine(String lineContent, String lineTagStart, String lineTagEnd) {
        this.lineContent = lineContent;
        this.lineTagStart = lineTagStart;
        this.lineTagEnd = lineTagEnd;
    }

    public String getLineContent() {
        return lineContent;
    }

    public void setLineContent(String lineContent) {
        this.lineContent = lineContent;
    }

    public String getLineTagStart() {
        return lineTagStart;
    }

    public void setLineTagStart(String lineTagStart) {
        this.lineTagStart = lineTagStart;
    }

    public String getLineTagEnd() {
        return lineTagEnd;
    }

    public void setLineTagEnd(String lineTagEnd) {
        this.lineTagEnd = lineTagEnd;
    }
    
    
    
}
