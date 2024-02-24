package libary;

import libary.tools.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        String path = "D:\\libary.txt";
        ArrayList<Book> books = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            while (true) {
                try {
                    Object ob = objectInputStream.readObject();
                    books.add((Book) ob);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                catch (EOFException e) {
                        break;
                }
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int n ;
        do{
            System.out.println("#############");
            System.out.println("1.查找书籍");
            System.out.println("2.新增图书");
            System.out.println("3.删除图书");
            System.out.println("4.显示图书");
            System.out.println("5.修改图书");
            System.out.println("6.退出系统");
            System.out.println("#############");
            System.out.println("请选择你想要进行的操作：");
            n = new Scanner(System.in).nextInt();
            switch(n){
                case 1:
                    new Find().func(books);
                    break;
                case 2:
                    new Add().func(books);
                    break;
                case 3:
                    new Delete().func(books);
                    break;
                case 4:
                    new View().func(books);
                    break;
                case 5:
                    new modify().func(books);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("输入错误请重新输入");
            }

        }while(n != 6);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            for (Book book : books) {
                objectOutputStream.writeObject(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
