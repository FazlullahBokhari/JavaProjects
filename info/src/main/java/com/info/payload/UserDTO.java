package com.info.payload;

import com.info.entities.Address;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private AddressDTO address;

}
