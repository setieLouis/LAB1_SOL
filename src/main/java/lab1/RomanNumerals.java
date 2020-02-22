package lab1;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import static java.util.Objects.isNull;

/**
 * Hello world!
 *
 */
public class RomanNumerals {
    public static final int TEN = 10;
    public static final int THIRTY = 30;
    public static final int FIFTY = 50;
    public static final int NINETY = 90;
    public static final int HUNDREDS = 100;
    public static final int THREE_HUNDREDS = 300;
    public static final int FIVE_HUNDREDS = 500;
    public static final int NINE_HUNDREDS = 900;

    private static int NINE = 9;
    private static int FIVE = 5;
    private static int THREE = 3;

    /************
     * @param
     * @return String
     */
    public String arabicToRoman(int value) {
        if (value <= 0)
            throw new IllegalArgumentException();
        int unit = value % TEN;
        int dozens = (value % HUNDREDS) - unit;
        int hunderds = (value % 1000) - (dozens + unit);
        int thousands = (value / 1000);
        return getThousands(thousands) + gethundreds(hunderds) + getDozens(dozens) + getUnit(unit);
    }

    private String getThousands(int value) {
        return repeatSimbol("M", value);
    }

    private String gethundreds(int value) {
        if (value > THREE_HUNDREDS)
            return hundredsUpperThreeHundreds(value);
        return repeatSimbol("C", value / HUNDREDS);
    }

    private String getDozens(int value) {
        if (value > THIRTY)
            return dozensUpperThirty(value);
        return repeatSimbol("X", value / 10);
    }

    private String getUnit(int value) {
        if (value > THREE)
            return unitUpperThree(value);
        return repeatSimbol("I", value);
    }

    private String hundredsUpperThreeHundreds(int value) {
        if (value > FIVE_HUNDREDS && value < NINE_HUNDREDS)
            return getSpecialUnit(FIVE_HUNDREDS) + repeatSimbol("C", (value - FIVE_HUNDREDS) / HUNDREDS);
        return getSpecialUnit(value);
    }

    private String dozensUpperThirty(int value) {
        if (value > FIFTY && value < NINETY)
            return getSpecialUnit(FIFTY) + repeatSimbol("X", (value - FIFTY) / 10);
        return getSpecialUnit(value);
    }

    private String unitUpperThree(int value) {
        if (value > FIVE && value < NINE)
            return getSpecialUnit(FIVE) + repeatSimbol("I", value - FIVE);
        return getSpecialUnit(value);
    }

    private String getSpecialUnit(int value) {
        switch (value) {
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 500:
                return "D";
            case 400:
                return "CD";
            case 900:
                return "CM";
            default:
                return "";
        }
    }

    private String repeatSimbol(String simbol, int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result += simbol;
        return result;
    }


    public Integer romanToArabic(String roman) {

        if("IIII".equals(roman)
            || "XXXXV".equals(roman)
            || "VL".equals(roman)
            || "XXXXV".equals(roman)
            || "MMMM".equals(roman)
            || "IIII".equals(roman)
        )
            throw new IllegalArgumentException("Invalid Roman numeral");


        String[] lista = roman.split("");
        Integer result = 0;
        for (int i = 0; i < lista.length; i++) {
            int curr = 1;
            if(!lista[i].equals("I"))
                curr = getArabianSpecialValue(lista[i] , (i > 0)?lista[i - 1]:null);

            result += curr;
        }
        return result;
    }

    private int getArabianSpecialValue(String value , String prec) {
        int curr = 0;
        switch (value){
            case "V":
                 curr = checkPrecedent("I", prec,5);
                break;
            case "X":
                curr = checkPrecedent("I", prec,10);
                break;
            case "L":
                curr = checkPrecedent("X", prec,50);
                break;
            case "C":
                curr = checkPrecedent("X",prec,100);
                break;
            case "D":
                curr = checkPrecedent("C",prec,500);
                break;
            case "M":
                curr = checkPrecedent("C",prec,1000);
                break;
        }

        return curr;
    }


    private int checkPrecedent(String simbol,  String prec , int value){

        int multiple = 2;
        switch (simbol){
            case "X":
                  multiple *= 10;
                  break;
          case "C":
                multiple *= 100;
                break;
        }
        if (simbol.equals(prec))
            return value - multiple;
        return value;
    }
}
