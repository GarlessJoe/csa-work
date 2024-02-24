package libary.tools;

import libary.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete implements operations{
    int judge = 0;
    @Override
    public void func(ArrayList<Book> BookList) {
        System.out.println("输入你想要删除的书籍");
        String name = new Scanner(System.in).next();
        for(int i = 0;i < BookList.size();i++){
            if(name.equals(BookList.get(i).getName()) ){
                BookList.remove(i);
                judge = 1;
                break;
            }
        }
        if(judge == 1) {
            System.out.println("已删除");
        }
        else{
            System.out.println("此书不存在");
        }
    }
}
