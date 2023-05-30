package com.info.controller;

import com.info.payload.IdProofDTO;
import com.info.service.impl.IdProofServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/idproof")
public class IdProofController {

    private IdProofServiceImpl idProofService;

    public IdProofController(IdProofServiceImpl idProofService){
        this.idProofService = idProofService;
    }

    @PutMapping("/{id}/pancardnumber")
    public ResponseEntity<IdProofDTO> updatePancardNumberWithId(@PathVariable Long id, @RequestBody IdProofDTO dto){
        IdProofDTO idProofDTO = idProofService.updatePancardNumberById(id, dto.getPancardnumber());

        return ResponseEntity.ok(idProofDTO);
    }

}
