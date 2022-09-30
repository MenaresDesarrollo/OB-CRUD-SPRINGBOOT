package com.ejercicio.DemoOBSB;

import com.ejercicio.DemoOBSB.entities.Laptop;
import com.ejercicio.DemoOBSB.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;


@SpringBootApplication
public class DemoObsbApplication {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoObsbApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Dell", "aspire", "i5", 220.0, LocalDate.of(2018, 12, 1), true);
		Laptop laptop2 = new Laptop(null, "Acer", "nova", "i5", 200.0, LocalDate.of(2020, 9, 4), true);

		System.out.println("Num libros en base de datos: " + repository.findAll().size());

		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println("Num libros en base de datos: " + repository.findAll().size());

	}
}
