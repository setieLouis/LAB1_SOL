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
          String result = "";
          if(value == 5 )
              return "V";
          for(int i = 0; i < value ; i++)
              result += "I";
          return result;
    }
}
