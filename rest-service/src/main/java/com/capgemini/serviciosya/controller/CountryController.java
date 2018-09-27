
package com.capgemini.serviciosya.controller;


import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repositories.jpa.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("countries")
public class CountryController {


    @Autowired
    private ICountryRepository countryDao;


    public CountryController () {

        super ();
    }


    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.countryDao.findAll ());
    }

    @RequestMapping (value="/{id}",method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable Integer id) {

        CountryEntity country= this.countryDao.findOne(id);
        if(country==null){
            return ResponseEntity.notFound().build();
        }
        // Return the value.
        return ResponseEntity.ok (country);
    }

    @RequestMapping (method = RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> add(@RequestBody CountryEntity countryEntity)  {
        this.countryDao.save(countryEntity);
        return ResponseEntity.ok(countryEntity);
    }
}