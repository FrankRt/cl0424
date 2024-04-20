package org.example.test4.service;

import org.example.test4.entity.Tool;
import org.example.test4.model.RentalAgreement;
import org.springframework.stereotype.Service;

@Service
public class RentalAgreementService {

    public RentalAgreement createRentalAgreement(Tool tool) {


        return new RentalAgreement();
    }
}
