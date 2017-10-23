package com.example.CarRepair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = {CarRepairApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
@ComponentScan("com.example.*")
public class CarRepairApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRepairApplication.class, args);
	}
}
