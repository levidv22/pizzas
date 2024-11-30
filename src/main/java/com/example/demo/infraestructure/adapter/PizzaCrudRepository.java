package com.example.demo.infraestructure.adapter;

import com.example.demo.infraestructure.entity.*;
import java.util.*;
import org.springframework.data.repository.*;

public interface PizzaCrudRepository extends CrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findByHabilitadaTrue();
    List<PizzaEntity> findAll();
}
