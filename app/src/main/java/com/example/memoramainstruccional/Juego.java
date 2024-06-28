package com.example.memoramainstruccional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.crypto.SealedObject;

public class Juego extends AppCompatActivity {

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        btnVolver = findViewById(R.id.btnBack);

        setUpEvents();
    }

    private void setUpEvents() {
        btnVolver.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
    }
