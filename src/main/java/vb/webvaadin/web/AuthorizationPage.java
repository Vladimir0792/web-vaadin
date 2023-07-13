package vb.webvaadin.web;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import java.awt.Button;


    @Route("login")
    public class AuthorizationPage extends VerticalLayout {

        public AuthorizationPage() {
            TextField username = new TextField("Username");
            PasswordField password = new PasswordField("Password");
            Button login = new Button("Login");
            add(username, password, login);
        }

        private void add(TextField username, PasswordField password, Button login) {
        }

        private boolean authenticate(String username, String password) {
            // Здесь выполняется логика аутентификации
            return username.equals("admin") && password.equals("admin");
        }

    }

