package com.example.resumen.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.resumen.R;
import com.example.resumen.model.RegistroProducto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static RegistroProducto lista = new RegistroProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}