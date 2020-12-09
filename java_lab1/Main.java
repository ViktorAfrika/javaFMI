import model.*;

import java.io.File;
import java.time.LocalDate;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        model.Buyer buyer = new model.Buyer.Builder()
                .setName("")
                .setSurname("")
                .setEmail("example@gmail.com")
                .setPhone("+380 6600 000 00")
                .build();

        model.Employee employee = new model.Employee.Builder()
                .setName("Petro")
                .setSurname("Petrov")
                .setBDay(LocalDate.now())
                .setSalary(15000)
                .setPosition("programer")
                .setAddress("Shevchenka.str")
                .setPhone("+380 5000 000 00")
                .build();

        model.Order order = new model.Order.Builder()
                .setEmployee(employee)
                .setBuyer(buyer)
                .setOkay(LocalDate.now())
                .build();

        System.out.println(employee.getFirstName() + "\n");

        System.out.println("Info about Employee:\n" + order.getEmployee());
    }
}



