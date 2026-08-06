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

       Book book1 = new Book(1l,"aa",Category.DRAMA,
               "123-456",2007l,
               123l,BookStatus.AVAILABLE,12l);

       Member member1 = new Member(1l,"nihat","23123","@",123l);
       bookService.addBook(book1);
       memberService.addMember(member1);
       loanService.borrowBook(1l,1l);
       System.out.println(book1.getStatus());
   }
}