package com.info.service;

import com.info.payload.AddressDTO;

public interface AddressService {
    public AddressDTO updateAddressById(Long id, String street, String city);
}
