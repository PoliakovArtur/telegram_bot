package ru.astondevs.deliveryservice.dto.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodDto {

    @NotNull(message = "OrderId must not be null")
    private Long id;
    @NotBlank(message = "Good name must not be null")
    private String name;

    private int quantity;
}
