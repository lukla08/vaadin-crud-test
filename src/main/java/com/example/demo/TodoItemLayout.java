package com.example.demo;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class TodoItemLayout extends HorizontalLayout {

    private final CheckBox done;
    private final TextField text;

    private boolean usedStyle;

    public TodoItemLayout(Todo todo) {
        done = new CheckBox();

        text  = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        addComponents(done);
        addComponentsAndExpand(text);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        Button changeButton = new Button("Change");
        addComponent(changeButton);

        changeButton.addClickListener(clickEvent -> {
                text.setStyleName(usedStyle? "" : ValoTheme.TEXTFIELD_BORDERLESS);
                usedStyle = !usedStyle;
            }
        );

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);
        binder.setBean(todo);
    }
}
