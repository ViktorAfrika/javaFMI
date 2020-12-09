package model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    /**
     * First name of Employee
     */
    private String firstName;
    /**
     * Last name of Employee
     */
    private String lastName;
    /**
     * Birth date of Employee
     */
    private LocalDate bDay;
    /**
     * Information about Employee Salary
     */
    private float salary;
    /**
     * Information about Employee Position
     */
    private String position;
    /**
     * Information about Employee Address
     */
    private String address;
    /**
     * Informatiion about Employee Phone
     */
    private String phone;

    /**
     * GETTER / SETTER
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return bDay;
    }

    public void setBirthDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * GETTERS / SETTERS end
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(firstName, employee.firstName)) return false;
        if (!Objects.equals(lastName, employee.lastName)) return false;
        if (!Objects.equals(bDay, employee.bDay)) return false;
        if (!Objects.equals(salary, employee.salary)) return false;
        if (!Objects.equals(position, employee.position)) return false;
        if (!Objects.equals(address, employee.address)) return false;
        return Objects.equals(phone, employee.phone);
    }


    @Override
    public String toString() {
        return "FirstName: " + firstName +
                "\nLastName: " + lastName +
                "\nBDay: " + bDay +
                "\nSalary:" + salary +
                "\nPosition:" + position +
                "\nAddress:" + address +
                "\nPhone:" + phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, bDay, salary, position, address, phone);
    }

    public static final class Builder {
        private Employee newEmployee;

        public Builder() {
            newEmployee = new Employee();
        }

        public Builder setName(String firstName){
            newEmployee.firstName = firstName;
            return this;
        }

        public Builder setSurname(String lastName){
            newEmployee.lastName = lastName;
            return this;
        }

        public Builder setBDay(LocalDate bDay){
            newEmployee.bDay = bDay;
            return this;
        }

        public Builder setSalary(float salary) {
            newEmployee.salary = salary;
            return this;
        }

        public Builder setPosition(String position) {
            newEmployee.position = position;
            return this;
        }

        public Builder setAddress(String address){
            newEmployee.address = address;
            return this;
        }

        public Builder setPhone(String phone){
            newEmployee.phone = phone;
            return this;
        }

        public Employee build() {
            return newEmployee;
        }
    }
}