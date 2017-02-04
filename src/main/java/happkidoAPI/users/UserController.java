package happkidoAPI.users;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return UserRepository.getInstance().findAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String id) {
        return UserRepository.getInstance().findUserById(id);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public User createNewUser(@PathVariable User user) {
        return UserRepository.getInstance().createUser(user);
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST)
    public User updateNewUser(@PathVariable String id, HttpServletRequest request, User user) {
        return UserRepository.getInstance().updateUser(id, user);
    }
}