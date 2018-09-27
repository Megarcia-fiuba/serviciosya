
package com.capgemini.serviciosya.controller;


import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repositories.jpa.ICountryRepository;
import com.capgemini.serviciosya.repositories.jpa.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("countries")
public class CountryController {

    @Autowired
    private ICountryRepository countryDao;

    @Autowired
    private IProvinceRepository provinceRepository;

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
        CountryEntity c=new CountryEntity(countryEntity.getName());
        this.countryDao.save(c);
        return ResponseEntity.ok(c);
    }

    @RequestMapping (method = RequestMethod.PUT, produces={MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update(@RequestBody CountryEntity countryEntity) {
        if (this.countryDao.findOne(countryEntity.getId()) != null) {
            this.countryDao.save(countryEntity);
            return ResponseEntity.ok(countryEntity);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping (value= "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id)  {
        if(this.countryDao.findOne(id)!=null){
            if(this.provinceRepository.findAllByCountry(this.countryDao.findOne(id)).isEmpty()) {
                this.countryDao.delete(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede eliminar Pais referenciado por Provincia");
        }
        return ResponseEntity.notFound().build();
    }
}