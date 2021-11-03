package com.example.resumen.presenter;

import com.example.resumen.model.ProductoModel;

import java.util.ArrayList;

public interface AgregarPresenter {
    boolean agregar (String nombre, String precio);
    ArrayList <ProductoModel> getListaProductos();
}
