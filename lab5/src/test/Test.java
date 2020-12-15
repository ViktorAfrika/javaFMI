package test;
import DataBases.Postgres;

import java.sql.SQLException;
import static java.lang.Thread.sleep;

public class Test {
    public static void main(String[] args) {

        try {
            Postgres.createAnimal();
            Postgres.createAviary();
            Postgres.createEmployee();
            Postgres.createVaccine();

            sleep(10000);

            Postgres.dropAnimal();
            Postgres.dropAviary();
            Postgres.dropEmployee();
            Postgres.dropVaccine();

        } catch (SQLException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
    }
}