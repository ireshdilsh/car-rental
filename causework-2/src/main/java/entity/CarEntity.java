package entity;

import dto.CarCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @Column(name = "CarID",nullable = false)
    private String carid;

    @Column(name = "Brand",nullable = false)
    private String brand;

    @Column(name = "Model",nullable = false)
    private String model;

    @Column(name = "Vehicle_NO",nullable = false,length = 4)
    private Integer vehino;

    @Column(name = "Year",nullable = false)
    private String year;

    @Column(name = "PricePerDay",nullable = false)
    private Double priceperday;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Category_ID",nullable = false)
    private CarCategoryEntity carCategoryEntity;

    @ToString.Exclude
    @OneToMany(mappedBy = "carEntity", targetEntity = RentEntity.class)
    private List<RentEntity> rentEntityList;


}
