package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/18 9:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime;//属性名与数据库表中字段名不一致
    private int views;

}
