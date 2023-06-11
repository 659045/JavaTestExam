package nl.inholland.tentamen.JasonXie.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Entity
@NoArgsConstructor
@Data
@SequenceGenerator(name = "car_seq", initialValue = 9_000_001)
public class Car {

    @Id
    @GeneratedValue(generator = "car_seq")
    private long id;

    private String brand;
    private int topSpeed;

    @OneToOne
    private Driver driver;

    public int getTopSpeed() {
        return new Random().nextInt(250,300);
    }

    public Car(String brand, int topSpeed, Driver driver) {
        this.brand = brand;
        this.topSpeed = topSpeed;
        this.driver = driver;
    }
}
