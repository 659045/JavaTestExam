package nl.inholland.tentamen.JasonXie.service;

import jakarta.persistence.EntityNotFoundException;
import nl.inholland.tentamen.JasonXie.model.Driver;
import nl.inholland.tentamen.JasonXie.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        try {
            return (List<Driver>) driverRepository.findAll();
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No drivers found");
        }
    }

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Driver with id " + id + " not found"));
    }

    public List<Driver> addDrivers(List<Driver> drivers) {
        return (List<Driver>) driverRepository.saveAll(drivers);
    }


}



