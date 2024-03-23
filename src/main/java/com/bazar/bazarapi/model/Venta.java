package com.bazar.bazarapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cod_venta;

    // @Column(columnDefinition = "DATE") si no llega a aceptar
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_venta;

    private Double totalVta;

    @OneToMany
    @JoinTable(name = "ventas_producto",
               joinColumns = @JoinColumn(name = "cod_venta", nullable = false),
               inverseJoinColumns = @JoinColumn(name = "cod_producto", nullable = false))
    private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long cod_venta, LocalDate fecha_venta, Double totalVta, List<Producto> listaProductos) {
        this.cod_venta = cod_venta;
        this.fecha_venta = fecha_venta;
        this.totalVta = totalVta;
        this.listaProductos = listaProductos;
    }
}
