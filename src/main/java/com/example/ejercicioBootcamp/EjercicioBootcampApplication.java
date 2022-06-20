package com.example.ejercicioBootcamp;

import com.example.ejercicioBootcamp.modelo.Laptop;
import com.example.ejercicioBootcamp.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioBootcampApplication {

	public static void main(String[] args) {

		///SpringApplication.run(EjercicioBootcampApplication.class, args);

		ApplicationContext context = SpringApplication.run(EjercicioBootcampApplication.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Lenovo", "2020");
		Laptop laptop2 = new Laptop(null, "MSI", "2050");


		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);

	}

}
