package hello.core2.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository = new MemoryMemberRepository(); // 구현체에 의존 (DIP 위반)
    private final MemberRepository memberRepository;

    @Autowired // 마치 ac.getBean(MemberRepository.class) 자동으로 코드가 들어감.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // MemoryMemberRepo에 대한 정보가 없고 오로지 멤버서비스 인터페이스에 대한 정보만 존재
    // 추상화에 의존하므로 DIP 위반에서 벗어남.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
