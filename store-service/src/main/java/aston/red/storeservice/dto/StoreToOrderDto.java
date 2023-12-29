package aston.red.storeservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreToOrderDto {

    private Long id;

    private String name;

    private String phone;

    private String address;
}
