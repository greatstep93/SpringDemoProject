package com.demospring.springdemoproject.service.impl;

import com.demospring.springdemoproject.dao.CatRepo;
import com.demospring.springdemoproject.models.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements com.demospring.springdemoproject.service.interfaces.CatService {

    private final CatRepo catRepo;

    @Autowired
    public CatServiceImpl(CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    @Override
    public Cat getCatById(Long id) {
        return catRepo.findCatById(id);
    }

    @Override
    public void save(Cat cat) {
        catRepo.save(cat);
    }

    @Override
    public void delete(Cat cat) {
        catRepo.delete(cat);
    }

    @Override
    public void update(Cat cat) {
        catRepo.saveAndFlush(cat);
    }
}
