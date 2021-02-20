package homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ohYoung
 * @date 2021/2/20 13:27
 */
@Configuration
public class StudentConfig {

    @Bean
    public Student getBean01() {
        return new Student("annotationStu01", 5, 0, "aa@qq.com", "湖南");
    }

    @Bean
    public Student getBean02() {
        return new Student("annotationStu02", 58, 1, "cc@163.com", "湖北");
    }

}
