package com.example.public_transport_demo.mapper;

import java.util.List;

public interface BaseMapper<Entity, Dto> {

    Entity toEntity(Dto dto);

    List<Entity> toEntityList(List<Dto> dtos);

    Dto toDto(Entity entity);

    List<Dto> toDtoList(List<Entity> entities);

}
