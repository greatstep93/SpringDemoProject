package com.demospring.springdemoproject.service.interfaces;

import com.demospring.springdemoproject.models.entity.Cat;

public interface CatService {

    Cat getCatById(Long id);

    void save(Cat cat);

    void delete(Cat cat);

    void update(Cat cat);
}
