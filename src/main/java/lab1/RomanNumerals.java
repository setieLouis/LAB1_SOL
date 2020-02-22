package lab1;

/**
 * Hello world!
 *
 */
public class RomanNumerals
{
    public static final int CENT = 100;
    public static final int TEN = 10;
    public static final int FIFTY = 50;
    private static int NINE = 9;
    private static int FIVE = 5;
    private static int THREE = 3;

    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public String arabicToRoman(int value) {
        int  unit = value % TEN;
        int  dozens = (value % CENT)  - unit;
        return  getDozens(dozens) + getUnit(unit);
    }

    private String getDozens(int value) {
        if( value == TEN)
            return "X";
        else if( value == FIFTY)
            return "L";
        return "";
    }

    private String getUnit(int value) {
        String result ="";
        if(value > THREE)
           return unitUpperFive(value);
        for(int i = 0; i < value ; i++)
            result += "I";
        return result;
    }

    private String unitUpperFive(int value ){
        if(value > FIVE && value < NINE)
          return getSpecialUnit(FIVE)  +   getUnit(value -  FIVE );
        return getSpecialUnit(value);
    }

    private String   getSpecialUnit(int value ){
        switch (value){
            case 4:  return "IV";
            case 5: return "V";
            case 9: return "IX";
            default: return "";
        }
    }

}
