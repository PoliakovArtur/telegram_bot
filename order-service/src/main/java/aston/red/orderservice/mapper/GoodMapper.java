package aston.red.orderservice.mapper;

import aston.red.orderservice.dto.GoodDto;
import aston.red.orderservice.dto.OrdersGoodsShortsDto;
import aston.red.orderservice.entity.OrderGoodsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GoodMapper {

    @Mapping(target = "name", source = "entity.goodName")
    GoodDto toGoodDto(OrderGoodsEntity entity);


    OrdersGoodsShortsDto toOrdersGoodsShortsDto(OrderGoodsEntity orderGoodsEntity);

}
