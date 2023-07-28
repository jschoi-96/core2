package hello.core2.order;

import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.FixDiscountpolicy;
import hello.core2.discount.RateDiscountPolicy;
import hello.core2.member.*;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    // = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//
//    // 바꾸는 순간 -> OCP 위반임.

    private DiscountPolicy discountPolicy; // 인테페이스에만 의존한다!!

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 먼저 조회하고 나서
        int discountPrice = discountPolicy.discount(member, itemPrice); // 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
