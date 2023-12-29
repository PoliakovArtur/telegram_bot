package com.javaintensive.telegrambot.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Store {
    private Long id;
    private String description;
    private String address;
    private String name;
    private String phoneNumber;
}
