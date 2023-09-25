package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDto {

    private String rentid;
    private Date from_date;
    private Date to_date;
    private Double total;
    private boolean isreturn;
    private Double balance;
    private Double refundeposit;
    private Double advancespay;
    private Double perdayrent;
    private CustomerDto customerDto;
    private CarDto carDto;

}
