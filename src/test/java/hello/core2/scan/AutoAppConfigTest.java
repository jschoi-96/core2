package hello.core2.scan;

import hello.core2.AutoAppConfig;
import hello.core2.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        // ClassPathBeanDefinitionScanner -> MemberServiceImpl.class (식별)
        // Creating shared instance of singleton bean 'autoAppConfig'와 같이 싱글톤 빈 생성


    }
}
