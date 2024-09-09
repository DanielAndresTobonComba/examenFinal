package com.examen.examen.Domain.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "repuestos")
public class Repuesto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String descripcion;
    
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private String precio;

    @Column(columnDefinition = "int", nullable = false)
    private String stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proveedor_id", nullable = false )
    //@JsonIgnore
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo", nullable = false )
    //@JsonIgnore
    private Modelo modelo;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca", nullable = false )
    //@JsonIgnore
    private Marca marca;


    public Repuesto() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getPrecio() {
        return precio;
    }


    public void setPrecio(String precio) {
        this.precio = precio;
    }


    public String getStock() {
        return stock;
    }


    public void setStock(String stock) {
        this.stock = stock;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }


    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    public Modelo getModelo() {
        return modelo;
    }


    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }


    public Marca getMarca() {
        return marca;
    }


    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    

}
