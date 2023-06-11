package nl.inholland.tentamen.JasonXie.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.inholland.tentamen.JasonXie.model.enums.Ranking;

@Entity
@NoArgsConstructor
@Data
@SequenceGenerator(name = "driver_seq", initialValue = 1_000_001)
public class Driver {

    @Id
    @GeneratedValue(generator = "driver_seq")
    private long id;

    private String firstName;

    private String lastName;

    private Ranking ranking;

    private int age;

    boolean wonBefore;

    public Driver(String firstName, String lastName, Ranking ranking, int age, boolean wonBefore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ranking = ranking;
        this.age = age;
        this.wonBefore = wonBefore;
    }
}
