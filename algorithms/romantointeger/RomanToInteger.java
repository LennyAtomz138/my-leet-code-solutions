/**
 * Background:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, 2 is written as II in Roman numeral, just two one's added together. 
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

public class RomanToInteger
{
    public static int romanToInteger(String s)
    {
        // Convert string to `char[]` array.
        char[] chars = s.toCharArray();

        int accumulator = 0;

        /** TODO: Fix case where s = MCMXCIV; should be 1994, not 2216; 2216-1994=222
         * Note that amounts need to be subtracted for the following scenarios:
         * CM = 900
         * XC = 90
         * IV = 4
         *
         * ==For reference==:
         * (https://www.romannumerals.org/blog/rules-for-formation-of-roman-numerals-15#:~:text=In%20any%20given%20Roman%20number%2C%20if%20a%20symbol,than%20one%20value%20%28symbol%29%20from%20a%20Roman%20numeral.)
         * Rule 4: When Should I Subtract?
         * In any given Roman number, if a symbol is placed before a larger one, you subtract.
         * In other words, when you see a smaller number is on the left of a larger one, you subtract.
         *
         * A note to remember here is that while you can add more than two values,
         * you cannot subtract more than one value (symbol) from a Roman numeral.
         *
         * Example:
         *
         * IV = V − I = 5 − 1 = 4
         *
         * IX = X − I = 10 − 1 = 9
         *
         * XL = L - X = 50 - 10 = 40
         *
         * XC = C - X = 100 - 10 = 90
         *
         * TODO: Can I still go with a switch statement here? Need to check for Rule #4!!!
         */
        // Iterate over `char[]` array using enhanced for-loop.
        for(int i = 0; i < chars.length; i++)
        {
            // change it to a number
            switch (chars[i])
            {
                case 'I':
                    accumulator += 1;
                    break;
                case 'V':
                    accumulator += 5;
                    break;
                case 'X':
                    accumulator += 10;
                    break;
                case 'L':
                    accumulator += 50;
                    break;
                case 'C':
                    accumulator += 100;
                    break;
                case 'D':
                    accumulator += 500;
                    break;
                case 'M':
                    accumulator += 1000;
                    break;
                default:
                    break;
            }
        }
        return accumulator;
    }

    public static void main(String[] args)
    {
        // Run the program from within main().
        System.out.println(romanToInteger("MCMXCIV"));
    }
}