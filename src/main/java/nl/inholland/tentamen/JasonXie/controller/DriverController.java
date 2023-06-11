package nl.inholland.tentamen.JasonXie.controller;

import nl.inholland.tentamen.JasonXie.model.Driver;
import nl.inholland.tentamen.JasonXie.service.DriverService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/drivers")
public class DriverController{
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("{id}")
    public Driver getDriverById(@PathVariable Long id) {
        return driverService.getDriverById(id);
    }


}
