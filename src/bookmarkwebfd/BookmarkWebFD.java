/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarkwebfd;

import bookmarkwebfd.resource.Constantes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class BookmarkWebFD {

    private static final Logger LOG = Logger.getLogger(BookmarkWebFD.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for(String browser : Constantes.JSON_PATH.keySet()){
            
            String path = Constantes.JSON_PATH.get(browser);
        //    File bookmarks = new File(browser);
            
            StringBuilder bookmarks = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String reader.toString();
                
            }
            catch(Exception exception) {
                
            }
            
        }
    }
    
}
