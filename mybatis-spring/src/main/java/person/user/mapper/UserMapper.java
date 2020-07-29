package person.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import person.user.entity.User;

@Mapper
public interface UserMapper {
    List<User> findAll();
}
