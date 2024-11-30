package com.example.demo.infraestructure.adapter;

import com.example.demo.app.repository.*;
import com.example.demo.infraestructure.entity.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public class PizzaRepositoryImpl implements PizzaRepository {

    private final PizzaCrudRepository pizzaCrudRepository;
    public PizzaRepositoryImpl(PizzaCrudRepository pizzaCrudRepository) {
        this.pizzaCrudRepository = pizzaCrudRepository;
    }

    @Override
    public List<PizzaEntity> getPizzas() {
        return (List<PizzaEntity>)pizzaCrudRepository.findAll();
    }

    @Override
    public PizzaEntity savePizza(PizzaEntity pizza) {
        return pizzaCrudRepository.save(pizza);
    }

    @Override
    public PizzaEntity getPizzaById(Integer id) {
        return pizzaCrudRepository.findById(id).get();
    }

    @Override
    public boolean deletePizzaById(Integer id) {
        pizzaCrudRepository.deleteById(id);
        return true;
    }
}
