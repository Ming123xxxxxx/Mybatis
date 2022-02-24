package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/17 8:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String name;
    //一个老师拥有多个学生
    private List<Student> students;
}
