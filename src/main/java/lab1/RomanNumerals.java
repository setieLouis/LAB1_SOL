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
        value /= 10;
        if( value == FIVE)
            return "L";
        else if( value > 5 )
            return "L" + repeatSimbol("X", value - 5 );
        return  repeatSimbol("X", value);
    }

    private String getUnit(int value) {
        if(value > THREE)
           return unitUpperFive(value);
       return  repeatSimbol("I", value);
    }

    private String unitUpperFive(int value ){
        if(value > FIVE && value < NINE)
          return getSpecialUnit(FIVE)  +    repeatSimbol("I" ,value -  FIVE );
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

    private String repeatSimbol(String simbol ,  int times){
        String result ="";
        for(int i = 0; i < times ; i++)
            result += simbol;
        return result;
    }
}
