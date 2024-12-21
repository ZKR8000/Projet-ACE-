package org.sid.car.web;
import lombok.AllArgsConstructor;
import org.sid.car.dto.CarDto;
import org.sid.car.service.CarService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor

public class CarGraphQLController {

    private CarService carService ;
    @MutationMapping
    public CarDto saveCar( @Argument CarDto car ){return carService.saveCar(car);}
    @MutationMapping
    public Boolean deleteCar(@Argument Long id){return carService.deleteCar(id);}
    @QueryMapping
    public List<CarDto> getCarByModel( @Argument String model){return carService.getCarByModel(model);}
    @QueryMapping
    public List<CarDto> getAvionByModelAndPrice(@Argument String model, @Argument double price){return carService.getCarByModelAndPrice(model, price);}

}
