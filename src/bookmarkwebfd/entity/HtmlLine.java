/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarkwebfd.entity;

import bookmarkwebfd.cfg.ELineType;

/**
 *
 * @author alex
 */
public class HtmlLine {
    
    private int position;
    private String lineContent;
    private String lineTagStart;
    private String lineTagEnd;
    private int depth;
    private Boolean content;
    private Boolean opener;
    private Boolean closer;
    private Boolean other;
   
    public HtmlLine(int position, String lineContent, String lineTagStart, String lineTagEnd, String type) {
        this.position = position;
        this.lineContent = lineContent;
        this.lineTagStart = lineTagStart;
        this.lineTagEnd = lineTagEnd;
        this.depth = 0;
        
        switch(ELineType.valueOf(type)){
            case content:
                typesSetter();
                this.content=true;
            case opener:
                typesSetter();
                this.opener=true;
            case closer:
                typesSetter();
                this.closer=true;
            default:
                typesSetter();
                this.other=true;
        }   
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
        typesSetter();
        this.content = content;
    }

    public Boolean isOpener() {
        return opener;
    }

    public void setOpener(Boolean opener) {
        typesSetter();
        this.opener = opener;
    }

    public Boolean isCloser() {
        return closer;
    }

    public void setCloser(Boolean closer) {
        typesSetter();
        this.closer = closer;
    }

    public Boolean isOther() {
        return other;
    }

    public void setOther(Boolean other) {
        typesSetter();
        this.other = other;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    private void typesSetter(){
        this.content=false;
        this.opener=false;
        this.closer=false;
        this.other=false;
    }
    
}
