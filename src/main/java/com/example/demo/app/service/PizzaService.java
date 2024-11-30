package com.example.demo.app.service;

import com.example.demo.app.repository.*;
import com.example.demo.infraestructure.entity.*;
import java.util.*;

public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getPizzas() {
        return pizzaRepository.getPizzas();
    }

    public PizzaEntity savePizza(PizzaEntity pizza) {
        return pizzaRepository.savePizza(pizza);
    }

    public PizzaEntity getPizzaById(Integer id){
        return pizzaRepository.getPizzaById(id);
    }
    public boolean deletePizzaById(Integer id){
        return pizzaRepository.deletePizzaById(id);
    }
    
    public void toggleHabilitada(Integer id) {
        PizzaEntity pizza = pizzaRepository.getPizzaById(id);
        pizza.setHabilitada(!pizza.isHabilitada());
        pizzaRepository.savePizza(pizza);
    }
}
