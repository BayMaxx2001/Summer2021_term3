
package test5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class readFile {
    
    
    public MyListSong ReadFile(){
        BufferedReader br = null;
        MyListSong songList=new MyListSong();
        try {   
            br = new BufferedReader(new FileReader("D:\\Study\\Sum_term3\\CSD\\test5\\src\\test5\\songs.txt"));       
            //System.out.println("Đọc nội dung file sử dụng phương thức readLine()");
            String textInALine=br.readLine();

            while (textInALine != null) {
                Song song=SplitFile(textInALine);
                songList.addToTail(song);
                //System.out.println(song.toString());
                textInALine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return songList;
    }
    
    
    public Song SplitFile(String textInALine){
        String []b= textInALine.split("\\|");
        Song song=new Song(b[0].trim(),b[1].trim(),Integer.parseInt(b[2].trim()));
        return song;
    }
    
    
}
