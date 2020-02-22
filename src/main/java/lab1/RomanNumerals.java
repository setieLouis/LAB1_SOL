package lab1;

/**
 * Hello world!
 *
 */
public class RomanNumerals
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public String arabicToRoman(int value) {
        int  unit = value % 10;
        int  dozens = (value % 100)  - unit;
        return  getDozens(dozens) + getUnit(unit);

    }

    private String getDozens(int value) {
        if( value == 10)
            return "X";
        else if( value == 50)
            return "L";
        return "";
    }

    private String getUnit(int value) {

        String result ="";
        if(value == 5 )
            return "V";

        for(int i = 0; i < value ; i++)
            result += "I";
        return result;
    }


}
