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

        int left = 0;
        int right = numbers.length - 1;

        while(left <= right)
        {
            int midpoint = left + (right - left) / 2;
            if (numbers[midpoint] == target)
            {
                return midpoint;
            }
            else if(numbers[midpoint] > target)
            {
                right = midpoint - 1;
            }
            else 
            {
                left = midpoint + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int array[] = {11,22,33,44,55,66,77,88,99};
        int searchTerm = 88;
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
