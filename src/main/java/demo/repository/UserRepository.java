package demo.repository;

import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface UserRepository extends Repository<User, Integer> {

    void save(User user);

    User findById(int id);

    void deleteById(int id);

    List<User> findAll();

}
