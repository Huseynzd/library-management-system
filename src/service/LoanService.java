package service;

import enums.BookStatus;
import model.Book;
import model.Loan;
import model.Member;
import repository.LoanRepository;
import repository.MemberRepository;

import javax.security.auth.login.CredentialException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanService {
    private LoanRepository repository = new LoanRepository();
    private BookService bookService;
    private MemberService memberService;


    public LoanService(BookService bookService, MemberService memberService){
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public  LoanService(){}

    public void addLoan(Loan loan){
        repository.save(loan);
    }

    public void borrowBook(Long memberId, Long bookId){
        Book book = bookService.getBookById(bookId);
        Member member = memberService.getMemberById(memberId);
        if (book == null){
            System.out.println("Book not found");
            return;
        }
        if (member == null){
            System.out.println("Member not found");
            return;
        }
        Loan loan = new Loan(1L,book,member, LocalDate.now(),
                LocalDate.now().plusDays(14),
                null);
        repository.save(loan);
        if (book.getStatus() != BookStatus.BORROWED){
            book.setStatus(BookStatus.BORROWED);
        }else {
            System.out.println("Book already borrowed");
        }
    }
    public void returnBook(Long loanId){
        Loan loan = repository.findById(loanId);
        if (loan == null){
            System.out.println("Loan not found");
            return;
        }
        if (loan.getReturnDate() != null){
            System.out.println("Book is already returned");
            return;
        }
        loan.setReturnDate(LocalDate.now());
        loan.getBook().setStatus(BookStatus.AVAILABLE);
        loan.getBook();

    }
    public List<Loan> getActivesLoansByMember(Long memberId){
        List<Loan> loans = repository.findAll();
        List<Loan> activeLoans = new ArrayList<>();
        for (Loan loan : loans){
           if (loan.getMember().getId().equals(memberId) && loan.getReturnDate() == null){
               activeLoans.add(loan);
           }
        }
            return activeLoans;
    }
    public List<Loan> getLoansByMember(Long memberId){
        List<Loan> loans = repository.findAll();
        return loans.stream()
                .filter(loan -> loan.getMember().getId().equals(memberId))
                .toList();
    }
    public List<Loan> getOverDueLoans(){
        List<Loan> loans = repository.findAll();
        List<Loan> overDueLoans = new ArrayList<>();
        for (Loan loan : loans){
            if (loan.getBorrowDate().plusDays(14).isBefore(LocalDate.now())
                    && loan.getReturnDate() == null){
                overDueLoans.add(loan);
            }
        }
        return overDueLoans;
    }
    public int getAvailableBookCount(){
         return bookService.getAvailableBooks().size();
    }
    public int getBorrowedBookCount(){
        return bookService.getBorrowedBooks().size();
    }

    public List<Loan> getLoanHistory(Long memberId){
        List<Loan> loans = repository.findAll();
        List<Loan> membersLoans = new ArrayList<>();
        for (Loan loan : loans){
            if (loan.getMember().getId().equals(memberId)){
                membersLoans.add(loan);
            }
        }
        return membersLoans;
    }

}
