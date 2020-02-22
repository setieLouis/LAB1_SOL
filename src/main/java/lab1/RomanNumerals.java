package lab1;

/**
 * Hello world!
 *
 */
public class RomanNumerals
{
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
     * @param Arabic to roman
     * @return String
     */
    public String arabicToRoman(int value) {
        if(value <= 0)
            throw  new IllegalArgumentException();
        int  unit = value % TEN;
        int  dozens = (value % HUNDREDS)  - unit;
        int hunderds = (value % 1000 ) - (dozens + unit);
        int  thousands = (value / 1000 ) ;
        return getThousands(thousands)  +  gethundreds(hunderds)  + getDozens(dozens) + getUnit(unit);
    }

    private String getThousands(int value) {
      return repeatSimbol("M", value);
    }
    private String gethundreds(int value) {
        if(value > THREE_HUNDREDS)
            return hundredsUpperThreeHundreds(value);
        return  repeatSimbol("C", value/HUNDREDS);
    }
    private String getDozens(int value) {
        if(value > THIRTY)
            return dozensUpperThirty(value);
        return  repeatSimbol("X", value/10);
    }
    private String getUnit(int value) {
        if(value > THREE)
            return unitUpperThree(value);
        return  repeatSimbol("I", value);
    }

    private String hundredsUpperThreeHundreds(int  value){
        if(value > FIVE_HUNDREDS  && value < NINE_HUNDREDS)
            return getSpecialUnit(FIVE_HUNDREDS)  +    repeatSimbol("C" ,(value -  FIVE_HUNDREDS)/HUNDREDS );
        return getSpecialUnit(value);
    }
    private String dozensUpperThirty(int  value){
        if(value > FIFTY  && value < NINETY)
            return getSpecialUnit(FIFTY)  +    repeatSimbol("X" ,(value -  FIFTY)/10 );
        return getSpecialUnit(value);
    }
    private String unitUpperThree(int value ){
        if(value > FIVE && value < NINE)
            return getSpecialUnit(FIVE)  +    repeatSimbol("I" ,value -  FIVE );
        return getSpecialUnit(value);
    }

    private String   getSpecialUnit(int value ){
        switch (value){
            case 4:  return "IV";
            case 5: return "V";
            case 9: return "IX";
            case 40: return "XL";
            case 50: return "L";
            case 90: return "XC";
            case 500: return "D";
            case 400: return "CD";
            case 900: return "CM";
            default: return "";
        }
    }

    private String repeatSimbol(String simbol ,  int times){
        String result ="";
        for(int i = 0; i < times ; i++)
            result += simbol;
        return result;
    }



    public String romanToArabic(String i) {

        return null;
    }
}
