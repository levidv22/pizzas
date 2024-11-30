package com.example.demo.infraestructure.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cliente;
    private String direccion;
    private LocalDateTime fecha;
    private String formattedFecha;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private PizzaEntity pizza;

    public PedidoEntity() {
    }

    public PedidoEntity(Integer id, String cliente, String direccion, LocalDateTime fecha, String formattedFecha, PizzaEntity pizza) {
        this.id = id;
        this.cliente = cliente;
        this.direccion = direccion;
        this.fecha = fecha;
        this.formattedFecha = formattedFecha;
        this.pizza = pizza;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public PizzaEntity getPizza() {
        return pizza;
    }

    public void setPizza(PizzaEntity pizza) {
        this.pizza = pizza;
    }

    public String getFormattedFecha() {
        return formattedFecha;
    }

    public void setFormattedFecha(String formattedFecha) {
        this.formattedFecha = formattedFecha;
    }

}
