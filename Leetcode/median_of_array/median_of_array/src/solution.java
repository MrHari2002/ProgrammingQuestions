public class solution {
    public static void main(String[] args) {
        solution solution = new solution();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); 
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        double median = 0;
        int[] nums_sum = new int[nums1.length+nums2.length];
            while(k<nums1.length+nums2.length){
                if(i<nums1.length&&j<nums2.length){
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
                else if(j<nums2.length){
                    nums_sum[k] = nums2[j];
                    k++;
                    j++;
                }
                else{
                    nums_sum[k] = nums2[i];
                    k++;
                    i++;
                }
            }
        if ((k) % 2 == 0) {
            int sumOfMiddleElements = nums_sum[(k+1) / 2] +
                                      nums_sum[(k+1) / 2 - 1];
            // calculate average of middle elements
            median = ((double) sumOfMiddleElements) / 2;
         } else {
            // get the middle element
            median = (double) nums_sum[(k+1)/2];
        }
        for(int a:nums_sum){
            System.out.println(a);
        }
         return median;   
        }
}
