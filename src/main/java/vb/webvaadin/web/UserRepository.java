package vb.webvaadin.web;

import com.vaadin.flow.data.provider.DataProvider;

import java.util.Optional;
// данный класс подразумевает список пользователей и методы для добавления, удаления и получения пользователей по их идентификатору или всего списка пользователей.
public class UserRepository {
    public DataProvider<User, Void> findAll() {
        return null;
    }

    public Optional<Object> findById(Long id) {

        return null;
    }

    public User save(User user) {
        return user;
    }

    public void delete(User user) {
    }
}
