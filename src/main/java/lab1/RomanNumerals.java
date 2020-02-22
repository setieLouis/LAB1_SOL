package lab1;

/**
 * Hello world!
 *
 */
public class RomanNumerals
{
    public static final int CENT = 100;
    public static final int TEN = 10;
    public static final int THIRTY = 30;
    public static final int FIFTY = 50;
    public static final int NINETY = 90;
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
        int hunderds = (value % 1000 ) - (dozens + unit);
        int  thousands = (value / 1000 ) ;
        return getThousands(thousands)  +  gethundreds(hunderds)  + getDozens(dozens) + getUnit(unit);
    }

    private String getThousands(int thousands) {
        if(thousands == 1)
            return "M";
        return "" ;
    }

    private String gethundreds(int hunderds) {
        if(hunderds == 100)
            return "C";
        else if (hunderds == 500)
          return "D";
        return "";
    }

    private String getDozens(int value) {
        if(value > THIRTY)
            return dozensUpperThirty(value);
        return  repeatSimbol("X", value/10);
    }

    private String dozensUpperThirty(int  value){
        if(value > FIFTY  && value < NINETY)
            return getSpecialUnit(FIFTY)  +    repeatSimbol("X" ,(value -  FIFTY)/10 );
        return getSpecialUnit(value);
    }

    private String getUnit(int value) {
        if(value > THREE)
           return unitUpperThree(value);
       return  repeatSimbol("I", value);
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
}
