/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test5;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class SaveFile {
    public void SaveFile(MyListSong m1){
        try {
          FileWriter myWriter = new FileWriter("D:\\Study\\Sum_term3\\CSD\\test5\\src\\test5\\output.txt");
          myWriter.write(m1.saveFile());
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
}
