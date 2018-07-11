package demo.service;

import demo.repository.UserRepository;
import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String password, int age) {
        User user = new User(name, password, age);
        userRepository.save(user);
        return user;
    }
    public User findById(int id) {
        return userRepository.findById(id);
    }
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            createUser(String.format("tom%d", i), String.format("password%d", i), 20+i);
        }
    }
}
