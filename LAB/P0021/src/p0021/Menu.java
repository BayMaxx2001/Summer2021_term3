package p0021;

public class Menu {
    private int sizeOfMenu = -1 ;
    private String[] listMenuStrings = new String[15];
    public void addMenu(String patten )
    {
        sizeOfMenu++;
        //System.out.println(sizeOfMenu);
        listMenuStrings[sizeOfMenu] = patten;
        
    }
    public void InitMenu()
    {
        addMenu("=============WELCOME TO STUDENT MANAGEMENT===========");
        addMenu("1. Create");
        addMenu("2. Find and Sort");
        addMenu("3. Update/Delete");
        addMenu("4. Report");
        addMenu("5. Exit");
    }
    public void displayListMenu()
    {
        System.out.println();
        int cnt = -1; 
        for (String string : listMenuStrings) {
            cnt ++; 
            System.out.println(string);
            if ( cnt == sizeOfMenu ) break;
        }
    }
}
