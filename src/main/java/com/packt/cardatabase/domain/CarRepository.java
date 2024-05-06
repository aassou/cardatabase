package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>, CrudRepository<Car, Long> {
    List<Car> findByBrand(String brand);

    List<Car> findByModel(String model);

    List<Car> findByColor(String color);

    List<Car> findByModelYear(int modelYear);
}
