package org.sid.car.service;

import lombok.AllArgsConstructor;
import org.sid.car.dao.entities.Car;
import org.sid.car.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CarService {
    public CarDto saveCar( CarDto carDto);

    public boolean deleteCar(Long id);

    public List<CarDto> getCarByModel( String model);

    public List<CarDto> getCarByModelAndPrice(String model, double price);

    public List<CarDto> saveCars(List<CarDto> carDtos);

}
