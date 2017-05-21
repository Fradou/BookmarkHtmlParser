/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarkwebfd;

import bookmarkwebfd.cfg.ELineType;
import bookmarkwebfd.entity.HtmlLine;
import bookmarkwebfd.resource.Constantes;
import bookmarkwebfd.resource.HTag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class BookmarkWebFD {

    private static final Handler CSL_HANDLER = new ConsoleHandler();
    private static final Logger LOGGER = Logger.getLogger(BookmarkWebFD.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LOGGER.addHandler(CSL_HANDLER);
        
        String pathApp = null;
        try {
            pathApp = new File(".").getCanonicalPath();
            String path = Constantes.PATH_FIREFOX.toString();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(pathApp + path));
                String line = "";
                List<HtmlLine> htmlLines = new ArrayList<HtmlLine>();
                int lineNb = 0;
                while((line = reader.readLine())!= null){
                    if(line.length()>0){
                        int i = 0;
                        while(" ".equals(line.substring(i, i+1))){
                            i++;
                        }
                        String hLine = line.substring(i, i+4);
                        String beginTag = "";
                        try {
                            beginTag = hLine.substring(0, 4);
                        }
                        catch(Exception exception){
                            System.out.println("error de substring");
                        }
                        String tagType = "";
                        if(HTag.DT.equals(beginTag) || HTag.DD.equals(beginTag)){
                            tagType = ELineType.content.toString();
                        }
                        else if (HTag.DL.equals(beginTag)){
                            tagType = ELineType.opener.toString();
                        }
                        else if (HTag.DT_C.equals(beginTag)){
                            tagType = ELineType.closer.toString();                    
                        }
                        else {
                            tagType = ELineType.other.toString();
                        }
                        HtmlLine newLine = new HtmlLine(lineNb, hLine, beginTag, "",tagType);
                        htmlLines.add(newLine);
                        System.out.print("begin : " + beginTag + " type : " +tagType + " isContent : " + newLine.isContent());
                    }
                    
                    lineNb += 1;
                }
                
                List<HtmlLine> ListTr;
                ListTr = depthSetter(htmlLines);
                List<Integer> depthPool = new ArrayList<Integer>();
                
                for(HtmlLine lineD : ListTr){
                    depthPool.add(lineD.getDepth());
                }
                
                System.out.println("depth detail" + depthPool.toString());
                   
            }
            catch(Exception exception) {
                LOGGER.log(Level.SEVERE, exception.toString(), exception);
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }            
    }
    
    private static List<HtmlLine> depthSetter(List<HtmlLine> lines){
        
        lines.get(0).setDepth(1);
        for(int i=1; i<lines.size(); i++){
            HtmlLine currentLine = lines.get(i);
            HtmlLine previousLine = lines.get(i-1);
            if(previousLine.isOpener()){
                currentLine.setDepth(previousLine.getDepth() +1);
            }
            else if (previousLine.isContent() || previousLine.isOther()){
                if(currentLine.isContent() || currentLine.isOther()){
                    currentLine.setDepth(previousLine.getDepth());
                }
                else if (currentLine.isCloser()){
                    currentLine.setDepth(previousLine.getDepth()-1);
                }                   
            }
            else {
                currentLine.setDepth(previousLine.getDepth()-1);
            }
        }
        
        return lines;
    }
}
