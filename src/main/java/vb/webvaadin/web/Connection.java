package vb.webvaadin.web;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringComponent
@UIScope
class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            return user;
        });
    }

    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            return user;
        });
    }

    public void createUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, middle_name, birth_date, email, phone_number, photo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),
                user.getBirthDate(), user.getEmail(), user.getPhoneNumber());
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, middle_name = ?, birth_date = ?, " +
                "email = ?, phone_number = ?, photo = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),
                user.getBirthDate(), user.getEmail(), user.getPhoneNumber(), user.getId());
    }

    public void deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}