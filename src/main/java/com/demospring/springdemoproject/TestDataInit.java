package com.demospring.springdemoproject;

import com.demospring.springdemoproject.dao.CatRepo;
import com.demospring.springdemoproject.dao.RoleRepo;
import com.demospring.springdemoproject.dao.UserRepo;
import com.demospring.springdemoproject.models.entity.Cat;
import com.demospring.springdemoproject.models.entity.Dog;
import com.demospring.springdemoproject.models.entity.autorizations.Role;
import com.demospring.springdemoproject.models.entity.autorizations.User;
import com.demospring.springdemoproject.service.interfaces.DogService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
@Data
public class TestDataInit {

    public CatRepo catService;
    public DogService dogService;

    public UserRepo userRepo;
    public RoleRepo roleRepo;

    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public TestDataInit(CatRepo catService, DogService dogService, UserRepo userRepo, RoleRepo roleRepo,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.catService = catService;
        this.dogService = dogService;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostConstruct
    public void initDemoEntity() {

        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat();
            cat.setName("Cat " + i);
            catService.save(cat);

            Dog dog = new Dog();
            dog.setName("Dog " + i);
            dogService.save(dog);
        }
        Role adminRole = new Role();
        Role userRole = new Role();

        adminRole.setName("ROLE_ADMIN");
        userRole.setName("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(adminRole);
        roleSet.add(userRole);

        User user = new User();
        user.setUsername("user");
        user.setPassword(bCryptPasswordEncoder.encode("user"));
        user.setRoles(roleSet);
        roleRepo.save(adminRole);
        roleRepo.save(userRole);
        userRepo.save(user);


    }


}
