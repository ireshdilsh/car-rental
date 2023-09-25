package dto.tm;

import entity.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerTM {
    private String custid;
    private String nic;
    private String name;
    private String address;
    private Integer mobileno;
}
