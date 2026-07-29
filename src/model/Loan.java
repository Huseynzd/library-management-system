package model;

import java.time.LocalDate;

public class Loan {
    private Long id;
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

}
