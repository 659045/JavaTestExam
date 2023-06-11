package nl.inholland.tentamen.JasonXie.controller;

import nl.inholland.tentamen.JasonXie.model.Car;
import nl.inholland.tentamen.JasonXie.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> findByDriversWonBefore(@RequestParam("wonBefore") boolean wonBefore) {
        return carService.getCarByDriversWonBefore(wonBefore);
    }

    @GetMapping("/sum")
    public int getSumOfTopSpeed() {
        return carService.getSumOfTopSpeed();
    }
}
