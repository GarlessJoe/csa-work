package homework;

import java.util.HashMap;
import java.util.Random;

public class homework07 {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1("abbc","dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
            System.out.println("target:"+target+"\tresult"+task3(new int[]
                    {0,4,5,6,8},target));
        }
    }
    public static void main(String[] args) {
        test();
    }
    public static boolean task1(String pattern , String str){
        boolean res = true;
        String[] strings ;
        strings = str.split(" ");
        char[] chars = pattern.toCharArray();
        if(strings.length != chars.length){
            res = false;
            return false;
        }
        HashMap<Character, String> m= new HashMap<>();
        for(int i = 0; i < chars.length;i++){

            if (!m.containsKey(chars[i])) {
                if(!m.containsValue(strings[i])){
                    m.put(chars[i] , strings[i]);
                }
                else{
                    res = false ;
                    break;
                }

            } else {
                if(!m.get(chars[i]).equals(strings[i])){
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
    public static int task2(int[] nums ){
        int res = 0 ;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if(!m.containsKey(num)){
                m.put(num,res);
            }else{
                int i = m.get(num)+1;
                m.put(num,i);
            }
        }
        for(Integer k : m.keySet()){
            if(m.get(k) > 0){
                res = k;
            }
        }
        return res;
    }
    public static int task3(int[] nums, int target) {
        int res = binarySearch(nums, target, 0, nums.length - 1);
        if(res == -1){
            if(target > nums[nums.length - 1]){
                res = res = -(nums.length+1) - 1;
            }
            else {
                for (int i = 0; i < nums.length; i++) {
                    if (target > nums[i] && target <= nums[i + 1]) {
                        res = -(i + 1) - 1;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }
}
