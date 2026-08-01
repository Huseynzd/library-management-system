package repository;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> bookList = new ArrayList<>();

    public void save(Book book){
        bookList.add(book);
    }

    public Book findById(Long id){
        for (Book book : bookList){
            if (book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }
    public List<Book> findAll(){
        return bookList;
    }

    public void delete(Book book){
        bookList.remove(book);
    }



}
