package org.sid.car.dao.repo;

import org.sid.car.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByModel(String model);
    List<Car> findByPrice(double price);
    List<Car> findByModelAndPriceLessThanEqual(String model, double price);
    List<Car> findByPriceGreaterThanEqual(double price);
    List<Car> findByModelContaining(String keyword);
}
