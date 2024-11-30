package com.example.demo.infraestructure.controller;

import com.example.demo.app.service.*;
import com.example.demo.infraestructure.entity.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public String listarPizzas(Model model) {
        List<PizzaEntity> pizzas = pizzaService.getPizzas();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/lista";
    }

    @GetMapping("/nueva")
    public String nuevaPizzaForm(Model model) {
        model.addAttribute("pizza", new PizzaEntity());
        return "pizzas/nueva";
    }

    @PostMapping
    public String guardarPizza(@ModelAttribute PizzaEntity pizza) {
        pizzaService.savePizza(pizza);
        return "redirect:/pizzas";
    }

    @GetMapping("/editar/{id}")
    public String editarPizzaForm(@PathVariable Integer id, Model model) {
        PizzaEntity pizza = pizzaService.getPizzaById(id);
        model.addAttribute("pizza", pizza);
        return "pizzas/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPizza(@PathVariable Integer id, Model model) {
        try {
            boolean eliminado = pizzaService.deletePizzaById(id);
            if (!eliminado) {
                model.addAttribute("error", "No se puede eliminar la pizza porque ya ha sido pedida. Use el botón 'Deshabilitar'.");
            }
        } catch (Exception e) {
            model.addAttribute("error", "No se puede eliminar la pizza porque ya ha sido pedida. Use el botón 'Deshabilitar'.");
        }
        model.addAttribute("pizzas", pizzaService.getPizzas());
        return "pizzas/lista";
    }

    @PostMapping("/toggle/{id}")
    public String toggleHabilitada(@PathVariable Integer id) {
        pizzaService.toggleHabilitada(id);
        return "redirect:/pizzas";
    }
}
