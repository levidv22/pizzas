package com.example.demo.app.repository;

import com.example.demo.infraestructure.entity.*;
import java.util.List;

public interface PizzaRepository {
    public List<PizzaEntity> getPizzas();
    public PizzaEntity savePizza(PizzaEntity pizza);
    public PizzaEntity getPizzaById(Integer id);
    boolean deletePizzaById(Integer id);

}
