package crud_ui.crud.crudui.crud;

import java.io.Serializable;

/**
 * @author Alejandro Duarte.
 */
@FunctionalInterface
public interface DeleteOperationListener<T> extends Serializable {

    void perform(T domainObject);

}
