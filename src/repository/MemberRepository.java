package repository;

import model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member> memberList = new ArrayList<>();

    public void save(Member member) {
        memberList.add(member);
    }

    public Member findById(Long id){
        for (Member member : memberList){
            if (member.getId().equals(id)){
                return member;
            }
        }
        return null;
    }

    public List<Member> findAll(){
        return memberList;
    }

    public void delete(Member member){
        memberList.remove(member);
    }
}