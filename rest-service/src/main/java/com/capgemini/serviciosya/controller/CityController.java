package com.capgemini.serviciosya.controller;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.repositories.jpa.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    ICityRepository cityDao;

    public CityController(){

        super();

    }

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.cityDao.findAll ());
    }

    @RequestMapping (value="/{id}",method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getall (@PathVariable Integer id) {

        CityEntity city= this.cityDao.findOne(id);
        if(city==null){
            return ResponseEntity.notFound().build();
        }
        // Return the value.
        return ResponseEntity.ok (city);
    }
    @RequestMapping (method = RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> add(@RequestBody CityEntity cityEntity)  {
        this.cityDao.save(cityEntity);
        return ResponseEntity.ok(cityEntity);
    }


}
