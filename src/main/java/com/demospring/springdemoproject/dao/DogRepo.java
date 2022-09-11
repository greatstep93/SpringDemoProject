package com.demospring.springdemoproject.dao;

import com.demospring.springdemoproject.models.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends JpaRepository<Dog, Long> {
    Dog findDogById(Long id);

    void deleteById(Long id);
}
