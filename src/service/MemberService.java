package service;

import model.Member;
import repository.MemberRepository;

import java.util.List;

public class MemberService {
    private MemberRepository repository = new MemberRepository();

    public void addMember(Member member){
        repository.save(member);
    }

    public Member getMemberById(Long id){
        return repository.findById(id);
    }

    public List<Member> getAllMembers(){
        return repository.findAll();
    }

    public void deleteMember(Member member){
        repository.delete(member);
    }
}
