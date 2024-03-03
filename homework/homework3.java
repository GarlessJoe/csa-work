package homework;

import java.util.Scanner;

public class homework3 {
    static int bf(String a, String b ){
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()){
            if(A[i] == B[j]){
                i ++;
                j++;
            }else{
                i=0;
                j = j - i + 1;
            }
        }
        if( i == a.length()){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1
       int a,b;
        Compute add = new add();
        Compute sub = new sub();
        Compute div = new div();
        Compute mul = new mul();
        System.out.println("输入两个数");
        a = scanner.nextInt();
        b = scanner.nextInt();
        useCompute useCompute = new useCompute();
        useCompute.useCom(add,a,b);
        useCompute.useCom(sub,a,b);
        useCompute.useCom(div,a,b);
        useCompute.useCom(mul,a,b);
        //2
        System.out.println("输入分数");
        Det.det(scanner.nextInt());
        //3
        average.cal();
        //4
        Employee employee = new Employee("小明", 18, new Mydate(2001, 02, 18)) {
            @Override
            void earnings() {

            }
        };
        System.out.println(employee.toString());

        //5
        String s = "abcde";
        String[] words =  {"a", "bb", "acd", "ace"};
        int sum = 0;
        for(int i = 0 ; i< words.length ; i++){
            if(bf(words[i] ,s) == 1){
                sum+=1;
            }
        }
        System.out.println(sum);
    }
}
interface Compute{
    int computer(int n, int m);
}
class add implements Compute{
    @Override
    public int computer(int n, int m) {
        System.out.println("加法结果为：");
        return m+n;
    }
}
class sub implements Compute{
    @Override
    public int computer(int n, int m) {
        System.out.println("减法结果为：");
        return n - m;
    }
}
class div implements Compute{
    @Override
    public int computer(int n, int m) {
        System.out.println("除法结果为：");
        try {
            int res = n/m;
            return res;
        } catch (ArithmeticException  e) {
            System.out.println("除数不能为零，除法无意义");return 0;
        }

    }
}class mul implements Compute{
    @Override
    public int computer(int n, int m) {
        System.out.println("乘法结果为：");
        return n * m;
    }
}
class useCompute{
    public void useCom(Compute com,int one, int two){
        int res = com.computer(one,two);
        System.out.println(res);
    }
}
class Det{
    public static void det(int m){
        if( m < 0 || m > 100){
            throw new RuntimeException("分数必须在0 - 100之间");
        }
        else{
            System.out.println("分数为 " + m);
        }
    }
}
class average{
    public static void cal(){
        Scanner scanner = new Scanner(System.in);
        int N;

        do{
            System.out.println("请输入N的值");
            N = scanner.nextInt();
            try {
                if(N < 0){
                    throw new RuntimeException("N必须大于0");
                }
            } catch (RuntimeException e) {
                System.out.println("请重新输入");
                N = scanner.nextInt();
            }
        }while(N < 0);
        int sum = 0;
        System.out.println("输入成绩");
        for(int i = 0; i< N;i++){
            sum += scanner.nextInt();
        }
        System.out.println("平均值为" + sum / N);
    }
}
abstract class Employee {
    private String name;
    private int age;
    private Mydate birthday;

    public Employee(String name, int age, Mydate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    abstract void earnings();
    @Override
    public String toString() {
        return "homework.Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +

                '}';
    }
}
class Mydate {
    private int year;
    private int month;
    private int day ;

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "homework.Mydate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
