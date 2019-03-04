package com.jai.springboot.crud.postgre.dao;

import com.jai.springboot.crud.postgre.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
