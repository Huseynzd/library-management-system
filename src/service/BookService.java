package service;

import enums.BookStatus;
import enums.Category;
import model.Book;
import repository.BookRepository;

import java.util.ArrayList;
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
    public List<Book> searchByTitle(String title){
        List<Book> books = new ArrayList<>();
        for (Book book : repository.findAll()){
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())){
                books.add(book);
            }
        }
        return books;
    }
    public List<Book> searchByAuthor(String author){
        List<Book> books = new ArrayList<>();
        for (Book book : repository.findAll()){
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())){
                books.add(book);
            }
        }
        return books;
    }
    public List<Book> searchBYCategory(Category category){
        List<Book> books = new ArrayList<>();
        for (Book book : repository.findAll()){
            if (book.getCategory().equals(category)){
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> getAvailableBooks(){
      return repository.findAll()
              .stream()
              .filter(book -> book.getStatus().equals(BookStatus.AVAILABLE))
              .toList();
    }

    public List<Book> getBorrowedBooks(){
        return repository.findAll()
                .stream()
                .filter(book -> book.getStatus().equals(BookStatus.BORROWED))
                .toList();
    }


}
