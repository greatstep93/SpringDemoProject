package com.demospring.springdemoproject.service.impl;

import com.demospring.springdemoproject.dao.DogRepo;
import com.demospring.springdemoproject.models.entity.Dog;
import com.demospring.springdemoproject.service.interfaces.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepo dogRepo;

    @Autowired
    public DogServiceImpl(DogRepo dogRepo) {
        this.dogRepo = dogRepo;
    }

    @Override
    public Dog getDogById(Long id) {

        return dogRepo.findDogById(id);
    }

    @Override
    public void save(Dog dog) {
        dogRepo.save(dog);
    }

    @Override
    public void delete(Dog dog) {
        dogRepo.delete(dog);
    }

    @Override
    public void update(Dog dog) {
        dogRepo.saveAndFlush(dog);
    }

    @Override
    public void deleteById(Long id) {
        dogRepo.deleteById(id);
    }


}
