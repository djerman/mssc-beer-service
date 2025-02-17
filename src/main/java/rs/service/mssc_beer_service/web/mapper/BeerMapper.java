package rs.service.mssc_beer_service.web.mapper;

import org.mapstruct.Mapper;

import rs.service.mssc_beer_service.domain.Beer;
import rs.service.mssc_beer_service.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    
    Beer beerDtoToBeer(BeerDto beerDto);
    
}
