package com.capgemini.serviciosya.controller;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repositories.jpa.ICityRepository;
import com.capgemini.serviciosya.repositories.jpa.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("provinces")
public class ProvinceController {

    @Autowired
    private IProvinceRepository provinceRepository;

    @Autowired
    private ICityRepository cityRepository;

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.provinceRepository.findAll ());
    }

    @RequestMapping (value="/{id}",method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable Integer id) {

        ProvinceEntity province= this.provinceRepository.findOne(id);
        if(province==null){
            return ResponseEntity.notFound().build();
        }
        // Return the value.
        return ResponseEntity.ok (province);
    }

    @RequestMapping (method = RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> add(@RequestBody ProvinceEntity provinceEntity)  {
         ProvinceEntity p= new ProvinceEntity(provinceEntity.getName(),provinceEntity.getCountry());
         this.provinceRepository.save(p);
         return ResponseEntity.ok(p);
    }

    @RequestMapping (method = RequestMethod.PUT, produces={MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update(@RequestBody ProvinceEntity provinceEntity) {
        if (this.provinceRepository.findOne(provinceEntity.getId()) != null) {
            this.provinceRepository.save(provinceEntity);
            return ResponseEntity.ok(provinceEntity);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping (value= "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id)  {
        if(this.provinceRepository.findOne(id)!=null){
            if(this.cityRepository.findAllByProvince(this.provinceRepository.findOne(id)).isEmpty()) {
                this.provinceRepository.delete(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede eliminar Provincia referenciada por Ciudad");
        }
        return ResponseEntity.notFound().build();
    }

}
