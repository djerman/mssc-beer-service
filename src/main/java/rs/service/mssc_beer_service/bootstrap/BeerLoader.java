package rs.service.mssc_beer_service.bootstrap;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.service.mssc_beer_service.domain.Beer;
import rs.service.mssc_beer_service.repositories.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner{

    private BeerRepository beerRepository;
    
    public BeerLoader(BeerRepository beerRepository) {
	this.beerRepository = beerRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
	loadBeerObjects();
    }
    
    private void loadBeerObjects() {
	if(beerRepository.count() == 0) {
	    beerRepository.save(Beer.builder()
		    .beerName("Mango Bobs")
		    .beerStyle("IPA")
		    .quantityToBrew(200)
		    .minOnHand(20)
		    .upc(33701000001L)
		    .price(new BigDecimal("12.95"))
		    .build());
	    
	    beerRepository.save(Beer.builder()
		    .beerName("Galaxy Cat")
		    .beerStyle("PALE_ALE")
		    .quantityToBrew(200)
		    .minOnHand(20)
		    .upc(33701000002L)
		    .price(new BigDecimal("11.95"))
		    .build());
	}
	
	System.out.println("Beers loaded: " + beerRepository.count());
    }

}
