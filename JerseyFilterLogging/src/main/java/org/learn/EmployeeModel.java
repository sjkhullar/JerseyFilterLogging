package org.learn;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Employee")
public class EmployeeModel {
    public String name;
    public int age;
    public EmployeeModel() {} // JAXB needs this
 
    public EmployeeModel(String name, int age) {
        this.name = name;
        this.age = age;
    }
}