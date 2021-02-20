import homework.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 写代码实现Spring Bean的装配, 方式越多越好(XML、Annotation都可以)
 * @author ohYoung
 * @date 2021/2/20 13:04
 */
public class BeanAssemblage02 {

    @Test
    public void getBean01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("homeworkApplicationContext.xml");
        Student student01 = (Student) context.getBean("student01");
        System.out.println(student01.toString());

        Student student02 = (Student) context.getBean("student02");
        System.out.println(student02.toString());
    }

    @Test
    public void getBean02() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("homeworkApplicationContext.xml");
        Student student01 = (Student) context.getBean("student01");
        System.out.println(student01.toString());

        Student student02 = (Student) context.getBean("student02");
        System.out.println(student02.toString());
    }
}
