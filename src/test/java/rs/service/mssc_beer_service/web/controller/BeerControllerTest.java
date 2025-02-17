package rs.service.mssc_beer_service.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import rs.service.mssc_beer_service.web.model.BeerDto;
import rs.service.mssc_beer_service.web.model.BeerStyleEnum;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    
    @Test
    void testGetBeerById() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk());
    }

    @Test
    void testSaveNewBeer() throws Exception {
	BeerDto beerDto = getValidBeerDto();
	String beerDtoToJson = objectMapper.writeValueAsString(beerDto);
	
	mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(beerDtoToJson))
	.andExpect(status().isCreated());
    }

    @Test
    void testUpdateBeerById() throws Exception {
	BeerDto beerDto = getValidBeerDto();
	String beerDtoToJson = objectMapper.writeValueAsString(beerDto);
	
	mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
		.contentType(MediaType.APPLICATION_JSON)
		.content(beerDtoToJson))
	.andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto() {
	return BeerDto.builder()
		.beerName("Pale ale")
		.beerStyle(BeerStyleEnum.ALE)
		.upc(123123123123L)
		.price(new BigDecimal("2.99"))
		.build();
    }
}
