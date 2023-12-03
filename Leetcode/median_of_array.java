class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int k = 0;
    double median = 0;
    int[] nums_sum = new int[nums1.length+nums2.length];
        while(i!=nums1.length&j!=nums2.length){
            if(nums1[i]<nums2[j]){
                nums_sum[k]= nums1[i];
                k++;
                i++;
            }
            else{
                nums_sum[k] = nums2[j];
                k++;
                j++;
            }
        }
    if ((k+1) % 2 == 0) {
        int sumOfMiddleElements = nums_sum[(k+1) / 2] +
                                  nums_sum[(k+1) / 2 - 1];
        // calculate average of middle elements
        median = ((double) sumOfMiddleElements) / 2;
     } else {
        // get the middle element
        median = (double) nums_sum[(k+1)/2];
    }
     return median;   
    }
}