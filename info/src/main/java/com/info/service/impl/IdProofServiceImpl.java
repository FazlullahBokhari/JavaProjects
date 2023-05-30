package com.info.service.impl;

import com.info.entities.IdProof;
import com.info.exception.IdProofNotFoundException;
import com.info.payload.IdProofDTO;
import com.info.repositories.IdProofRepository;
import com.info.service.IdProofService;
import org.springframework.stereotype.Service;

@Service
public class IdProofServiceImpl implements IdProofService {

    private IdProofRepository idProofRepository;

    public IdProofServiceImpl(IdProofRepository idProofRepository){
        this.idProofRepository = idProofRepository;
    }

    @Override
    public IdProofDTO updatePancardNumberById(Long id, String pancardNumber) {
        IdProof idProof = idProofRepository.findById(id).orElseThrow(
                ()-> new IdProofNotFoundException("Id Proof not found")
        );

        idProof.setPancardNumber(pancardNumber);

        IdProof updatedIdProof = idProofRepository.save(idProof);

        IdProofDTO dto = new IdProofDTO();
        dto.setId(updatedIdProof.getId());
        dto.setPancardnumber(updatedIdProof.getPancardNumber());

        return dto;
    }
}
