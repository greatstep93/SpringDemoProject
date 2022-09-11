package com.demospring.springdemoproject.service.interfaces;

import com.demospring.springdemoproject.models.entity.Dog;

public interface DogService {

    Dog getDogById(Long id);

    void save(Dog dog);

    void delete(Dog dog);

    void update(Dog dog);

    void deleteById(Long id);
}
