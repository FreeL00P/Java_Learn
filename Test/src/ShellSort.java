import java.util.Arrays;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/14 22:23    since 1.0.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={170,-368,148,672,397,-629,-788,192,170,309,-615,-237};
        shellOrder(arr);
        System.out.println(Arrays.toString(arr));
    }
    public  static void shellOrder(int[] nums){
        for (int gap= nums.length/2;gap>0;gap/=2){
            for(int i=gap;i<nums.length;i++){
                for(int j=i-gap;j>0;j-=gap){
                    if(nums[j]>nums[j+gap]){
                        int temp=nums[j+gap];
                        nums[j+gap]=nums[j];
                        nums[j]=temp;
                    }
                }
            }
        }
    }
}
