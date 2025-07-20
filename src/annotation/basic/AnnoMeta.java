package annotation.basic;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface AnnoMeta {
    // 1. 자바 실행 중에도 애노테이션 정보가 남음
    // 2. Method와 Type에 적용
    // 3. API 문서를 만들 떄 해당 애노테이션이 포함
}
