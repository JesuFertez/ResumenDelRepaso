package com.example.resumen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resumen.R;
import com.example.resumen.databinding.ItemLayoutBinding;
import com.example.resumen.model.ProductoModel;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.CustomViewHolder>{

    private ArrayList<ProductoModel> lista;
    public ProductoAdapter (){this.lista = new ArrayList<>();}
    public ProductoAdapter (ArrayList<ProductoModel>lista){ this.lista= lista;}

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.binData(lista.get(position)); //busca los datos
        // metodo holder, llama al metodo binData creado en linea 49 el que recibe el tv de los datos
        // declarados en el item_layout y les asigna el valor que obtiene de la clase ProductoModel
        //con el metodo get.
    }

    @Override
    public int getItemCount() { // El tamaño, del objeto, en donde se pondran los datos

        return lista.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {// Esto se hace primero en la clase

        private ItemLayoutBinding binding; // Luego esto, nos da la coneccion al item_layout

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
         binding = ItemLayoutBinding.bind(itemView);
        }

        public void binData (ProductoModel producto){
            binding.tvNombre.setText(producto.getNombre());
            binding.tvPrecio.setText(String.valueOf(producto.getPrecio()));
        }
    }
}
