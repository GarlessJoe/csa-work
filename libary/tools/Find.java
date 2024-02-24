package libary.tools;

import libary.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Find implements operations {


    @Override
    public void func(ArrayList<Book> BookList) {
        System.out.println("请输入你想要查找的书籍：");
        String name = new Scanner(System.in).next();
        int i;
        for (i = 0; i < BookList.size(); i++) {
            if ((BookList.get(i)).getName() == name) {
                System.out.println("已找到此书" + BookList.get(i));
                break;
            }
        }
        if (i == BookList.size()) {
            System.out.println("未找到此书");
        }


    }
}
