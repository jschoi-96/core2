package hello.core2.member;

public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository = new MemoryMemberRepository(); // 구현체에 의존 (DIP 위반)
    private final MemberRepository memberRepository;

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
}
