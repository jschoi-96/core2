package hello.core2.singleton;

import hello.core2.AppConfig;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    public void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회: 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 1. 조회: 호출할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != 2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        Singletonservice singletonService1 = Singletonservice.getInstance();
        Singletonservice singletonService2 = Singletonservice.getInstance();

        System.out.println("singletonService1 = " + singletonService1);


        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        // AppConfig appConfig = new AppConfig();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != 2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
