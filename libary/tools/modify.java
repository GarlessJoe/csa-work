package libary.tools;

import libary.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class modify implements operations{
    @Override
    public void func(ArrayList<Book> BookList) {
        System.out.println("请输入你想要修改的图书");
        String name = new Scanner(System.in).next();
        System.out.println("请输入你想要修改的标签(书名/作者/类型/出版年)：");
        String s = new Scanner(System.in).next();
        for(int i = 0; i < BookList.size(); i++){
            if(name.equals( BookList.get(i).getName())){
                switch (s) {
                    case "书名":
                        System.out.println("重新设置书名");
                        BookList.get(i).setName(new Scanner(System.in).next());
                                    break;
                    case "作者":
                        String s1 = new Scanner(System.in).next();
                        System.out.println("重新设置作者");BookList.get(i).setAuthor(s1);
                                    break;
                    case "类型":
                        System.out.println("重新设置类型");BookList.get(i).setKind(new Scanner(System.in).next());
                                 break;
                    case "出版年":
                        System.out.println("重新设置出版年");BookList.get(i).setYear(new Scanner(System.in).next());
                                    break;
                    default:
                        System.out.println("非法输入");
                }
            }
        }
    }
}
