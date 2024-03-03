package homework;

import java.util.ArrayList;
import java.util.List;

public class homework04 {


    public static int reserve(int x ){
        int result = 0;
    if(x > Math.pow(2,32)-1||x < -Math.pow(2,32)+1){return 0;}
    else{
    while(x != 0){
        int a = x%10;
        x = x/10;
        result = result * 10 + a;
     }
        return result;
    }
    }
    public static void subset(int[] nums , int i , List<Integer> temp, List<List<Integer>> result){
        if(i >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        else{
            subset(nums, i + 1, temp, result);
            temp.add(nums[i]);
            subset(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
public static int stairs(int x){
     if( x <= 2 ){
         return x;
     }else{
         return stairs(x-1)  + stairs(x -2);
     }
}
    public static void main(String[] args) {
        //System.out.println(reserve(120));
        System.out.println(stairs(2));
        int[] nums = {1,2,4};
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subset(nums, 0 ,temp,result);
        for (List<Integer> i:result){
            System.out.println(i);
        }
    }
}
