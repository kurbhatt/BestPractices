package org.base;

import java.util.Objects;

/**
 * Created by Keyur on 26/1/17.
 */
public class Employee {

    private Integer Id;
    private String Name;
    private Double Salary;
    private String Designation;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(Id, employee.Id) &&
                Objects.equals(Name, employee.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name);
    }
}
