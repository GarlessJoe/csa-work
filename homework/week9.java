package homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class week9 {
    static Random random = new Random();
    public static void printArr(int[] nums){
        System.out.println(Arrays.toString(nums));
    }

    public static int[] task1(int[] nums){
        int[] res = new int[nums.length];
        Stack<Integer> integers = new Stack<Integer>();
        for(int i = 0 ;i < nums.length ;i++){

            int j = 0 ;
            while(!integers.isEmpty() && nums[integers.peek()] < nums[i] ){
               res[integers.peek()] =i - integers.peek();
               integers.pop();
            }
            integers.push(i);
        }
        return res;
    }
    public static int[] task2(int[] nums){
        int[] res = new int[nums.length];
        int num0 = 0 ,num1 = 0 ,num2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) num0++;
            if(nums[i] == 1) num1++;
            if(nums[i] == 2) num2++;
        }
       int k = 0;
        while(num0 != 0) {
            res[k++] = 0;
            num0--;
        }
        while(num1 != 0) {
            res[k++] = 1;
            num1--;
        }
        while(num2 != 0) {
            res[k++] = 2;
            num2--;
        }
        return  res;
    }
    public static void test(){
        int[]nums1=new int[random.nextInt(20)+1];
        for(int i=0;i<nums1.length;i++)
            nums1[i]=random.nextInt(30)-10;
        printArr(nums1);
        printArr(task1(nums1));
        System.out.println("======================");
        int[]nums2=new int[random.nextInt(20)+1];
        for(int i=0;i<nums2.length;i++)
            nums2[i]=random.nextInt(3);
        printArr(nums2);
        printArr(task2(nums2));
    }
    public static void main(String[] args) {
            test();
    }
}
