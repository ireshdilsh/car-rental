package dto;

import entity.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private String custid;
    private String nic;
    private String name;
    private String address;
    private Integer mobileno;
    private List<RentEntity> rentEntityList=new ArrayList<>();
}
