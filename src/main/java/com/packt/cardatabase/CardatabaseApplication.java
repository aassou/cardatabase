package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(
            CardatabaseApplication.class
    );

    private final CarRepository carRepository;

    private final OwnerRepository ownerRepository;

    public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("------------ Application Started ------------");
    }

    @Override
    public void run(String... args) throws Exception {
        // Add owner objects and save these to db
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        carRepository.save(
            new Car(
                "Mercedes",
                "G Class",
                "Black",
                "49990-A-50",
                2018,
                1200000,
                owner1
            )
        );
        carRepository.save(
            new Car(
                "Mercedes",
                "220 C",
                "Grey",
                "69050-A-50",
                2002,
                100000,
                owner1
            )
        );
        carRepository.save(
            new Car(
                "Audi",
                "Q7",
                "Blue",
                "485795-B-1",
                2022,
                1300000,
                owner2
            )
        );
        carRepository.save(
            new Car(
                "Hyundai",
                "ix35",
                "Brown",
                "5748-A-50",
                2012,
                110000,
                owner2
            )
        );

        for (Car car: carRepository.findAll()) {
            logger.info("Brand: {}, Model: {}", car.getBrand(), car.getModel());
        }
    }
}
