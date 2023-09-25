package dto;

import entity.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarCategoryDto {
    private String categoryid;
    private String name;
    private List<CarEntity> carEntities=new ArrayList<>();

}
