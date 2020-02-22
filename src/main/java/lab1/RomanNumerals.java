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
            if(value == 1)
                return "I";
            else if(value == 2)
                return "II";
            return "III";
    }
}
