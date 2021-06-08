public class mainMenu{
    private int sizeOfMenu = -1 ;
    private String[] listMenuStrings = new String[6];
    public void addMenu(String patten )
    {
        sizeOfMenu++;
        //System.out.println(sizeOfMenu);
        listMenuStrings[sizeOfMenu] = patten;
        
    }
    public void InitMenu()
    {
        addMenu("1. Add employees");
        addMenu("2. Update employees");
        addMenu("3. Remove employees");
        addMenu("4. Search employees");
        addMenu("5. Sort employees by salary");
        addMenu("6. Exit");
    }
    public void displayListMenu()
    {
        System.out.println();
        for (String string : listMenuStrings) {
            System.out.println(string);
        }
    }
}