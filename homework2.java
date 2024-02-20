import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<-------第一题------->");
        Book book = new Book("Java Programming","John Smith","2022");
        book.displayInfo();
//TODO:在此编写第一题测试代码
        System.out.println("<-------第二题------->");
//TODO:在此编写第二题测试代码
        System.out.println("<-------第三题------->");
//TODO:在此编写第三题测试代码
        System.out.println("<-------第四题------->");
//TODO:在此编写第四题测试代码
        System.out.println("<-------第五题------->");
//TODO:在此编写第五题测试代码
    }
    //TODO:在此编写作业所需的方法
//第三题格式要求,在 TODO 部分实现代码
    public static String getSum(String a,String b){
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c="";
        for(int i=a.length()-1;i>=0;--i){
            la.add(a.charAt(i)-'0');
        }
        for(int i=b.length()-1;i>=0;--i){
            lb.add(b.charAt(i)-'0');
        }
//TODO:在此处编写符合要求的代码
        return c;
    }
    //第四题格式要求
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
//TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        return ans;
    }
    //第五题格式要求
    public static int trap(int[] height) {
//TODO:在此处编写符合要求的代码，并在主类中编写测试代码
//记得修改返回值，返回 0 只是暂时防止报错，非正确答案
        return 0;
    }
}
//TODO:在此处编写作业所需的类，并在主类中测试这些类
//注意相互间的继承关系
class Book
    private String name ;
    private String author;
    private String time ;

    public Book(String name, String author, String time) {
        this.name = name;
        this.author = author;
        this.time = time;
    }


    public String displayInfo() {
        return "title" + name + "," + "author" + author + ","+ "year"  + time;
    }
}
class Vehicle{
    private String brand;
    private String color;
    private String speed;
    private String wheels;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }
    void brake(){
        System.out.println("开始刹车");
    }
    void accelerate(int speed){
        System.out.println("加速至" + speed + "km/h");
    }
}
class Car extends Vehicle{
    private int loader ;

    public void setLoader(int loader) {
        this.loader = loader;
    }
    void start(){
        System.out.println("这辆卡车开始启动");
    }
}
class Truck extends Vehicle{
    private int loder ;
    private int payload;
    void start(){
        System.out.println("这辆卡车开始启动");
    }
}
class Calculator{

}