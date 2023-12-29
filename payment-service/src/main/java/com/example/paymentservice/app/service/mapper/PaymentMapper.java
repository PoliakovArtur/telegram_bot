package com.example.paymentservice.app.service.mapper;

import com.example.paymentservice.web.dto.PaymentDto;
import com.example.paymentservice.persistence.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(source = "totalPrice", target = "paymentAmount")
    Payment toEntity(PaymentDto paymentDto);
}
