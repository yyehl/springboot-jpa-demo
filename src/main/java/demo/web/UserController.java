package demo.web;


import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path="/creation", method = RequestMethod.POST)
    public void addUser(@RequestParam("name")String name,
                        @RequestParam("pwd")String password,
                        @RequestParam("age")int age) {
        userService.createUser(name, password, age);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable(value = "id")int id) {
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(value = "id")int id) {
        if (userService.findById(id) != null)
            userService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(path = "/init", method = RequestMethod.GET)
    public String init() {
        userService.init();
        return "INIT SUCCESS!";
    }
}
