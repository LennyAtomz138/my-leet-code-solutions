/**
 * Background:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I            1
 * IV           4
 * V            5
 * IX           9
 * X            10
 * XL           40
 * L            50
 * XC           90
 * C            100
 * CD           400
 * D            500
 * CM           900
 * M            1000
 * 
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II. 
 * The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. 
 * However, the numeral for four is not IIII. Instead, the number four is written as IV. 
 * Because the one is before the five we subtract it making four. 
 * The same principle applies to the number nine, which is written as IX. 
 * 
 * There are six instances where subtraction is used:
 * - I can be placed before V (5) and X (10) to make 4 and 9. 
 * - X can be placed before L (50) and C (100) to make 40 and 90. 
 * - C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * Goal: Given a roman numeral, convert it to an integer.
 */
import java.util.HashMap;

public class RomanToInteger
{
    public static int romanToInteger(String s)
    {
        // Convert string to `char[]` array.
        char[] chars = s.toCharArray();

        int accumulator = 0;

        /*
          I saw this done in a better way:
          Use a mapping, then do two loops
        */
        // Create a hashmap of the Roman Numerals and respective integer values.
        HashMap<Character, Integer> romanNumeral = new HashMap<>();
        // Map each roman numeral to its respective decimal value.
        romanNumeral.put('I', 1);
        romanNumeral.put('V', 5);
        romanNumeral.put('X', 10);
        romanNumeral.put('L', 50);
        romanNumeral.put('C', 100);
        romanNumeral.put('D', 500);
        romanNumeral.put('M', 1000);

        /*
         Iterate over `char[]` array and aggregate respective values.
         chars[i] -> The Roman numeral at index `i`.
         romanNumeral.get(chars[i]) -> The Arabic number of Roman numeral at index `i`.
        */
        for(int i = 0; i < chars.length; i++)
        {
            // In this case, subtraction should be performed:
            if (i != chars.length-1) {
                if (romanNumeral.get(chars[i]) < romanNumeral.get(chars[i + 1])) {
                    // Subtract value returned from value created by i and i+1.
                    accumulator += romanNumeral.get(chars[i+1]) - romanNumeral.get(chars[i]);
                    i++;
                }
                else
                { // In this case, addition should be performed:
                    accumulator += romanNumeral.get(chars[i]);
                }
            }
            else
            { // In this case, addition should be performed:
                accumulator += romanNumeral.get(chars[i]);
            }
        }

        return accumulator;
    }

    public static void main(String[] args)
    {
        // Run the program from within main().
        System.out.println("III -> " + romanToInteger("III")); // Should return 3.
        System.out.println("LVIII -> " + romanToInteger("LVIII")); // Should return 58.
        System.out.println("MCMXCIV -> " + romanToInteger("MCMXCIV")); // Should return 1994.
    }
}