package com.example.resumen.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.resumen.R;
import com.example.resumen.databinding.FragmentListarBinding;
import com.example.resumen.model.ProductoModel;
import com.example.resumen.presenter.ListarPresenterImplement;
import com.example.resumen.presenter.ListarView;

import java.util.ArrayList;


public class ListarFragment extends Fragment implements ListarView {

 private FragmentListarBinding binding;
 private ListarPresenterImplement presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initBinding(inflater,container);

        initPresenter();
        accionVolver();

    return binding.getRoot();
    }


    private void initBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentListarBinding.inflate(inflater,container,false);
    }

    private void initPresenter() {
        presenter= new ListarPresenterImplement(this);
        presenter.generarLista(getContext());

    }

    private void accionVolver() {
        binding.btnVolver.setOnClickListener(v ->{
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_listarFragment_to_agregarFragment);
        });
    }

    @Override
    public void mostrarLista(RecyclerView.Adapter adapter, RecyclerView.LayoutManager layout) {
        binding.rvLista.setLayoutManager(layout);
        binding.rvLista.setAdapter(adapter);

    }

}