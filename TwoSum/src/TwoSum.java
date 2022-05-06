/*
* Overview:
* Given an array of integers nums and an integer target,
* return indices of the two numbers such that they add up to target.
*
* Conditions and Constraints:
* You may assume that each input would have exactly one solution,
* and you may not use the same element twice.You can return the answer in any order.
* */

import org.jetbrains.annotations.NotNull;

import java.sql.Array;
import java.util.Arrays;

public class TwoSum
{
    public int[] twoSum(int @NotNull [] nums, int target)
    {
        int[] sentArr = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            // compare the current index with remaining array elements
            if((nums[i] + nums[i+1]) == target)
            {
                sentArr[0] = i;
                sentArr[1] = i+1;
            }
            // if == target; return the indices that made that happen
        }
        return sentArr;
    }

    public void main()
    {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] twoNumArr = twoSum(arr, target);
        System.out.println(Arrays.toString(twoNumArr));
    }
}
