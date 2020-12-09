package model;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    /**
     * Information about employee
     */
    private Employee employee;
    /**
     * Information about buyer
     */
    private Buyer buyer;

    private LocalDate okay;

    /**
     * GETTER / SETTER
     */

    public Employee getEmployee(){ return employee; }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Buyer getBuyer(){
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public LocalDate getOkay(){
        return okay;
    }

    public void setOkay(LocalDate okay) {
        this.okay = okay;
    }

    /**
     * GETTER / SETTER end
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!Objects.equals(employee, order.employee)) return false;
        if (!Objects.equals(buyer, order.buyer)) return false;
        return Objects.equals(okay, order.okay);
    }

    @Override
    public String toString() {
        return  "Employee: " + employee +
                "\nBuyer: " + buyer +
                "\nokay:" + okay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, buyer, okay);
    }

    public static final class Builder {
        private Order newOrder;

        public Builder() {
            newOrder = new Order();
        }

        public Builder setEmployee(Employee employee) {
            newOrder.employee = employee;
            return this;
        }

        public Builder setBuyer(Buyer buyer) {
            newOrder.buyer = buyer;
            return this;
        }


        public Builder setOkay(LocalDate okay) {
            newOrder.okay = okay;
            return this;
        }

        public Order build() {
            return newOrder;
        }
    }
}
