package com.example.resumen.presenter;

import android.util.Log;

import com.example.resumen.model.ProductoModel;
import com.example.resumen.model.RegistroProducto;
import com.example.resumen.view.MainActivity;

import java.util.ArrayList;

public class AgregarPresenterImplement implements AgregarPresenter {

    private RegistroProducto registro;
    private AgregarView vista;

    public AgregarPresenterImplement (AgregarView vista){
        this.registro = MainActivity.lista;
        this.vista= vista;
    }


    @Override
    public boolean agregar(String nombre, String precio) {

        if (!nombre.trim().isEmpty() && !precio.trim().isEmpty()) {
            //agregar
            ProductoModel p = new ProductoModel(nombre, Integer.parseInt(precio));
            registro.agregar(p);
            // agregar opcion 2
            // registro.agregar(new ProductoModel(nombre, Integer.parseInt(precio)));
            vista.mostrarConfirmar();
            vista.limpiarCampos();
            Log.d("Lista",registro.getProductos().toString());

            return true;

        } else {

            //no agregar
            vista.mostrarError();
            return false;

        }
    }

    @Override
    public ArrayList<ProductoModel> getListaProductos() {
        return registro.getProductos();
    }
}
