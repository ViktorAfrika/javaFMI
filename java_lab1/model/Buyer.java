package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.util.Objects;


public class Buyer {
    /**
     * First name of Buyer
     */
    private String firstName;
    /**
     * Last name of Buyer
     */
    private String lastName;
    /**
     * Birth day of Buyer
     */
    private LocalDate bDay;
    /**
     * Phone of Buyer
     */
    private String phone;
    /**
     * Email of Buyer
     */
    private String email;


    /**
     *  GETTERS / SETTERS   begin
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

    public LocalDate getBDay() {
        return bDay;
    }

    public void setBirthDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     *  GETTERS / SETTERS end
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buyer buyer = (Customer) o;

        if (!Objects.equals(firstName, buyer.firstName)) return false;
        if (!Objects.equals(lastName, buyer.lastName)) return false;
        if (!Objects.equals(bDay, buyer.bDay)) return false;
        if (!Objects.equals(email, buyer.email)) return false;
        return Objects.equals(phone, buyer.phone);
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName +
                "\nLastName: " + lastName +
                "\nBDay: " + bDay +
                "\nEmail:" + email +
                "\nPhone:" + phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, bDay, email, phone);
    }


    public static final class Builder {
        private Buyer newCustomer;

        public Builder() {
            newCustomer = new Customer();
        }

        public Builder setName(String firstName){
            newCustomer.firstName = firstName;
            return this;
        }

        public Builder setSurname(String lastName){
            newBuyer.lastName = lastName;
            return this;
        }

        public Builder setBDay(LocalDate bDay){
            newBuyer.bDay = bDay;
            return this;
        }

        public Builder setEmail(String email){
            newBuyer.email = email;
            return this;
        }

        public Builder setPhone(String phone){
            newBuyer.phone = phone;
            return this;
        }

        public Buyer build(){
            return newBuyer;
        }

    }
}

