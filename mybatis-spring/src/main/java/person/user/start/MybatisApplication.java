//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package person.user.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"person.user"})
@MapperScan({"person.user.mapper"})
public class MybatisApplication {
    public MybatisApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
