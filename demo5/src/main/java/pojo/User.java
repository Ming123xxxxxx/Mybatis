package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/15 10:07
 */
//@Data:自动生成无参构造,get和set方法，tostring方法，hashcode方法，equals方法
//@AllArgsConstructor:自动生成所有参数的构造器
//@NoArgsConstructor:自动生成无参构造
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String pwd;

}
