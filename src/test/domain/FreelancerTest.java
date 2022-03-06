package domain;

import domain.Freelancer;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Year;

public class FreelancerTest {
    public static void main(String[] args) {
        //Freelancer Gubensauer – f : € 1600.0 / Stundensatz: € 35.0
        Freelancer freelancer = new Freelancer("Gubensauer", 'f', Year.of(1980), Year.of(2020),
                                                35, 30);

        System.out.println(freelancer.toString());
    }
}
