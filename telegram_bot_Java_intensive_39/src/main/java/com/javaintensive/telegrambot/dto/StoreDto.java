package com.javaintensive.telegrambot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class StoreDto {

    private Long id;
    private String description;
    private String address;
    private String name;
    private String phoneNumber;
}
