package rs.service.mssc_beer_service.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.service.mssc_beer_service.web.model.BeerDto;

@RequestMapping("/api/v1/beer/")
@RestController
public class BeerController {

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId){
	
	//to do impl
	return new ResponseEntity<BeerDto>(BeerDto.builder().build(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {
	
	//to do impl
	return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @PutMapping("{beerId}")
    public ResponseEntity updateBeerById(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
	
	//to do impl
	return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
