package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 현재 AutoAppConfig 파일이 등록되어 있는 패키지와 하위 패키지의 클래스들을 스캔해서 @Component가
// 붙어 있는 클래스를 찾아서 스프링 컨테이터에 Bean으로 등록해준다.
// AppConfig에 등록한 Configuration 클래스 제외
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
        Configuration.class))
public class AutoAppConfig {
}
