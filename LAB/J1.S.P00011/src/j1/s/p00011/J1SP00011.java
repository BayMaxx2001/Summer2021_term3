package j1.s.p00011;

//Change base number system (16, 10, 2) program. 
public class J1SP00011 {

    public static void main(String[] args) {
        Validate v = new Validate();
        Convert c = new Convert();
        while (true) {
            System.out.println("---------Choose--------");
            System.out.println("1. Convert to Binary");
            System.out.println("2. Convert to Decimal");
            System.out.println("3. Convert to Hexadecimal");
            System.out.print("Input your choice: ");
            int inBase = v.getChoice(1, 3);
            System.out.print("Output your choice: ");
            int outBase = v.getChoice(1, 3);
            String value = v.getValue(inBase);
            String tmp = "";
            switch (inBase) {
                case 1:
                    if (outBase == 2) {
                        tmp = c.convertToDec(value, 2);
                    } else if (outBase == 3) {
                        tmp = c.convertToDec(value, 2);
                        tmp = c.convertDecToHex_Bin(tmp, 16);
                    } else {
                        tmp = value;
                    }
                    break;
                case 2:
                    if(outBase == 1) {
                        tmp = c.convertDecToHex_Bin(value, 2);
                    } else if (outBase == 3) {
                        tmp = c.convertDecToHex_Bin(value, 16);
                    } else {
                        tmp = value;
                    }
                    break;
                case 3:
                    if (outBase == 2) {
                        tmp = c.convertToDec(value, 16);
                    } else if (outBase == 1) {
                        tmp = c.convertToDec(value, 16);
                        tmp = c.convertDecToHex_Bin(tmp, 2);
                    } else {
                        tmp = value;
                    }
                    break;
                default:
                    break;
            }
            System.out.println("After change base: " + tmp);
        }
    }
}
