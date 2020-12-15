package DataBases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Postgres {
    private static final String create = "CREATE TABLE IF NOT EXISTS %s(id serial, %s, PRIMARY KEY(id));";
    private static final String drop = "DROP TABLE IF EXISTS %s";

    private static final String employee = "Employee";
    private static final String animal = "Animal";
    private static final String aviary = "Aviary";
    private static final String vaccine = "Vaccine";

    private static final String animal_create_attribute = "type varchar(15), sex varchar(6), dateOfbirth date, name varchar(15)";
    private static final String employee_create_attribute = "name varchar(15), surname varchar(15), dateOfbirth date";
    private static final String aviary_create_attribute = "type varchar(10), capacity int4";
    private static final String vaccine_create_attribute = "vaccineType varchar(10), disease varchar(15), name varchar(20)";



    private static void Execute(String query) throws SQLException {
        Connection connection = СonnectPostgres.Connect();
        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            СonnectPostgres.Disconnect(connection);
        }
    }

    public static void createEmployee() throws SQLException {
        Execute(String.format(create, employee, employee_create_attribute));
    }

    public static void dropEmployee() throws SQLException {
        Execute(String.format(drop, employee));
    }

    public static void createAnimal() throws SQLException {
        Execute(String.format(create, animal, animal_create_attribute));
    }

    public static void dropAnimal() throws SQLException {
        Execute(String.format(drop, animal));
    }

    public static void createAviary() throws SQLException {
        Execute(String.format(create, aviary, aviary_create_attribute));
    }

    public static void dropAviary() throws SQLException {
        Execute(String.format(drop, aviary));
    }

    public static void createVaccine() throws SQLException {
        Execute(String.format(create, vaccine, vaccine_create_attribute));
    }

    public static void dropVaccine() throws SQLException {
        Execute(String.format(drop, vaccine));
    }



}


