package model;
import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {

        Buyer buyer = new Buyer.Builder()
                .setName("Viktor")
                .setSurname("Surname")
                .setBDay(LocalDate.now())
                .setEmail("example@gmail.com")
                .setPhone("+380 6600 000 00")
                .build();

        Employee employee = new Employee.Builder()
                .setName("Petro")
                .setSurname("Petrov")
                .setBDay(LocalDate.now())
                .setSalary(15000)
                .setPosition("programer")
                .setAddress("Shevchenka.str")
                .setPhone("+380 5000 000 00")
                .build();

        Order order = new Order.Builder()
                .setEmployee(employee)
                .setBuyer(buyer)
                .setOkay(LocalDate.now())
                .build();

        System.out.println(employee.getFirstName() + "\n");

        System.out.println("Info about Employee:\n" + order.getEmployee());
    }
}
