package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "car_category")
public class CarCategoryEntity {
    @Id
    @Column(name = "Category_ID",nullable = false)
    private String categoryid;

    @Column(name = "Catogery_Name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "carCategoryEntity",targetEntity = CarEntity.class)
    private List<CarEntity> carEntities;
}
