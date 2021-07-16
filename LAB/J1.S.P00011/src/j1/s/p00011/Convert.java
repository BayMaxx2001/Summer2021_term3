package j1.s.p00011;

import static j1.s.p00011.Validate.standard;
import java.math.BigDecimal;

public class Convert {
    
    public String convertDecToHex_Bin(String dec, int base) {
        StringBuilder answer = new StringBuilder();
        BigDecimal tempD = new BigDecimal(dec);
        BigDecimal remaind;
        while (!tempD.equals(BigDecimal.ZERO)) {
            remaind = tempD.remainder(new BigDecimal(base));//chia lấy dư bigdecimal
            int mod = remaind.intValue(); //parse bigdecimal sang int
            String temp = "";
            switch (mod) {
                case 10:
                    temp = "a";
                    break;
                case 11:
                    temp = "b";
                    break;
                case 12:
                    temp = "c";
                    break;
                case 13:
                    temp = "d";
                    break;
                case 14:
                    temp = "e";
                    break;
                case 15:
                    temp = "f";
                    break;
                default:
                    temp = mod + "";
            }
            answer.insert(0, temp);
            tempD = (tempD.subtract(remaind)).divide(new BigDecimal(base)); 
            //Trả về BigDecimal có giá trị là phần nguyên của thương
        }
        return standard(answer.toString());
    }

    public String convertToDec(String hex, int base) {
        hex = hex.toLowerCase();
        BigDecimal answer = new BigDecimal("0");
        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            int value = 0;
            switch (ch) {
                case 'a':
                    value = 10;
                    break;
                case 'b':
                    value = 11;
                    break;
                case 'c':
                    value = 12;
                    break;
                case 'd':
                    value = 13;
                    break;
                case 'e':
                    value = 14;
                    break;
                case 'f':
                    value = 15;
                    break;
                default:
                    value = Integer.parseInt(ch + "");
            }
            BigDecimal result = new BigDecimal(base).pow(hex.length() - 1 - i);  // result = pow(base,hex.length() - 1 - i
            answer = answer.add(new BigDecimal(value).multiply(result)); // answer = answer + value * result
        }
        return standard(String.valueOf(answer));
    }
}
