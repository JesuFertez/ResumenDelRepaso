package com.example.resumen.presenter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resumen.adapter.ProductoAdapter;
import com.example.resumen.view.MainActivity;

public class ListarPresenterImplement implements ListarPresenter {

    private ListarView vista;
    public ListarPresenterImplement (ListarView vista){this.vista = vista;}

    @Override
    public void generarLista(Context context) {

        ProductoAdapter adapter = new ProductoAdapter(MainActivity.lista.getProductos());
        RecyclerView.LayoutManager layout = new LinearLayoutManager(context);

        vista.mostrarLista(adapter, layout);

    }
}
