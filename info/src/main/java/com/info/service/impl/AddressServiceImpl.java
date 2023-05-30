package com.info.service.impl;

import com.info.entities.Address;
import com.info.exception.IdProofNotFoundException;
import com.info.payload.AddressDTO;
import com.info.repositories.AddressRepository;
import com.info.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }
    @Override
    public AddressDTO updateAddressById(Long id, String street, String city) {
        Address address = addressRepository.findById(id).orElseThrow(
                ()-> new IdProofNotFoundException("Address not found")
        );
        address.setCity(city);
        address.setStreet(street);

        Address updatedAddress = addressRepository.save(address);

        AddressDTO dto = new AddressDTO();
        dto.setId(updatedAddress.getId());
        dto.setStreet(updatedAddress.getStreet());
        dto.setCity(updatedAddress.getCity());

        return dto;
    }
}
