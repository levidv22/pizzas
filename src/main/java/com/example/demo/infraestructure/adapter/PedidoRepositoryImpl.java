package com.example.demo.infraestructure.adapter;

import com.example.demo.app.repository.*;
import com.example.demo.infraestructure.entity.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoCrudRepository pedidoCrudRepository;
    public PedidoRepositoryImpl(PedidoCrudRepository pedidoCrudRepository) {
        this.pedidoCrudRepository = pedidoCrudRepository;
    }
    @Override
    public List<PedidoEntity> getPedidos() {
        return (List<PedidoEntity>)pedidoCrudRepository.findAll();
    }

    @Override
    public PedidoEntity savePedido(PedidoEntity pedido) {
        return pedidoCrudRepository.save(pedido);
    }

    @Override
    public PedidoEntity getPedidoById(Integer id) {
        return pedidoCrudRepository.findById(id).get();
    }

    @Override
    public boolean deletePedidoById(Integer id) {
        pedidoCrudRepository.deleteById(id);
        return true;
    }
}
