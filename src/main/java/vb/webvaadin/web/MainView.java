package vb.webvaadin.web;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private final UserService userService;

    public MainView (UserService userService) {
        this.userService = userService;
        Grid<User> grid = new Grid<>(User.class);
        grid.setItems(userService.getAllUsers());
        grid.removeColumnByKey("id");
        add(grid);
    }

}