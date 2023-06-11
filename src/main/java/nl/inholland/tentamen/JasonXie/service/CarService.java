package nl.inholland.tentamen.JasonXie.service;

import jakarta.persistence.EntityNotFoundException;
import nl.inholland.tentamen.JasonXie.model.Car;
import nl.inholland.tentamen.JasonXie.model.Driver;
import nl.inholland.tentamen.JasonXie.model.dto.CarDTO;
import nl.inholland.tentamen.JasonXie.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final DriverService driverService;

    public CarService(CarRepository carRepository, DriverService driverService) {
        this.carRepository = carRepository;
        this.driverService = driverService;
    }

    public List<Car> getAllCars() {
        try {
            return (List<Car>) carRepository.findAll();
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No cars found");
        }
    }

    public List<Car> addCars(List<CarDTO> cars) {
        List<Car> carList = cars.stream().map(this::mapDTOToCar).toList();
        return (List<Car>) carRepository.saveAll(carList);
    }

    public List<Car> getCarByDriversWonBefore(boolean wonBefore) {
        return carRepository.findByDriversWonBefore(wonBefore);
    }

    public Car mapDTOToCar(CarDTO carDTO) {
        Driver driver = driverService.getDriverById(carDTO.getDriverId());
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setTopSpeed(car.getTopSpeed());
        car.setDriver(driver);

        return car;
    }

    public int getSumOfTopSpeed() {
        List<Car> cars = (List<Car>) carRepository.findAll();
        return cars.stream()
                .mapToInt(Car::getTopSpeed)
                .sum();
    }
}
