package web.SpringBootCRUDApplication.service;



import web.SpringBootCRUDApplication.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User updateUser);

    void delete(int id);
}
