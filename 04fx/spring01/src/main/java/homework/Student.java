package homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ohYoung
 * @date 2021/2/20 13:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;

    private Integer age;

    private Integer sex;

    private String email;

    private String address;

}
