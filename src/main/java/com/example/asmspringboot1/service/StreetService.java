package com.example.asmspringboot1.service;

import com.example.asmspringboot1.entity.Districts;
import com.example.asmspringboot1.entity.Street;
import com.example.asmspringboot1.excreption.NotFoundException;
import com.example.asmspringboot1.repository.DistrictsRepository;
import com.example.asmspringboot1.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {
    @Autowired
    DistrictsRepository districtRepository;
    @Autowired
    StreetRepository streetRepository;

    public Street save(Street street) {
        Districts district = (Districts) districtRepository.findById(street.getDistrict_id()).orElse(null);
        if (district == null) {
            throw new NotFoundException("No district found!");
        }
        else {
            street.setDistrict(district);
            streetRepository.save(street);
        }
        return street;
    }
    public List<Street> findAll() {
        return streetRepository.findAll();
    }
}
