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

    public void updateBook(Long id, Book updatedBook){
        Book book = repository.findById(id);
        if (book == null){
            System.out.println("Book not found");
            return;
        }
        book.setTitle(updatedBook.getTitle());
        book.setPages(updatedBook.getPages());
        book.setBorrowCount(updatedBook.getBorrowCount());
        book.setIsbn(updatedBook.getIsbn());
        book.setPublishYear(updatedBook.getPublishYear());
    }
}
