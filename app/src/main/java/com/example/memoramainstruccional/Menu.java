package com.example.memoramainstruccional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Menu extends AppCompatActivity {

    Button btnFacil, btnMedio, btnDificil, btnMaster, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnFacil = findViewById(R.id.btnFacil);
        btnMedio = findViewById(R.id.btnMedio);
        btnDificil = findViewById(R.id.btnDificil);
        btnMaster = findViewById(R.id.btnMaster);
        btnExit = findViewById(R.id.btnSalir);

        setUpEvents();
    }

    private void setUpEvents() {
        btnFacil.setOnClickListener(view -> {
            Intent intent = new Intent(this, Facil.class);
            Toast.makeText(this,"Dificultad Fácil",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        btnMedio.setOnClickListener(view -> {
            Intent intent = new Intent(this, Medio.class);
            Toast.makeText(this,"Dificultad Media",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        btnDificil.setOnClickListener(view -> {
            Intent intent = new Intent(this, Dificil.class);
            Toast.makeText(this, "Dificultad Difícil", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        btnMaster.setOnClickListener(view -> {
            Intent intent = new Intent(this, Master.class);
            Toast.makeText(this, "Dificultad 'Maestro'", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        btnExit.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "ByDRH for Diseño Instruccional", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}