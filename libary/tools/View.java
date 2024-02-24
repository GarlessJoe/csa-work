package libary.tools;

import libary.Book;

import java.util.ArrayList;

public class View implements operations{
    @Override
    public void func(ArrayList<Book> BookList) {
        if(BookList.isEmpty()){
            System.out.println("没有书籍");
        }
        else{
        for(int i = 0;i < BookList.size();i++){
            System.out.println(BookList.get(i));
            }
        }
    }
}
