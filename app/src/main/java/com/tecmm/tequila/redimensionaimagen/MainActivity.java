package com.tecmm.tequila.redimensionaimagen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    SeekBar seekBar;
    private int iWidth = 65;
    private int iHeight = 52;
    float density ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        density = displayMetrics.densityDpi;

        imagen = (ImageView) findViewById(R.id.imageView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

/// Evento para redimensionar la pantalla
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float ancho = (progress + iWidth) * density / 160;
                float alto = (progress + iHeight) * density / 160;
                imagen.getLayoutParams().height = (int)alto;
                imagen.getLayoutParams().width = (int)ancho;
                imagen.requestLayout();

                if (progress == 0) {
                    Toast.makeText(MainActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                }
                else if (progress == 100) {
                    Toast.makeText(MainActivity.this, "llego al limite", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
