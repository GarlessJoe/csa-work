import java.util.Scanner;
import java.util.ArrayList;

public class honework {

    public static void showTriangle(int n){
        for(int i = 0 ; i < n;i++){
           for(int j = n - i - 1;j > 0;j--){
               System.out.print(" ");
           }
           for( int k = 0;k < 2*(i-1) + 1;k++){
               System.out.print("*");
           }
            System.out.println();
        }
    }
    public static void reverseSUM(String s){
        char[] chars = s.toCharArray();

        System.out.println("你输入的整数的位数为：" + chars.length);
        char[] chars2 = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            chars2[i] = chars[chars.length-i-1];
        }
        String s1 = String.valueOf(chars2);
        System.out.println("你输入的整数的逆序是：" + s1);
    }
    public static void isPalindrome(int num){
        boolean flag = true;
        char[] s = String.valueOf(num).toCharArray();
        for(int i = 0;i<s.length/2;i++){
            if(s[i] != s[s.length - i - 1]){
                flag = false;
            }
        }
        if (flag) {
            System.out.println("是的") ; } else
            System.out.println("不是") ;
    }
    public static void ShuiXianHua(){
        ArrayList<Integer> ints = new ArrayList();
        for(int i = 100;i<1000;i++){
            int g = i%10;
            int s = i/10%10;
            int b = i/100;
            if(i == g*g*g + s*s*s + b*b*b){
                ints.add(i);
            }
        }
        System.out.print("所有的水仙花数如下：");
        for(Integer key:ints){
            System.out.print(key + " ");
        }
    }
    public static void arraysDemo() { //操作
        int[] ints = new int[10];
        System.out.println("输入数组元素");
        for(int i = 0;i<10;i++){
            ints[i] = new Scanner(System.in).nextInt();
        }
        int max = ints[0] ,min = ints[0];
        for(int i = 0;i<10;i++){
            if(ints[i] > max ){
                max = ints[i];
            }
            if(ints[i]< min){
                min = ints[i];
            }
        }
        System.out.println("最大值" + max + "最小值" + min );
        int j = max - min;
        System.out.println("max - min = " + j);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1、B 2、B 3、D 4、C 5、D");
        //System.out.print("请输入你想要打印的等腰三角形的行数：");
        //int n =  scanner.nextInt();
        //showTriangle(n);
        //System.out.println("请输入一个整数:");
        //reverseSUM(scanner.next());
        //isPalindrome(scanner.nextInt());
        //ShuiXianHua();
        //arraysDemo()
    }
}
