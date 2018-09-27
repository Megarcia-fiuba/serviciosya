package com.capgemini.serviciosya.controller;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repositories.jpa.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Provinces")
public class ProvinceController {

    @Autowired
    private IProvinceRepository provinceRepository;

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.provinceRepository.findAll ());
    }

    @RequestMapping (value="/{id}",method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable Integer id) {

        ProvinceEntity city= this.provinceRepository.findOne(id);
        if(city==null){
            return ResponseEntity.notFound().build();
        }
        // Return the value.
        return ResponseEntity.ok (city);
    }

}
