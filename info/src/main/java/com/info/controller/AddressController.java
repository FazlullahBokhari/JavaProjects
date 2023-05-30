package com.info.controller;

import com.info.payload.AddressDTO;
import com.info.service.impl.AddressServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService){
        this.addressService = addressService;
    }

    @PutMapping("{id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Long id, @RequestBody AddressDTO dto){
        AddressDTO addressDTO = addressService.updateAddressById(id, dto.getStreet(), dto.getCity());

        return ResponseEntity.ok(addressDTO);
    }
}
