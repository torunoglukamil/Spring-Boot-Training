package com.example.public_transport_demo.service;

import java.util.List;

public interface BaseService<Entity, Dto> {

    Dto create(Dto dto);

    Dto update(Dto dto);

    void deleteById(Long id);

    Dto getById(Long id);

    List<Dto> getAll();

    Entity findById(Long id);

    Long getId(Entity entity);

}
