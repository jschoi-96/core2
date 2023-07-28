package hello.core2;

import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.FixDiscountpolicy;
import hello.core2.discount.RateDiscountPolicy;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import hello.core2.member.MemoryMemberRepository;
import hello.core2.order.OrderService;
import hello.core2.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService (){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // FixDiscountPolicy()
        return new RateDiscountPolicy(); //
    }

    // 메서드 명을 보고나서 역할을 알 수있다
}
