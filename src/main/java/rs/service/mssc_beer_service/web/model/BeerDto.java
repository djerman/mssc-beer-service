package rs.service.mssc_beer_service.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createDate;
    @Null
    private OffsetDateTime lastModifiedDate;
    
    @NotBlank
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;
    
    @Positive
    @NotNull
    private Long upc;
    
    @Positive
    @NotNull
    private BigDecimal price;
    
    private Integer quantityOnHand;
}
