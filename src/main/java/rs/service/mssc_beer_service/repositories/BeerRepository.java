package rs.service.mssc_beer_service.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import rs.service.mssc_beer_service.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
