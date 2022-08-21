package com.example.helloworldapi.repository;

import com.example.helloworldapi.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,Integer> {

    MyUser findByUsername(String username);
}
