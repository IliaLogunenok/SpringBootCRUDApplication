package web.SpringBootCRUDApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.SpringBootCRUDApplication.model.User;
import web.SpringBootCRUDApplication.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        Optional<User> foundUser = userRepository.findById(id);

        return foundUser.orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(int id, User updateUser) {
        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}