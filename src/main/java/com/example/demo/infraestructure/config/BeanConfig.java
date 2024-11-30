package com.example.demo.infraestructure.config;

import com.example.demo.app.repository.*;
import com.example.demo.app.service.*;
import org.springframework.context.annotation.*;

@Configuration
public class BeanConfig {

    @Bean
    public PedidoService pedidoService(PedidoRepository pedidoRepository) {
        return new PedidoService(pedidoRepository);
    }

    @Bean
    public PizzaService pizzaService(PizzaRepository pizzaRepository) {
        return new PizzaService(pizzaRepository);
    }
}
