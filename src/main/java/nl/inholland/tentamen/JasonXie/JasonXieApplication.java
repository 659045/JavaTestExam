package nl.inholland.tentamen.JasonXie;

import nl.inholland.tentamen.JasonXie.model.Driver;
import nl.inholland.tentamen.JasonXie.model.dto.CarDTO;
import nl.inholland.tentamen.JasonXie.model.enums.Ranking;
import nl.inholland.tentamen.JasonXie.service.CarService;
import nl.inholland.tentamen.JasonXie.service.DriverService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@SpringBootApplication
public class JasonXieApplication {

	private static DriverService driverService;
	private static CarService carService;

	public JasonXieApplication(DriverService driverService, CarService carService) {
		this.driverService = driverService;
		this.carService = carService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JasonXieApplication.class, args);
		try{
			question2();

			question3();

			question4();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void question2() throws IOException {
		driverService.addDrivers(Files
				.readAllLines(Paths.get("drivers.csv"))
				.stream()
				.map(line -> line.split(","))
				.map(data -> new Driver(
						data[0],
						data[1],
						Ranking.valueOf(data[2]),
						Integer.parseInt(data[3]),
						Boolean.parseBoolean(data[4])
				))
				.collect(Collectors.toList()));

		driverService.getAllDrivers().forEach(System.out::println);
	}

	public static void question3() throws IOException {
		carService.addCars(Files
				.readAllLines(Paths.get("cars.csv"))
				.stream()
				.map(line -> line.split(","))
				.map(data -> new CarDTO(
						data[0],
						Long.parseLong(data[1])
				))
				.collect(Collectors.toList()));

		carService.getAllCars().forEach(System.out::println);
	}

	public static void question4() {
		int sum = carService.getSumOfTopSpeed();
		System.out.println(sum);
	}


}
