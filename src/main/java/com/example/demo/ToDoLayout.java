package com.example.demo;

import com.vaadin.event.FieldEvents;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.PostConstruct;
import java.util.List;

@SpringComponent
public class ToDoLayout extends VerticalLayout {
    @Autowired
    TodoRepository repo;

    @PostConstruct
    void init() {
        update();
    }

    private void setTodos(List<Todo> all) {
        removeAllComponents();
        all.forEach(todo -> addComponent(new TodoItemLayout(todo)));
    }

    public void add(Todo todo) {
        repo.save(todo);
        update();
    }

    private void update() {
        setTodos(repo.findAll());
    }

    public void deleteCompleted() {
        repo.deleteByDone(!true);
        update();
        Notification.show("deleted 2");
    }
}
