
package tests;

import Entities.Book;
import Entities.Student;
import java.util.ArrayList;
import java.util.List;
import services.BookService;
import services.StudentService;

public class TestClass {
    public static void main(String[] args) {
        StudentService studentService=new StudentService();
        Student st=studentService.findById(5);
        System.out.println(st);
        List<Book> books=new ArrayList<Book>();
        for(Book b:st.getBookList()){
            if(b.getIsbn()!=11){
                books.add(b);
            }
        }
        st.setBookList(books);
        System.out.println(st);
        studentService.update(st);
    }
}
