package com.example.resumen.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.resumen.R;

import com.example.resumen.databinding.FragmentAgregarBinding;
import com.example.resumen.model.ProductoModel;
import com.example.resumen.presenter.AgregarPresenter;
import com.example.resumen.presenter.AgregarPresenterImplement;
import com.example.resumen.presenter.AgregarView;

import java.util.ArrayList;


public class AgregarFragment extends Fragment implements AgregarView {
    private FragmentAgregarBinding binding;
    private AgregarPresenterImplement presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        intBinding(inflater, container);
        initPresenter();
        btnAgregar();
        btnListar();


        return binding.getRoot();
    }


    private void intBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentAgregarBinding.inflate(inflater, container, false);
    }

    private void initPresenter() {
        presenter = new AgregarPresenterImplement(this);
    }

    private void btnAgregar() {
        binding.btnAgregar.setOnClickListener(v -> {

            String nombre = binding.edtNombre.getText().toString();
            String precio = binding.txtiPrecio.getEditText().getText().toString();
            presenter.agregar(nombre, precio);
        });
    }

    private void btnListar() {
        binding.btnListar.setOnClickListener(v -> {     // ir al otro fragment

            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_agregarFragment_to_listarFragment);
        });

    }


    @Override
    public void mostrarConfirmar() {
        Toast.makeText(getContext(), "Producto agregado exitosamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarError() {
        Toast.makeText(getContext(), "Error al agregar producto", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void limpiarCampos() {
        binding.edtNombre.getText().clear();
        binding.txtiPrecio.getEditText().getText().clear();

    }


}