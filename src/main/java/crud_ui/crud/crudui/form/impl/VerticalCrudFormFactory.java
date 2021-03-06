package crud_ui.crud.crudui.form.impl;

import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.ui.*;
import crud_ui.crud.crudui.crud.CrudOperation;
import crud_ui.crud.crudui.form.AbstractAutoGeneratedCrudFormFactory;

import java.util.List;

/**
 * @author Alejandro Duarte
 */
public class VerticalCrudFormFactory<T> extends AbstractAutoGeneratedCrudFormFactory<T> {

    public VerticalCrudFormFactory(Class<T> domainType) {
        super(domainType);
    }

    @Override
    public Component buildNewForm(CrudOperation operation, T domainObject, boolean readOnly, Button.ClickListener cancelButtonClickListener, Button.ClickListener operationButtonClickListener) {
        FormLayout formLayout = new FormLayout();

        Binder<T> fieldGroup = new Binder(domainObject.getClass());
        List<HasValue> fields = buildAndBind(operation, domainObject, readOnly, fieldGroup);
        fields.stream().forEach(field -> formLayout.addComponent((Component) field));

        Layout footerLayout = buildFooter(operation, domainObject, cancelButtonClickListener, operationButtonClickListener, fieldGroup);

        VerticalLayout mainLayout = new VerticalLayout(formLayout, footerLayout);
        mainLayout.setComponentAlignment(footerLayout, Alignment.BOTTOM_RIGHT);
        mainLayout.setMargin(true);

        return mainLayout;
    }

}
