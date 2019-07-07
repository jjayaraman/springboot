package com.jai.springboot.crud.repository;

import com.jai.springboot.crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, UserEntity> {
}
