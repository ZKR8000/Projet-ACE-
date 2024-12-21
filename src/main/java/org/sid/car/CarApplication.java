package org.sid.car;

import org.sid.car.dto.CarDto;
import org.sid.car.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@Bean
	CommandLineRunner start( CarService carService) {
		return args -> {
			carService.saveCars(
					List.of(
							CarDto.builder().model("Model A").color("Blue").matricul("ABC123").price(15000).build(),
							CarDto.builder().model("Model B").color("Red").matricul("XYZ456").price(20000).build(),
							CarDto.builder().model("Model C").color("Black").matricul("LMN789").price(25000).build(),
							CarDto.builder().model("Model D").color("White").matricul("PQR321").price(30000).build()
					)
			);
		};
	}
}
