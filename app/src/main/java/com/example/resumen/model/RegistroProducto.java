package com.example.resumen.model;

import java.util.ArrayList;

public class RegistroProducto {

    private ArrayList<ProductoModel> productos;

    public RegistroProducto (){
        productos = new ArrayList<>();
    }
    public ArrayList <ProductoModel> getProductos(){
        return productos;
    }
    public void setProductos (ArrayList<ProductoModel>productos){
        this.productos=productos;
    }
    public boolean agregar (ProductoModel producto){
       return getProductos().add(producto);
    }
}
