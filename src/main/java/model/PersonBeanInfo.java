package model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by jac on 2017-08-11.
 */
public class PersonBeanInfo extends SimpleBeanInfo {
    private final static Class myClass = Person.class;
    //
    // Note that here we create an array of 3 PropertyDescriptor
    // objects. The constructor takes just the name of the property,
    // and the bean class that implements it.
    //
    public PropertyDescriptor[] getPropertyDescriptors()
    {
        try {
            PropertyDescriptor p1 = new PropertyDescriptor("name",
                    myClass);
            PropertyDescriptor p2 = new PropertyDescriptor("surname",
                    myClass);
            PropertyDescriptor p3 = new PropertyDescriptor("salary",
                    myClass);
            Class<?> propertyType = p3.getPropertyType();
            System.out.println("propertyType:" + propertyType);

//            PropertyDescriptor pct = new PropertyDescriptor("salary",
//                    myClass);
//            PropertyDescriptor[] list = { flc, fic, pct };
            PropertyDescriptor[] list = { p1, p2, p3};
            return list;
        }
        catch (IntrospectionException iexErr)
        {
            throw new Error(iexErr.toString());
        }
    }
}
