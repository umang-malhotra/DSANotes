package src.CodingQuestions;

/**
 * Problem 1 Leetcode - 33
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity
 * Note - unique elements
 */


/**
 * Problem 2 - Variation
 * Find the index of the pivot at which array is rotated (Index of minimum element)
 * Note - unique elements in array
 */

/**
 * Problem 3 - Variation [Hard]
 * Return index of the target, but array have duplicates
 */

/**
 * Problem 4
 * Find the index of the pivot at which array is rotated (Index of minimum element)
 * Note - unique elements in array
 */
public class SearchInSortedArray {
    /**
     * Solution lies in following observation-
     * At any solution space bw low and high, with mid = (low+high)/2
     * either of low to mid or mid to high is sorted, so you can either search in that space or discard that space.
     * So rules of binary search prevails
     */

    public static int searchUtil(int[] nums, int target, int low, int high ){
        if(low > high) {
            return -1;
        }
        int mid = (low+high)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[low] <= nums[mid]) { // that means lower half is sorted, direct search in lower half
            if(nums[low] <= target && target <= nums[mid]){
                return searchUtil(nums, target, low, mid-1);
            } else {
                return searchUtil(nums, target, mid+1, high);
            }
        } else {
            if(nums[mid] <= target && target <= nums[high]){
                return searchUtil(nums, target, mid+1, high);
            } else {
                return searchUtil(nums, target, low, mid-1);
            }
        }
    }

    public static int searchInRotated(int[] nums, int k) {
        return searchUtil(nums, k, 0, nums.length-1);
    }

    /////////////////////////////////////
    /**
     * Hint for 2nd problem-
     * It is same as above, if first half is rotated, look in the second half. Viceversa.
     * Add base conditions of trivials
     */
    public static int findMinUtil(int[] nums, int low, int high) {
        if(low>high){
            return low;
        }
        int mid = (low+high)/2;
        if(nums[low] <= nums[mid] && nums[mid] <= nums[high]){
            return low;
        }

        if(nums[low] <= nums[mid]){
            return findMinUtil(nums, mid+1, high);
        } else return findMinUtil(nums, low, mid);
    }

    // This solution does not work for problem 4
    public static int findMin(int[] nums) {
        return findMinUtil(nums, 0, nums.length-1);
    }

    /////////////////////////////////


    //This solution works for both problem 2 and 4
    public static int problem4(int[] nums) {
        if(nums.length == 0 || nums.length ==1) {
            return nums.length;
        }

        int low = 0, high = nums.length-1;

        if(nums[0] <= nums[high]){
            return 0;
        }

        while (low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] > nums[mid+1]){
                return mid+1;
            }

            if(nums[mid-1] > nums[mid]) {
                return mid;
            }

            if(nums[0] <= nums[mid]) {
                low = mid +1;
            } else high = mid-1;
        }
        return -1;
    }


    public static void main(String[] args) {

        /**
         * Test case for Problem - Search and return index of position in Rotated Array
         */
        int[] nums = { 1, 2, 3, 4, 1 };
        System.out.println("Index of Target " + searchInRotated(nums, 18));

        /**
         * Test case for 2nd Problem - find index of rotated pivot
         */
        System.out.println("Index of minimum element (pivot)" + findMin(nums));

        System.out.println("Index of minimum element (pivot)" + problem4(nums));
    }
}

/**
 * Fundas -
 *
 * If it is roateted by pivot k, then all elements to the right of the pivot are smaller than all elements to the left of the pivot
 *
 * At any point either of one half is sorted, therefore can extend and keep on doing the search by keep on dividing the search space in half.
 */
