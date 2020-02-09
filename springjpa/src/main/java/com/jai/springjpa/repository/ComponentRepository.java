package com.jai.springjpa.repository;

import com.jai.springjpa.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component,Long> {

}
