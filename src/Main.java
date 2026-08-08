import enums.BookStatus;
import enums.Category;
import model.Book;
import model.Member;
import service.BookService;
import service.LoanService;
import service.MemberService;

public class Main{
   public static void main(String[] args) {
       BookService bookService = new BookService();
       MemberService memberService = new MemberService();
       LoanService loanService = new LoanService(bookService,memberService);

       Book book1 = new Book(1L,"aa",Category.DRAMA,
               "123-456",2007L,
               123L,BookStatus.AVAILABLE,12L);
       Book book2 = new Book(1L,"bb",Category.DRAMA,"987-654",2026L,456L,
               BookStatus.AVAILABLE,31L);

       Member member1 = new Member(1L,"nihat","23123","@",123L);


       bookService.addBook(book1);
       memberService.addMember(member1);
       loanService.borrowBook(1L,1L);
       loanService.returnBook(1L);
       bookService.updateBook(1L,book2);
       System.out.println(book1);

   }

}