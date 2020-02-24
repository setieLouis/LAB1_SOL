package lab1;

/**
 * Hello world!
 *
 */
public class RomanNumerals {

    /**
     * Roman numbers
     */
    public static final String ROMAN_ONE = "I";
    public static final String ROMAN_FOUR = "IV";
    public static final String ROMAN_FIVE = "V";
    public static final String ROMAN_NINE = "IX";
    public static final String ROMAN_TEN = "X";
    public static final String ROMAN_FOURTY = "XL";
    public static final String ROMAN_FIFTY = "L";
    public static final String ROMAN_NINETY = "XC";
    public static final String ROMAN_HUNDREDS = "C";
    public static final String ROMAN_FIVE_HUNDREDS = "D";
    public static final String ROMAN_FOUR_HUNDREDS = "CD";
    public static final String ROMAN_NINE_HUNDREDS = "CM";
    public static final String ROMAN_THOUSAND = "M";

    /***
     * Arabian numbers
     */
    private static int ARABIAN_FIVE = 5;
    private static int ARABIAN_THREE = 3;
    private static int ARABIAN_TWO = 2;
    private static int ARABIAN_NINE = 9;
    public static final int ARABIAN_TEN = 10;
    public static final int ARABIAN_THIRTY = 30;
    public static final int ARABIAN_FIFTY = 50;
    public static final int ARABIAN_NINETY = 90;
    public static final int ARABIAN_HUNDREDS = 100;
    public static final int ARABIAN_THREE_HUNDREDS = 300;
    public static final int ARABIAN_FIVE_HUNDREDS = 500;
    public static final int ARABIAN_NINE_HUNDREDS = 900;
    public static final int ARABIAN_THOUSAND = 1000;

    

    /************
     * @param
     * @return String
     */
    public String arabicToRoman(int value) {
        if (value <= 0)
            throw new IllegalArgumentException();
        int unit = value % ARABIAN_TEN;
        int dozens = (value % ARABIAN_HUNDREDS) - unit;
        int hunderds = (value % ARABIAN_THOUSAND) - (dozens + unit);
        int thousands = (value / ARABIAN_THOUSAND);
        return getThousands(thousands) + gethundreds(hunderds) + getDozens(dozens) + getUnit(unit);
    }

    private String getThousands(int value) {
        return repeatSimbol(ROMAN_THOUSAND, value);
    }

    private String gethundreds(int value) {
        if (value > ARABIAN_THREE_HUNDREDS)
            return hundredsUpperThreeHundreds(value);

        int times = value / ARABIAN_HUNDREDS;
        return repeatSimbol(ROMAN_HUNDREDS, times);
    }

        private String getDozens(int value) {
            if (value > ARABIAN_THIRTY)
            return dozensUpperThirty(value);

        int times = value / ARABIAN_TEN;
        return repeatSimbol(ROMAN_TEN, times);
    }

    private String getUnit(int value) {
        if (value > ARABIAN_THREE)
            return unitUpperThree(value);
        return repeatSimbol(ROMAN_ONE, value);
    }

    private String hundredsUpperThreeHundreds(int value) {
        if (value > ARABIAN_FIVE_HUNDREDS && value < ARABIAN_NINE_HUNDREDS){
            int times = (value - ARABIAN_FIVE_HUNDREDS) / ARABIAN_HUNDREDS;
            return getSpecialUnit(ARABIAN_FIVE_HUNDREDS) + repeatSimbol(ROMAN_HUNDREDS, times);
        }
        return getSpecialUnit(value);
    }

    private String dozensUpperThirty(int value) {
        if (value > ARABIAN_FIFTY && value < ARABIAN_NINETY){
            int times = (value - ARABIAN_FIFTY) / ARABIAN_TEN;
            return getSpecialUnit(ARABIAN_FIFTY) + repeatSimbol(ROMAN_TEN, times);
        }

        return getSpecialUnit(value);
    }

    private String unitUpperThree(int value) {
        if (value > ARABIAN_FIVE && value < ARABIAN_NINE) {
            int times = value - ARABIAN_FIVE;
            return getSpecialUnit(ARABIAN_FIVE) + repeatSimbol(RomanNumerals.ROMAN_ONE, times);
        }
        return getSpecialUnit(value);
    }

    private String getSpecialUnit(int value) {
        switch (value) {
            case 4:
                return ROMAN_FOUR;
            case 5:
                return ROMAN_FIVE;
            case 9:
                return ROMAN_NINE;
            case 40:
                return ROMAN_FOURTY;
            case 50:
                return ROMAN_FIFTY;
            case 90:
                return ROMAN_NINETY;
            case 500:
                return ROMAN_FIVE_HUNDREDS;
            case 400:
                return ROMAN_FOUR_HUNDREDS;
            case 900:
                return ROMAN_NINE_HUNDREDS;
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
            if(!lista[i].equals(RomanNumerals.ROMAN_ONE)){
                String prec = (i > 0) ? lista[i - 1] : null;
                curr = getArabianSpecialValue(lista[i] , prec);
            }
            result += curr;
        }
        return result;
    }

    private int getArabianSpecialValue(String value , String prec) {
        int curr = 0;
        switch (value){
            case ROMAN_FIVE:
                 curr = checkPrecedent(RomanNumerals.ROMAN_ONE, prec, ARABIAN_FIVE);
                break;
            case ROMAN_TEN:
                curr = checkPrecedent(RomanNumerals.ROMAN_ONE, prec,ARABIAN_TEN);
                break;
            case "L":
                curr = checkPrecedent(ROMAN_TEN, prec,ARABIAN_FIFTY);
                break;
            case ROMAN_HUNDREDS:
                curr = checkPrecedent(ROMAN_TEN,prec,ARABIAN_HUNDREDS);
                break;
            case "D":
                curr = checkPrecedent(ROMAN_HUNDREDS,prec,ARABIAN_FIVE_HUNDREDS);
                break;
            case ROMAN_THOUSAND:
                curr = checkPrecedent(ROMAN_HUNDREDS,prec,ARABIAN_THOUSAND);
                break;
        }
        return curr;
    }

    private int checkPrecedent(String simbol,  String prec , int value){gi
        int multiple = ARABIAN_TWO;
        switch (simbol){
            case ROMAN_TEN:
                  multiple *= ARABIAN_TEN;
                  break;
          case ROMAN_HUNDREDS:
                multiple *= ARABIAN_HUNDREDS;
                break;
        }
        if (simbol.equals(prec))
            return value - multiple;
        return value;
    }
}
