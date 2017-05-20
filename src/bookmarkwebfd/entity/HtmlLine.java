/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarkwebfd.entity;

import bookmarkwebfd.cfg.lineType;

/**
 *
 * @author alex
 */
public class HtmlLine {
    
    private String lineContent;
    private String lineTagStart;
    private String lineTagEnd;
    private Boolean content;
    private Boolean opener;
    private Boolean closer;
    private Boolean other;
   
    public HtmlLine(String lineContent, String lineTagStart, String lineTagEnd, String type) {
        this.lineContent = lineContent;
        this.lineTagStart = lineTagStart;
        this.lineTagEnd = lineTagEnd;
        
        switch(lineType.valueOf(type)){
            case content:
                typesSetter();
                this.content=true;
            case other:
                typesSetter();
                this.other=true;
            case opener:
                typesSetter();
                this.opener=true;
            case closer:
                typesSetter();
                this.closer=true;
        }
        
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

    public Boolean isContent() {
        return content;
    }

    public void setContent(Boolean content) {
        this.content = content;
    }

    public Boolean isOpener() {
        return opener;
    }

    public void setOpener(Boolean opener) {
        this.opener = opener;
    }

    public Boolean isCloser() {
        return closer;
    }

    public void setCloser(Boolean closer) {
        this.closer = closer;
    }

    public Boolean isOther() {
        return other;
    }

    public void setOther(Boolean other) {
        this.other = other;
    }
    
    private void typesSetter(){
        this.content=false;
        this.opener=false;
        this.closer=false;
        this.other=false;
    }
}
