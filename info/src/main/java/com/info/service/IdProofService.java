package com.info.service;

import com.info.payload.IdProofDTO;

public interface IdProofService {
    public IdProofDTO updatePancardNumberById(Long id, String pancardNumber);
}
