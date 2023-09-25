package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "CustID",nullable = false)
    private String custid;

    @Column(name = "NIC",nullable = false,length = 13)
    private String nic;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Address",nullable = false)
    private String address;

    @Column(name = "MobileNO",nullable = false,length = 9)
    private Integer mobileno;

    @ToString.Exclude
    @OneToMany(mappedBy = "customerEntity", targetEntity = RentEntity.class)
    private List<RentEntity> rentEntityList;
}
