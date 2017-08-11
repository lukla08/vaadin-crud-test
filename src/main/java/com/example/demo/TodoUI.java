package com.example.demo;

import com.vaadin.data.util.BeanUtil;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import crud_ui.crud.crudui.crud.CrudListener;
import crud_ui.crud.crudui.crud.impl.GridBasedCrudComponent;
import crud_ui.crud.crudui.form.impl.GridLayoutCrudFormFactory;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

@SpringUI
public class TodoUI extends UI {
    private VerticalLayout root;

    @Autowired
    ToDoLayout toDoLayout;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
    }

    private void setupLayout() {
        root = new VerticalLayout();
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);

        try {
            List<PropertyDescriptor> beanPropertyDescriptors = BeanUtil.getBeanPropertyDescriptors(Person.class);
            beanPropertyDescriptors.forEach(desc -> {
                System.out.println(desc);
            });
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

//        if (1==1)
//            return;

        GridLayoutCrudFormFactory<Person> formFactory = new GridLayoutCrudFormFactory<>(Person.class, 2, 2);

        GridBasedCrudComponent<Person> crud = new GridBasedCrudComponent<>(Person.class);
        crud.setCrudFormFactory(formFactory);
        root.addComponent(crud);

        Person p = new Person();
        crud.setCrudListener(new CrudListener<Person>() {
            @Override
            public List<Person> findAll() {
                ArrayList<Person> res = new ArrayList<>();
                res.add(p);
                return res;
            }
            @Override
            public Person add(Person user) {
                return p;
            }

            @Override
            public Person update(Person user) {
                return p;
            }

            @Override
            public void delete(Person user) {
//                backend.remove(user);
            }
        });
    }

}
