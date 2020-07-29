//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package person.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.user.entity.User;
import person.user.mapper.UserMapper;

@Service("userService")
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserServiceimpl() {
    }

    public List<User> findAll() {
        return this.userMapper.findAll();
    }
}
