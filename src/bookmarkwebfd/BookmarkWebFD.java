/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarkwebfd;

import bookmarkwebfd.entity.HtmlLine;
import bookmarkwebfd.resource.Constantes;
import bookmarkwebfd.resource.HTag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

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
                while((line = reader.readLine())!= null){
                    String hLine = line;
                    String beginTag = hLine.substring(0, 4);
                    Boolean content = false;
                    if(HTag.DT.equals(beginTag) || HTag.DD.equals(beginTag)){
                        content = true;
                    }
                    HtmlLine newLine = new HtmlLine(hLine, beginTag, "","content");
                    htmlLines.add(newLine);
                }
                
                
                
            }
            catch(Exception exception) {
                LOGGER.log(Level.SEVERE, exception.toString(), exception);
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }            
    }   
}
