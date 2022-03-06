package domain;

import domain.Manager;

import java.time.Year;

public class ManagerTest {
    public static void main(String[] args) {
        // Manager Schussel - m € 181500.0 / Alter: 65 Jahre
        Manager manager = new Manager("Schussel", 'm', Year.of(1955), Year.of(1990), 181500);

        System.out.println(manager.toString());
    }
}
