package dto.tm;

import entity.CarCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CarTM {
    private String carid;
    private String brand;
    private String model;
    private Integer vehino;
    private String year;
    private Double priceperday;
    private CarCategoryEntity carCategoryEntity;
}
