package com.demospring.springdemoproject.dao;

import com.demospring.springdemoproject.models.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select c from Cat c where c.id = ?1")
    Cat findCatById(Long id);


    @Modifying
//    @Query(value = "update Cat c set c.name = ?1 where c.id = (select Cat.id from Cat where Cat.id = ?2)")
    @Query(value = "update Cat c set c.name = ?1 where c.id = ?2")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void updateCat(String name,Long id);
}
