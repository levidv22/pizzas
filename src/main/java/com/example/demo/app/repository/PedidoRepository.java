package com.example.demo.app.repository;

import com.example.demo.infraestructure.entity.*;

import java.util.List;

public interface PedidoRepository {
    public List<PedidoEntity> getPedidos();
    public PedidoEntity savePedido(PedidoEntity pedido);
    public PedidoEntity getPedidoById(Integer id);
    boolean deletePedidoById(Integer id);
}
