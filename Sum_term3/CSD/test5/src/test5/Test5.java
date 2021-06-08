/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test5;

/**
 *
 * @author BayMaxx
 */
public class Test5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readFile r1 = new readFile();
        MyListSong songList=new MyListSong();
        songList = r1.ReadFile();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Song List: ");
        songList.traverse();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Display all the songs which have the highest rated: ");
        songList.findMax();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Delete all the songs which have the second highest rated in the list: ");
        songList.deleteSecond();
        songList.traverse();
        SaveFile save = new SaveFile();
        save.SaveFile(songList);
        
    }
    
}
