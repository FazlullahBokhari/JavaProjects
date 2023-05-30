package com.info.service.impl;

import com.info.entities.Address;
import com.info.entities.User;
import com.info.payload.AddressDTO;
import com.info.payload.UserDTO;
import com.info.repositories.AddressRepository;
import com.info.repositories.UserRepository;
import com.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        Address address = new Address();
        address.setStreet(userDTO.getAddress().getStreet());
        address.setCity(userDTO.getAddress().getCity());

        address = addressRepository.save(address);

        User user = new User();
        user.setAddress(address);
        user.setUsername(userDTO.getUsername());
        user = userRepository.save(user);

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());

        dto.setAddress(addressDTO);

        return dto;
    }

}

