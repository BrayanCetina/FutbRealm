package com.example.futbrealm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class cancha extends AppCompatActivity {
    ProgressBar barra;
    TextView txtUser;
    TextView txtMarcador;
    ImageView img;
    int contador =0;
    public static int ESPERA=60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha);
        txtUser = findViewById(R.id.textUserCancha);
        txtMarcador = findViewById(R.id.textContador);
        img = findViewById(R.id.imageView5);
        Bundle datos = this.getIntent().getExtras();
        String User = datos.getString("user");
        txtUser.setText(User);
        esperarYCerrar(ESPERA);

    }

    public void esperarYCerrar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                finalizarjuego();
            }
        }, milisegundos);
    }
    public void finalizarjuego() {
        Intent cancha = new Intent(this, Marcador.class);
        startActivity(cancha);
        finish();    }

    public void Apreto(View view) {
        try {

            contador = contador + 1;
            txtMarcador.setText(Integer.toString(contador));


            ((ViewGroup)img.getParent()).removeView(img);
            RelativeLayout layout= (RelativeLayout) findViewById(R.id.cacha2_xml);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(190, 190);
            int left = (int) (Math.random() * 950) + 90;
            int top = (int) (Math.random() * 550) + 1;
            params.leftMargin = left;
            params.topMargin = top;
            //Carga imagen de recursos
            layout.addView(img,-1, params);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error\n"+e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
