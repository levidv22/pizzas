package com.example.demo.app.service;

import com.example.demo.app.repository.*;
import com.example.demo.infraestructure.entity.*;
import java.time.*;
import java.util.*;

public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoEntity> getPedidos() {
        return pedidoRepository.getPedidos();
    }

    public PedidoEntity savePedido(PedidoEntity pedido) {
        if (pedido.getId() == null) {
            // Nuevo pedido
            pedido.setFecha(LocalDateTime.now());
        } else {
            // Actualizar pedido existente
            PedidoEntity existingPedido = pedidoRepository.getPedidoById(pedido.getId());
            if (existingPedido != null) {
                pedido.setFecha(existingPedido.getFecha()); // Preserva la fecha original
            } else {
                pedido.setFecha(LocalDateTime.now()); // Si no existe, asigna nueva fecha
            }
        }
        return pedidoRepository.savePedido(pedido);
    }

    public PedidoEntity getPedidoById(Integer Id) {
        return pedidoRepository.getPedidoById(Id);
    }

    public boolean deletePedidoById(Integer Id) {
        return pedidoRepository.deletePedidoById(Id);
    }
}
