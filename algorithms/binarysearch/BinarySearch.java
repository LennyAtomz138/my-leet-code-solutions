/*
Given an array of integer numbers which is sorted in ascending order, 
and an integer target, write a function to search target in numbers. 
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity. 
*/
package binarysearch;

public class BinarySearch 
{
    /* search(<an array of integers>, <a target integer>) */
    public static int binarySearch(int[] numbers, int target) 
    {
        if(numbers.length == 0) return -1;

        // Q: Why is right 1 less than the length of numbers array?
        // A: Because left is 0-indexed; while loop would throw an exception if full length was used.
        int left = 0;
        int right = numbers.length - 1;

        while(left <= right)
        {
            // Iteration 0: midpoint = (0 + (8-0)) / 2 = 8/2 = 4
            int midpoint = left + (right - left) / 2;
            // In this case, the target value has been found.
            if (numbers[midpoint] == target) 
            {
                return midpoint;
            }
            // In this case, the target value is smaller, so search the left half.
            else if(numbers[midpoint] > target)
            {
                right = midpoint - 1;
            }
            // In this case, the target value is larger, so search the right half.
            else 
            {
                left = midpoint + 1;
            }
        }
        return -1;
    }

    /**
     * The main() method is where the program begins.
     */
    public static void main(String[] args)
    {
        int array[] = {11,22,33,44,55,66,77,88,99};
        int searchTerm = 88;
        // This is where binarySearch() is first invoked.
        if(binarySearch(array, searchTerm) == -1)
        {
            System.out.println("Not Found");
        }
        else
        {
            System.out.println("Found");
        }
    }
}
