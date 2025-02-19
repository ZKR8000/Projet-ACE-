package org.sid.car.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarDto {
    String model;
    String color;
    String matricul;
    double price;
}
