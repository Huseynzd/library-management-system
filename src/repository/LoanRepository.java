package repository;

import model.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanRepository {
    private List<Loan> loanList = new ArrayList<>();

    public void save(Loan loan){
        loanList.add(loan);
    }

    public Loan findById(Long id){
        for (Loan loan : loanList){
            if (loan.getId().equals(id)){
                return loan;
            }
        }
        return null;
    }

    public List<Loan> findAll(){
        return loanList;
    }

    public void delete(Loan loan){
        loanList.remove(loan);
    }
}
