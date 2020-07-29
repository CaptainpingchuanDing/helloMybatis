package person.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import person.user.entity.User;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> findAll();
}