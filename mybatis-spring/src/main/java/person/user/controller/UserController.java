//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package person.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.user.entity.User;
import person.user.service.UserService;

@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @RequestMapping({"/findAll"})
    public List<User> findAll() {
        return this.userService.findAll();
    }
}
