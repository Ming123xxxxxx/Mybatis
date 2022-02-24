package utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/18 9:15
 */
public class IDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void t(){
        System.out.println(getId());
    }
}
