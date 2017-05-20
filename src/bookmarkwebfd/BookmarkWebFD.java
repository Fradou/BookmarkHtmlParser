/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarkwebfd;

import bookmarkwebfd.entity.HtmlLine;
import bookmarkwebfd.resource.Constantes;
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
        
        LOGGER.log(Level.WARNING, "Ca marche");
        String pathApp = null;
        try {
            pathApp = new File(".").getCanonicalPath();
            System.out.println("path : "+ pathApp);
        } catch (IOException ex) {
            Logger.getLogger(BookmarkWebFD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    //    for(String browser : Constantes.JSON_PATH.keySet()){
            
            String path = Constantes.PATH_FIREFOX.toString();
        //    File bookmarks = new File(browser);
            
        //    StringBuilder bookmarks = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String line = "";
                List<HtmlLine> htmlLines = new ArrayList<HtmlLine>();
                while((line = reader.readLine())!= null){
                    String hLine = line;
                    String baliseStart = line.substring(0, 3);
                    String balideEnd = line.substring(-4, -1);
                    
                    HtmlLine newLine = new HtmlLine(hLine, baliseStart, balideEnd);
                    htmlLines.add(newLine);
                }
                String patternStr =  "<p>";
                Pattern pattern = Pattern.compile(patternStr);
        //        String[] bookSplit = pattern.split(bookmarkHtml);
                
                System.out.println("1er block : ");
            }
            catch(Exception exception) {
                LOGGER.log(Level.SEVERE, exception.toString(), exception);
            }
            
    }   
}
