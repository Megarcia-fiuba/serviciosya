package com.capgemini.serviciosya.rest;

import com.capgemini.serviciosya.repositories.jpa.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("country")
public class CountryController {

    @Autowired
    private ICountryRepository countryRepository=null;

    public CountryController() {

        super ();
    }

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.countryRepository.findAll ());
    }


}
