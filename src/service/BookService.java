package service;

import model.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository repository = new BookRepository();

    public void addBook(Book book){
        repository.save(book);

    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Book getBookById(Long id){
        return repository.findById(id);
    }

    public void deleteBook(Book book){
        repository.delete(book);
    }
}
