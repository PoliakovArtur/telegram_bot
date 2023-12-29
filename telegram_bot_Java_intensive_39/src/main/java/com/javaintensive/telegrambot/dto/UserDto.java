package com.javaintensive.telegrambot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaintensive.telegrambot.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank
    @JsonProperty("chat_id")
    private long chatId;
    @NotBlank
    @JsonProperty("nickname")
    private String nickname;
    @NotNull
    @JsonProperty("user_role")
    private Role userRole;
}
