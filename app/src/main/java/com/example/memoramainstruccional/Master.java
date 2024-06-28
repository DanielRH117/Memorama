package com.example.memoramainstruccional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Master extends AppCompatActivity {


    ImageButton img0, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15;
    ImageButton[] tablero = new ImageButton[16];
    Button btnR, btnEx;
    TextView txtP;
    int puntuacion;
    int aciertos;

    int[] imagenes;
    int fondo;

    ArrayList<Integer> arrayDesordenado;
    ImageButton primero;
    int noPrimero, noSegundo;
    boolean bloqueo = false;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        init();
    }

    private void cargarTablero(){
        img0 = findViewById(R.id.btn00);
        img1 = findViewById(R.id.btn01);
        img2 = findViewById(R.id.btn02);
        img3 = findViewById(R.id.btn03);
        img4 = findViewById(R.id.btn04);
        img5 = findViewById(R.id.btn05);
        img6 = findViewById(R.id.btn06);
        img7 = findViewById(R.id.btn07);
        img8 = findViewById(R.id.btn08);
        img9 = findViewById(R.id.btn09);
        img10 = findViewById(R.id.btn10);
        img11 = findViewById(R.id.btn11);
        img12 = findViewById(R.id.btn12);
        img13 = findViewById(R.id.btn13);
        img14 = findViewById(R.id.btn14);
        img15 = findViewById(R.id.btn15);

        tablero[0] = img0;
        tablero[1] = img1;
        tablero[2] = img2;
        tablero[3] = img3;
        tablero[4] = img4;
        tablero[5] = img5;
        tablero[6] = img6;
        tablero[7] = img7;
        tablero[8] = img8;
        tablero[9] = img9;
        tablero[10] = img10;
        tablero[11] = img11;
        tablero[12] = img12;
        tablero[13] = img13;
        tablero[14] = img14;
        tablero[15] = img15;
    }

    private void cargarBotones(){
        btnR = findViewById(R.id.btnRe);
        btnEx = findViewById(R.id.btnEx);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });

        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void cargarTexto(){
        txtP = findViewById(R.id.txtP);
        puntuacion = 0;
        aciertos = 0;
        txtP.setText("Puntuación: " + puntuacion);
    }

    private void cargarImagenes(){
        imagenes = new int[]{
                R.drawable.la0,
                R.drawable.la1,
                R.drawable.la2,
                R.drawable.la3,
                R.drawable.la4,
                R.drawable.la5,
                R.drawable.la6,
                R.drawable.la7
        };
        fondo = R.drawable.fondo;
    }

    private ArrayList<Integer> barajar(int longitud){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<longitud*2; i++){
            result.add(i % longitud);
        }
        Collections.shuffle(result);
        //System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    private void comprobar(int i, final ImageButton imgb){
        if(primero == null){
            primero = imgb;
            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(imagenes[arrayDesordenado.get(i)]);
            primero.setEnabled(false);
            noPrimero = arrayDesordenado.get(i);
        } else {
            bloqueo = true;
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(imagenes[arrayDesordenado.get(i)]);
            imgb.setEnabled(false);
            noSegundo = arrayDesordenado.get(i);
            if(noPrimero == noSegundo){
                primero = null;
                bloqueo = false;
                aciertos++;
                puntuacion++;
                txtP.setText("Puntuación: " + puntuacion);
                if (aciertos == imagenes.length){
                    Toast toast = Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(fondo);
                        primero.setEnabled(true);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(fondo);
                        imgb.setEnabled(true);
                        bloqueo = false;
                        primero = null;
                        puntuacion--;
                        txtP.setText("Puntuación: " + puntuacion);
                    }
                }, 500);
            }
        }
    }

    private void init(){
        cargarTablero();
        cargarBotones();
        cargarTexto();
        cargarImagenes();
        arrayDesordenado = barajar(imagenes.length);
        for (int i=0; i< tablero.length; i++){
            tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            tablero[i].setImageResource(imagenes[arrayDesordenado.get(i)]);
            //tablero[i].setImageResource(fondo);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i< tablero.length; i++){
                    tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    //tablero[i].setImageResource(imagenes[arrayDesordenado.get(i)]);
                    tablero[i].setImageResource(fondo);
                }
            }
        }, 500);
        for (int i=0; i< tablero.length; i++){
            final int j = i;
            tablero[i].setEnabled(true);
            tablero[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!bloqueo)
                        comprobar(j,tablero[j]);
                }
            });
        }
    }
}
