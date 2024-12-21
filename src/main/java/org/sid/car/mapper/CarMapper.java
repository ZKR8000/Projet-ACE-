package org.sid.car.mapper;

import org.modelmapper.ModelMapper;
import org.sid.car.dao.entities.Car;
import org.sid.car.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final ModelMapper mapper = new ModelMapper();
    public Car fromCarDtoToCar( CarDto CarDto){return mapper.map(CarDto, Car.class);}
    public CarDto fromCarToCarDto(Car car){return mapper.map(car, CarDto.class);}

}
