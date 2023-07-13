package vb.webvaadin.web;

import com.vaadin.flow.data.provider.DataProvider;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DataProvider<User, Void> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return (User) userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}