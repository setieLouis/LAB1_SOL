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
          else if( value == 10)
              return "X";
          else if( value == 50)
              return "L";

          for(int i = 0; i < value ; i++)
              result += "I";
          return result;
    }
}
