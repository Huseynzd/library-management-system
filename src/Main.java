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
               123L,BookStatus.AVAILABLE,12L,"Mezahir");
       Book book2 = new Book(1L,"bb",Category.DRAMA,"987-654",2026L,456L,
               BookStatus.AVAILABLE,31L,"Nihat");

       Member member1 = new Member(1L,"nihat","23123","@",123L);


       System.out.println(bookService.getAvailableBooks());

   }

}