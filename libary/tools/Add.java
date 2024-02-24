package libary.tools;

import libary.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Add implements operations{
    @Override
    public void func(ArrayList<Book> BookList) {
        System.out.println("输入添加书籍的信息");
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("名称：");
        book.setName(scanner.next());
        System.out.println("作者：");
        book.setAuthor(scanner.next());
        System.out.println("类型：");
        book.setKind(scanner.next());
        System.out.println("出版年：");
        book.setYear(scanner.next());
        BookList.add(book);
        System.out.println("修改完毕");
    }
}
