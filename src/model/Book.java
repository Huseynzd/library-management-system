package model;

import enums.BookStatus;
import enums.Category;

import java.util.logging.LogManager;

public class Book {
    private Long id;
    private String title;
    private Category category;
    private String isbn;
    private Long publishYear;
    private Long pages;
    private BookStatus status;
    private Long borrowCount;

    public Book(){};

    public Book(Long id,
                String title,
                Category category,
                String isbn,
                Long publishYear,
                Long pages, BookStatus status, Long borrowCount) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.pages = pages;
        this.status = status;
        this.borrowCount = borrowCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Long publishYear) {
        this.publishYear = publishYear;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Long getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(Long borrowCount) {
        this.borrowCount = borrowCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", isbn='" + isbn + '\'' +
                ", publishYear=" + publishYear +
                ", pages=" + pages +
                ", status=" + status +
                ", borrowCount=" + borrowCount +
                '}';
    }
}
