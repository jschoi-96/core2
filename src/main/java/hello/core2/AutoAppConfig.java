package hello.core2;

import hello.core2.member.MemberRepository;
import hello.core2.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
        // 제외하기 위한 것 (만들어둔 AppConfig 파일)
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // Overriding bean definition for bean 'memoryMemberRepository'
    // 수동 빈이 자동 빈을 오버라이딩 해준다.

    // 하지만, Core2Application에서 실행하면 overriding is disabled. 에러가 발생한다.
}
