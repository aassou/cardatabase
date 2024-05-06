package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository<Car, Long>, CrudRepository<Car, Long> {
    List<Car> findByBrand(@Param("brand") String brand);

    List<Car> findByModel(@Param("model") String model);

    List<Car> findByColor(@Param("color") String color);

    List<Car> findByModelYear(@Param("modelYear") int modelYear);
}
