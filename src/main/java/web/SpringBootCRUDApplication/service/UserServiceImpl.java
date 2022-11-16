package web.SpringBootCRUDApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.SpringBootCRUDApplication.UserDAO.UserDAO;
import web.SpringBootCRUDApplication.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(int id, User updateUser) {
        userDAO.update(id, updateUser);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }
}
