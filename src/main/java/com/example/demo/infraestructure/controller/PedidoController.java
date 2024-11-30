package com.example.demo.infraestructure.controller;

import com.example.demo.app.service.*;
import com.example.demo.infraestructure.entity.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.time.format.*;
import java.util.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PizzaService pizzaService;

    public PedidoController(PedidoService pedidoService, PizzaService pizzaService) {
        this.pedidoService = pedidoService;
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public String listarPedidos(Model model) {
        List<PedidoEntity> pedidos = pedidoService.getPedidos();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy -- hh:mm a");

        // Formatear la fecha de cada pedido
        for (PedidoEntity pedido : pedidos) {
            String formattedFecha = pedido.getFecha().format(formatter);
            pedido.setFormattedFecha(formattedFecha);
        }
        model.addAttribute("pedidos", pedidos);
        return "pedidos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoPedidoForm(Model model) {
        List<PizzaEntity> pizzas = pizzaService.getPizzas().stream()
                .filter(PizzaEntity::isHabilitada)
                .toList();
        model.addAttribute("pizzas", pizzas);
        model.addAttribute("pedido", new PedidoEntity());
        return "pedidos/nuevo";
    }

    @PostMapping
    public String guardarPedido(@ModelAttribute PedidoEntity pedido) {
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/editar/{id}")
    public String editarPedidoForm(@PathVariable Integer id, Model model) {
        PedidoEntity pedido = pedidoService.getPedidoById(id);
        List<PizzaEntity> pizzas = pizzaService.getPizzas();
        model.addAttribute("pedido", pedido);
        model.addAttribute("pizzas", pizzas);
        return "pedidos/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Integer id) {
        pedidoService.deletePedidoById(id);
        return "redirect:/pedidos";
    }
}
