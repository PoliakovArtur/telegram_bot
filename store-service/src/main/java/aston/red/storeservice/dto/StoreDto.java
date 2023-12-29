package aston.red.storeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoreDto {

    private long id;

    private String name;

    private String description;

    private String address;

    private String phoneNumber;

    private List<ProductDto> productDtoList;
}

