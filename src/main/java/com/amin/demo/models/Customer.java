package com.amin.demo.models;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@NoArgsConstructor
@Getter
@Setter
public class Customer {

    private String firstName;
    @NotNull(message = "is Required")
    @Size(min = 1,message = "is required")
    private String lastName;

    @Min(value = 1,message = "Minimum it should be 1")
    @Max(value = 10,message = "Maximum it should be 10")
    private int freePass;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 character/digit ")
    private String postalCode;

}
