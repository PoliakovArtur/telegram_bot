package ru.astondevs.deliveryservice.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierDto {

    @NotBlank(message = "CourierId must not be null")
    private UUID id;
    @NotBlank(message = "ChatId must not be null")
    @JsonProperty("chat_id")
    private String chatId;
    @NotBlank(message = "Nickname must not be null")
    private String nickname;

}
