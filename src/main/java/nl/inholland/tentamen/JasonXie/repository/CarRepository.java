package nl.inholland.tentamen.JasonXie.repository;

import nl.inholland.tentamen.JasonXie.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("SELECT c FROM Car c JOIN c.driver d WHERE d.wonBefore = :wonBefore")
    List<Car> findByDriversWonBefore(boolean wonBefore);
}
