package org.sid.car.service;

import lombok.AllArgsConstructor;
import org.sid.car.dao.entities.Car;
import org.sid.car.dao.repo.CarRepository;
import org.sid.car.dto.CarDto;
import org.sid.car.mapper.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto saveCar(CarDto carDto) {
        if (carDto == null) {
            throw new IllegalArgumentException("CarDto cannot be null");
        }
        Car car = carMapper.fromCarDtoToCar(carDto);
        car = carRepository.save(car);
        return carMapper.fromCarToCarDto(car);
    }

    @Override
    public boolean deleteCar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Car ID cannot be null");
        }
        if (!carRepository.existsById(id)) {
            return false; // ID does not exist
        }
        carRepository.deleteById(id);
        return true;
    }

    @Override
    public List<CarDto> getCarByModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        List<Car> cars = carRepository.findByModel(model);
        return cars.stream()
                .map(carMapper::fromCarToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarByModelAndPrice(String model, double price) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        List<Car> cars = carRepository.findByModelAndPriceLessThanEqual(model, price);
        return cars.stream()
                .map(carMapper::fromCarToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> saveCars(List<CarDto> carDtos) {
        if (carDtos == null || carDtos.isEmpty()) {
            throw new IllegalArgumentException("CarDtos cannot be null or empty");
        }
        List<Car> cars = carDtos.stream()
                .map(carMapper::fromCarDtoToCar)
                .collect(Collectors.toList());
        cars = carRepository.saveAll(cars);
        return cars.stream()
                .map(carMapper::fromCarToCarDto)
                .collect(Collectors.toList());
    }
}
